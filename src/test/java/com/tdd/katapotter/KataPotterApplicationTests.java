package com.tdd.katapotter;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KataPotterApplicationTests {

	final int BOOK_PRICE = 8;

	KataPotterApplication app = new KataPotterApplication();

	@Test
	void getDiferentsBookPriceTest() {
		ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("1");

		Assertions.assertEquals(BOOK_PRICE, app.getPrice(bookList));
	}

	@Test
	void getTwoDiferentsBookPriceMustReturnFivePerCentDiscountTest() {
		final Double EXPECTED_PRICE = 15.2;
		ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("1");
		bookList.add("2");

		Assertions.assertEquals(EXPECTED_PRICE, app.getPrice(bookList));
	}

	@Test
	void getThreeDiferentsBookPriceMustReturnTenPerCentDiscountTest() {
		final Double EXPECTED_PRICE = 21.6;
		ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("1");
		bookList.add("2");
		bookList.add("3");

		Assertions.assertEquals(EXPECTED_PRICE, app.getPrice(bookList));
	}

	@Test
	void getFourDiferentsBookPriceMustReturnTwentyPerCentDiscountTest() {
		final Double EXPECTED_PRICE = 25.6;
		ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("1");
		bookList.add("2");
		bookList.add("3");
		bookList.add("4");

		Assertions.assertEquals(EXPECTED_PRICE, app.getPrice(bookList));
	}

	@Test
	void getFiveDiferentsBookPriceMustReturnTwentyFivePerCentDiscountTest() {
		final Double EXPECTED_PRICE = 30.0;
		ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("1");
		bookList.add("2");
		bookList.add("3");
		bookList.add("4");
		bookList.add("5");

		Assertions.assertEquals(EXPECTED_PRICE, app.getPrice(bookList));
	}

	@Test
	void getThreeBooksPriceTwoOfThemRepeatedMustReturnTenPerCentDiscountTest() {
		final Double EXPECTED_PRICE = 23.2;
		ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("1");
		bookList.add("1");
		bookList.add("2");

		Assertions.assertEquals(EXPECTED_PRICE, app.getPrice(bookList));
	}

	@Test
	void getHeightBooksPriceThreeOfThemRepeatedMustReturnTenPerCentDiscountTest() {
		final Double EXPECTED_PRICE = 51.2;
		ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("1");
		bookList.add("1");
		bookList.add("2");
		bookList.add("2");
		bookList.add("3");
		bookList.add("3");
		bookList.add("4");
		bookList.add("5");

		Assertions.assertEquals(EXPECTED_PRICE, app.getOptimizedPrice(bookList));
	}

}
