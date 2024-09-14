package com.rest.api.project.restproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Iterable<Book>> getBooks(){
        Iterable <Book> books= this.senter.getBooks();
        if(books!= null) {
        	return ResponseEntity.ok(books);        	
        }
        else {
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    //for single book
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
    	Book boo=  this.senter.getBook(id);
    	 if(boo!= null) {
         	return ResponseEntity.ok(boo);        	
         }
         else {
         	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
         }
    }

    //for adding the book to database
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
    	 Book boo= null;
       try {
    	  boo= this.senter.addBook(book);
    	  return ResponseEntity.status(HttpStatus.CREATED).body(boo);
       }
       catch (Exception e) {
    	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
    }
    
    //for deleting single book
    @DeleteMapping("/delete/{id}")
     public ResponseEntity<Iterable<Book>> deleteBook(@PathVariable int id){
    	Iterable<Book> books;
    	 try {
          books= this.senter.deleteBook(id);
       	  return ResponseEntity.status(HttpStatus.OK).body(books);
          }
          catch (Exception e) {
       	   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   	}
     }
    
    //for deleting multiple books
    @DeleteMapping("/delete")
     public ResponseEntity<Iterable<Book>> deleteBooks(@RequestBody Iterable<Book> book){
    	 try {
    		 Iterable<Book> books= this.senter.deleteBooks(book);
          	  return ResponseEntity.status(HttpStatus.OK).body(books);
             }
             catch (Exception e) {
          	   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      	}
    }
    
    //for updating the book
    @PutMapping("/update/{id}")
     public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book b) {
    	 try {
    		 Book boo= this.senter.updateBook(id, b);
          	  return ResponseEntity.status(HttpStatus.OK).body(boo);
             }
             catch (Exception e) {
          	   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
      	}
     }
    
}
