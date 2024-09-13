package com.rest.api.project.restproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.project.restproject.entity.Book;
import com.rest.api.project.restproject.repository.RestRepository;

@Service
public class ServiceClass implements ServiceInterface{

    @Autowired
    private RestRepository resp;

    @Override
    public Book getBook(int id){
        try {
			Optional<Book> optionalBook= this.resp.findById(id);
            Book oneBook = optionalBook.get();
			return oneBook;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error occurred while getting books: " + e.getMessage());
	        throw e; 
		}
    };

    @Override
    public Iterable<Book> getBooks(){
        try {
			Iterable<Book> allBooks= this.resp.findAll();
			return allBooks;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error occurred while getting books: " + e.getMessage());
	        throw e; 
		}
    };

    @Override
    public Book addBook(Book book){
        try {
			Book addBook= this.resp.save(book);
			return addBook;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error occurred while getting books: " + e.getMessage());
	        throw e; 
		}
    };

    @Override
    public Iterable<Book> deleteBook(int id){
        try {
            this.resp.deleteById(id);
			Iterable<Book> allBooks= this.resp.findAll();
			return allBooks;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error occurred while getting books: " + e.getMessage());
	        throw e; 
		}
    };

    @Override
    public Iterable<Book> deleteBooks(Iterable<Book> book){
        try {
            this.resp.deleteAll(book);
			Iterable<Book> allBooks= this.resp.findAll();
			return allBooks;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error occurred while getting books: " + e.getMessage());
	        throw e; 
		}
    };

    @Override
    public Book updateBook(int id, Book b){
        try {
			Optional<Book> optionalBook= this.resp.findById(id);
			Book book= optionalBook.get();
            book.setTitle(b.getTitle());
            book.setAuthor(b.getAuthor());
            book.setPublication(b.getPublication());
            return book;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error occurred while getting books: " + e.getMessage());
	        throw e; 
		}
    };
}
