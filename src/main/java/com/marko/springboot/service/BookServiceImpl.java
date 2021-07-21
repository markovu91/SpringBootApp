package com.marko.springboot.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marko.springboot.model.Book;
import com.marko.springboot.repository.BookRepository;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}


	@Override
	public Book findBookById(int id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if (optional.isPresent()) {
			book = optional.get();
		} else {throw new RuntimeException("Book not found for id :: "+id);}
		return book;
	}


	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}


	@Override
	public void saveImage(MultipartFile imageFile) {
		String folder = "src/main/resources/static/";
		try {
			byte [] bytes =  imageFile.getBytes();
			Path path = Paths.get(folder+imageFile.getOriginalFilename());
			Files.write(path, bytes);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
