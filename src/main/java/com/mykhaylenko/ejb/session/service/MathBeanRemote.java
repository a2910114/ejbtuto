package com.mykhaylenko.ejb.session.service;

import javax.ejb.Remote;

@Remote
public interface MathBeanRemote {
    
    public int add(int a, int b);
    
    public int multiply(int a, int b);
    
    public String getHello();
}
