package com.mykhaylenko.ejb.session.service.impl;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mykhaylenko.ejb.session.service.MathBeanRemote;

@Stateless
@WebService(serviceName = "MathService")
public class MathBeanImpl implements MathBeanRemote {

    @Override
    @WebMethod(operationName = "add")
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    @WebMethod(operationName = "multiply")
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    @WebMethod(operationName = "getHello")
    public String getHello() {
        return "Hello from EJB WebService.";
    }

}
