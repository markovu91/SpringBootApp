package com.marko.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.marko.springboot.model.Book;
import com.marko.springboot.service.BookService;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;
	
	
	@RequestMapping("/")
	public String viewHome(Model model) {
		List<Book>books=bookService.getAllBooks();
		model.addAttribute("books", books);
		return "index";
	}
	
	@RequestMapping("/updateForm/{id}")
	public String updateForm(@PathVariable(value = "id") int id, Model model) {
		Book book = bookService.findBookById(id);
		model.addAttribute("book", book);
		return "update_book";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/";
	}
	
	@RequestMapping("/showNewBook")
	public String showNewBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
		String returnValue = "start";
		bookService.saveImage(imageFile);
		return  returnValue;
	}
	
}
