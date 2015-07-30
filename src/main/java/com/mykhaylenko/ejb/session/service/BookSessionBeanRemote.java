package com.mykhaylenko.ejb.session.service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BookSessionBeanRemote {
    
    public void addBook(String bookName);
    
    public List<String> getAllBooks();
    
    public int getBooksCount();

}
