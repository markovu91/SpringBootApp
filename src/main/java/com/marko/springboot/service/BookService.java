package com.marko.springboot.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.marko.springboot.model.Book;

public interface BookService {
	List<Book>getAllBooks();
	Book findBookById(int id);
	void saveBook(Book book);
	void saveImage(MultipartFile imageFile);
}
