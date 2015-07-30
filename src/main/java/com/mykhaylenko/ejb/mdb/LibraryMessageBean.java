package com.mykhaylenko.ejb.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.mykhaylenko.ejb.session.service.LibrarySessionBeanRemote;

@MessageDriven(
        mappedName="com/mykhaylenko/training/BookQueue",
        name="LibraryMessageBean",
		activationConfig = {
		        @ActivationConfigProperty(propertyName = "destinationType",
		                                  propertyValue = "javax.jms.Queue")//,
//		        @ActivationConfigProperty(propertyName = "destination",
//		                                  propertyValue = "com/mykhaylenko/training/BookQueue")
		})
public class LibraryMessageBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdctx;
    
    @EJB
    private LibrarySessionBeanRemote libraryBean;
    
    public LibraryMessageBean() {
    }
	
    public void onMessage(Message message) {
        TextMessage textMessage = null;
        
        try {
            textMessage = (TextMessage) message;
            String bookName = (String) textMessage.getText();
            libraryBean.addBook(bookName);
        } catch (JMSException e) {
            // TODO create normal runtime exception 
            e.printStackTrace();
            mdctx.setRollbackOnly();
        }
                
    }
}
