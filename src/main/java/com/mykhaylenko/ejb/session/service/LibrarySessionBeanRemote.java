package com.mykhaylenko.ejb.session.service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibrarySessionBeanRemote {
    
    public List<String> getBooks();
    
    public void addBook(String name);
    
    public int getLibrarySize();
    
    public String getUserString();
    
    public String getAdminString();
}
