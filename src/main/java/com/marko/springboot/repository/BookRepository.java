package com.marko.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marko.springboot.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
