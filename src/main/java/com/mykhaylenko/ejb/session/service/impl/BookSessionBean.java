package com.mykhaylenko.ejb.session.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import com.mykhaylenko.ejb.interseptor.BookInterseptor;
import com.mykhaylenko.ejb.session.service.BookSessionBeanRemote;
import com.mykhaylenko.ejb.session.service.LibrarySessionBeanRemote;


@Stateful(mappedName = "BookSessionBean")
public class BookSessionBean implements BookSessionBeanRemote {

    @EJB
    private LibrarySessionBeanRemote lib;
    
    private List<String> books;
    
    public BookSessionBean() {
        books = new ArrayList<String>();
    }
    
    @Override
    @Interceptors({BookInterseptor.class})
    public void addBook(String bookName) {
        books.add(bookName);
    }

    @Override
    public List<String> getAllBooks() {
        return books;
    }

    @Override
    public int getBooksCount() {
        return books.size() + lib.getLibrarySize();
    }

}
