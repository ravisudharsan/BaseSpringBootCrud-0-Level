package com.bookmanage.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookmanage.model.Book;
public class BookDao {


	private static Map<Integer, Book> b = new HashMap<Integer, Book>();
	private static int idIndex = 3;
		
		public static Book save(Book book) {
			idIndex += idIndex;
			book.setId(idIndex);
			b.put(idIndex, book);	
			return book;
		}

		
		public static Book get(int id) {

			return b.get(id);
		}

		
		public Book delete(int id) {
			return b.remove(id);

		}

		
		public static List<Book> get() {
			return new ArrayList<Book>(b.values());
		}
	

}
