package com.bookmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookmanage.dao.BookDao;
import com.bookmanage.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookDao bookService;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView getAllBook() {
		ModelAndView mav = new ModelAndView("managebook");
		mav.addObject("books", BookDao.get());
		return mav;
	}
	
	@RequestMapping(value = "/openAddBookForm")
	public ModelAndView openAddBookForm() {
		ModelAndView mav = new ModelAndView("addbook");
		mav.addObject("book", new Book());
		return mav;
	}
	
	@RequestMapping(value = "/bookprocess")
	public ModelAndView bookProcess(@ModelAttribute("book") Book book) {
		ModelAndView mav = new ModelAndView("managebook");
		BookDao.save(book);
		mav.addObject("books", BookDao.get());
		return mav;
	}
	
	@RequestMapping(value = "/getSingleBook")
	public ModelAndView editBook(@RequestParam("bookid") int id) {
		ModelAndView mav = new ModelAndView("addbook");
		mav.addObject("book", BookDao.get(id));
		return mav;
	}
	
	@RequestMapping(value = "/deleteprocess")
	public ModelAndView deleteBook(@RequestParam("bookid") int id) {
		ModelAndView mav = new ModelAndView("managebook");
		bookService.delete(id);
		mav.addObject("books", BookDao.get());
		return mav;
	}
}
