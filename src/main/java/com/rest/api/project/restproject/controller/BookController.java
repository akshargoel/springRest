package com.rest.api.project.restproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.project.restproject.entity.Book;
import com.rest.api.project.restproject.service.ServiceClass;


@RequestMapping("/api/book")
@RestController
public class BookController {
	
	@Autowired
    private ServiceClass senter;
    

    //for multiple books
    @GetMapping("/")
    public Iterable<Book> getBooks(){
        Iterable <Book> books= this.senter.getBooks();
         books.forEach(book-> System.out.println(book));
         return books;
    }

    //for single book
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return this.senter.getBook(id);
    }

    //for adding the book to database
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return this.senter.addBook(book);
    }
    
    //for deleting single book
    @DeleteMapping("/delete/{id}")
     public Iterable<Book> deleteBook(@PathVariable int id){
    	 Iterable<Book> books= this.senter.deleteBook(id);
    	 return books;
     }
    
    //for deleting multiple books
    @DeleteMapping("/delete")
     public Iterable<Book> deleteBooks(@RequestBody Iterable<Book> book){
    	Iterable<Book> books= this.senter.deleteBooks(book);
    	return books;
    }
    
    //for updating the book
    @PutMapping("/update/{id}")
     public Book updateBook(@PathVariable int id, @RequestBody Book b) {
    	 Book boo= this.senter.updateBook(id, b);
    	 return boo;
     }
    
}
