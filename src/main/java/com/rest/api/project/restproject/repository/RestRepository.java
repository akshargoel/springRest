package com.rest.api.project.restproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.project.restproject.entity.Book;

@Repository
public interface RestRepository extends JpaRepository<Book, Integer> {
  
}
