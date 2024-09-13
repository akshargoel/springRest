package com.rest.api.project.restproject.service;
import com.rest.api.project.restproject.entity.Book;


public interface ServiceInterface {
    public Book getBook(int id);
    public Iterable<Book> getBooks();
    public Book addBook(Book book);
    public Iterable<Book> deleteBook(int id);
    public Iterable<Book> deleteBooks(Iterable<Book> book);
    public Book updateBook(int id, Book b);
}
