package com.mykhaylenko.ejb.session.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import com.mykhaylenko.ejb.session.service.LibrarySessionBeanRemote;

/**
 * Session Bean implementation class LibrarySessionBean
 */

@Stateless(mappedName = "LibrarySessionBean")
public class LibrarySessionBean implements LibrarySessionBeanRemote {

    private List<String> books;
    
    public LibrarySessionBean() {
         books = new ArrayList<String>(); 
    }

    @Override
    public List<String> getBooks() {
        return books;
    }

    @Override
    public void addBook(String name) {
        books.add(name);
    }

    @Override
    public int getLibrarySize() {
        return books.size();
    }

    @Override
    @RolesAllowed({"user"})
    public String getUserString() {
        return "User string";
    }

    @Override
    
    public String getAdminString() {
        return "Admin String";
    }

}
