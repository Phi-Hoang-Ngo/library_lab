package library_lab;

import java.util.ArrayList;

public class Library {
	private String address;
	private ArrayList<String> booksAvailable;
	private ArrayList<String> bookList;

	public Library(String string) {
		this.address = string;
		this.booksAvailable = new ArrayList<String>();
		this.bookList = new ArrayList<String>();
	}

	private void addBook(String book) {
		booksAvailable.add(book);
		bookList.add(book);
	}

	public void printAddress() {
		System.out.println(address);
	}

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");

		// Add four books to the first library
		firstLibrary.addBook(new String("The Da Vinci Code"));
		firstLibrary.addBook(new String("Le Petit Prince"));
		firstLibrary.addBook(new String("A Tale of Two Cities"));
		firstLibrary.addBook(new String("The Lord of the Rings"));

		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();

		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}

	private <T> void returnBook(String book) {
		booksAvailable.add(book);
		System.out.println("You successfully returned The Lord of the Ring");
	}

	private void printAvailableBooks() {
		if (booksAvailable.isEmpty()) {
			System.out.println("No book in catalog");
		} else {
			booksAvailable.forEach((book) -> {
				System.out.println(book);
			});
		}
	}

	private void borrowBook(String string) {
		if (bookList.contains(string)) {
			if (booksAvailable.contains(string)) {
				booksAvailable.remove(string);
				System.out.println("You successfully borrowed " + string);
			} else {
				System.out.println("Sorry, this book is already borrowed.");
			}
		} else {
			System.out.println("Sorry, this book is not in our catalog.");
		}
	}

	private static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}

}