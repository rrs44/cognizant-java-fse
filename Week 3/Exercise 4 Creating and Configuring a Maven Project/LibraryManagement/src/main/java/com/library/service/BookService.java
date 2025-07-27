package com.library;

public class BookService {
    private BookRepository bookRepository;

    // Setter for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void getBook() {
        System.out.println("Fetching book from BookService...");
        bookRepository.getBook();
    }
}
