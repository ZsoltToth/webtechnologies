package hu.uni.miskolc.webtech.librarian.model;

public class BookInstance {

	private final int inventoryNo;
	private Book instanceofBook;
	private double price;

	public BookInstance(int inventoryNo, Book instanceofBook, double price) {
		super();
		this.inventoryNo = inventoryNo;
		this.instanceofBook = instanceofBook;
		this.price = price;
	}

	public int getInventoryNo() {
		return inventoryNo;
	}

	public Book getInstanceofBook() {
		return instanceofBook;
	}

	public void setInstanceofBook(Book instanceofBook) {
		this.instanceofBook = instanceofBook;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
