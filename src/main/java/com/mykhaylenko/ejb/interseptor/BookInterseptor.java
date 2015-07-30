package com.mykhaylenko.ejb.interseptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class BookInterseptor {

    @AroundInvoke
    public Object methodInterseptor(InvocationContext ctx) throws Exception{
        Object[] parameters = ctx.getParameters();
        String param = (String) parameters[0];
        param += "Interseptor";
        parameters[0] = param;
        ctx.setParameters(parameters);
        
        return ctx.proceed();
    }
}
