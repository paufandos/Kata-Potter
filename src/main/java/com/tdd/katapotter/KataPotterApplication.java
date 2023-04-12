package com.tdd.katapotter;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KataPotterApplication {

	final int BOOK_PRICE = 8;

	final int ONE_BOOK_SIZE = 1;
	final int ONE_BOOK_DISCOUNT = 1;

	final int TWO_BOOK_SIZE = 2;
	final int TWO_BOOKS_DISCOUNT = 5;

	final int THREE_BOOK_SIZE = 3;
	final int THREE_BOOKS_DISCOUNT = 10;

	final int FOUR_BOOK_SIZE = 4;
	final int FOUR_BOOKS_DISCOUNT = 20;

	final int FIVE_BOOK_SIZE = 5;
	final int FIVE_BOOKS_DISCOUNT = 25;

	public static void main(String[] args) {
		SpringApplication.run(KataPotterApplication.class, args);
	}

	public Double getPrice(ArrayList<String> books) {
		long diferentBooks = books.stream().distinct().count();
		long repeatedBooks = books.size() - diferentBooks;
		return BOOK_PRICE * diferentBooks * getDiscount(diferentBooks) + repeatedBooks * BOOK_PRICE;
	}

	// public Double getOptimizedPrice(ArrayList<String> books) {
	// Double price = 0.0;
	// List<String> diferentBooks = new ArrayList<>();
	// List<String> tempBooks = new ArrayList<String>();
	// tempBooks = books.stream().distinct().collect(Collectors.toList());
	// List<String> equalsBooks = books;
	// do {
	// diferentBooks = equalsBooks
	// .stream()
	// .filter(i -> Collections.frequency(tempBooks, i) > 1)
	// .collect(Collectors.toList());

	// price += BOOK_PRICE * diferentBooks.size() *
	// getDiscount(diferentBooks.size());
	// equalsBooks = tempBooks;
	// tempBooks = tempBooks
	// .stream()
	// .distinct()
	// .collect(Collectors.toList());
	// } while (equalsBooks.size() != equalsBooks.stream().distinct().count());

	// price += BOOK_PRICE * equalsBooks.size() * getDiscount(equalsBooks.size());

	// return price;

	// }

	// public Double getOptimizedPrice2(ArrayList<String> books) {
	// Double price = 0.0;
	// equalsBooks = books;
	// List<String> diferentBooks = new ArrayList<String>();

	// do {
	// equalsBooks.stream().forEach(book -> {
	// if (equalsBooks.contains(book)) {
	// diferentBooks.add(book);
	// }
	// });
	// equalsBooks = diferentBooks;
	// price += BOOK_PRICE * equalsBooks.size() * getDiscount(equalsBooks.size());
	// } while (diferentBooks.size() != diferentBooks.stream().distinct().count());
	// price += BOOK_PRICE * equalsBooks.size() * getDiscount(equalsBooks.size());
	// return price;
	// }

	public Double getOptimizedPrice(ArrayList<String> books) {
		Double price = 0.0;
		Map<Object, Long> duplicates = books
				.stream()
				.collect(Collectors.groupingBy(book -> book, Collectors.counting()));
		Map<Object, Long> countedBooks = duplicates.entrySet().stream()
				.collect(Collectors.groupingBy(singleBook -> singleBook, Collectors.counting()));
		countedBooks.entrySet().stream().forEach(b -> {

		});
		return price;
	}

	public Double getDiscount(long diferentBooks) {
		Double discount = 0.0;
		if (diferentBooks >= FIVE_BOOK_SIZE && diferentBooks % FIVE_BOOK_SIZE == 0) {
			discount += FIVE_BOOKS_DISCOUNT;
			getDiscount(diferentBooks - FIVE_BOOK_SIZE);
		} else if (diferentBooks >= FOUR_BOOK_SIZE && diferentBooks % FOUR_BOOK_SIZE == 0) {
			discount += FOUR_BOOKS_DISCOUNT;
			getDiscount(diferentBooks - FOUR_BOOK_SIZE);
		} else if (diferentBooks >= THREE_BOOK_SIZE && diferentBooks % THREE_BOOK_SIZE == 0) {
			discount += THREE_BOOKS_DISCOUNT;
			getDiscount(diferentBooks - THREE_BOOK_SIZE);
		} else if (diferentBooks >= TWO_BOOK_SIZE && diferentBooks % TWO_BOOK_SIZE == 0) {
			discount += TWO_BOOKS_DISCOUNT;
			getDiscount(diferentBooks - TWO_BOOK_SIZE);
		}

		return 1 - discount / 100;
	}

}
