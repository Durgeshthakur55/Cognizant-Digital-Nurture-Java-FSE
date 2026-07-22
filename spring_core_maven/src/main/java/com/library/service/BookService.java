package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String serviceName;

    public BookService() {}

    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("[" + (serviceName != null ? serviceName : "BookService") + "] Managing library inventory...");
        bookRepository.fetchBooks();
    }
}