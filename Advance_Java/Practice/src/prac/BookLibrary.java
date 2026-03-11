package prac;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookLibrary {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of books you want to add : ");
		int inputNo = sc.nextInt();
		
		System.out.println("Enter the details of the books: ");
		
		List<Book> bookList = new ArrayList<Book>();
		sc.nextLine();
		for(int i = 0; i < inputNo; i++) {
			String input = sc.nextLine();
			
			String[] inputParts = input.split(":\\s*");
			
			String tit = inputParts[0];
			String gen = inputParts[1];
			String aut = inputParts[2];
			int quan = Integer.parseInt(inputParts[3]);
			double pri = Double.parseDouble(inputParts[4]);
			
			Book b = new Book(tit, gen, aut, quan, pri);
			bookList.add(b);
		}
		
		BookLibrary l = new BookLibrary();
		
		Map<String, List<Book>> byGenre = l.retrieveBooksGroupedByGenre(bookList.stream());
		
		System.out.println("Books grouped by genre : ");
		
		byGenre.forEach((genre, books) -> {
			System.out.println(genre);
			books.forEach(book -> {
				System.out.println(book.getTitle() + " " + book.getQuantity() + " " + book.getAuthor() 
				+ " " + book.getPrice());
			});
		});
		
		System.out.print("Enter title to find author and price : ");
		String t = sc.nextLine();
		
		Map<String, Double> byTitle = l.getAuthorsAndPricesByTitle(bookList.stream(), t);
		byTitle.forEach((author, price) -> System.out.println(author + " : " + price));
		
		System.out.println("Summary : ");
		l.generateSummaryReport(bookList).forEach(System.out::println);
	}
	
	public Map<String, List<Book>> retrieveBooksGroupedByGenre(Stream<Book> books) {
		return books.collect(Collectors.groupingBy(Book::getGenre));
	}

	public Map<String, Double> getAuthorsAndPricesByTitle(Stream<Book> books, String title) {
		Map<String, Double> map = new HashMap<String, Double>();
		
		return books.filter(book -> book.getTitle().equalsIgnoreCase(title)).
				collect(Collectors.toMap(Book::getAuthor, Book::getPrice, (existing, replacement) -> existing));
	}
	
	public Stream<String> generateSummaryReport(List<Book> books) {
		int totalBooks = books.size();
		
		double totalPrice = books.stream().mapToDouble(Book::getPrice).sum();
		
		int totalQuantity = books.stream().mapToInt(Book::getQuantity).sum();
		
		return Stream.of("Total no. of books : " + totalBooks + 
				"\nTotal price of books : " + totalPrice + 
				"\nTotal quantity of books : " + totalQuantity);
	}
}

class Book{
	private String title;
	private String genre;
	private String author;
	private int quantity;
	private double  price;
	
	public Book() {

	}

	public Book(String title, String genre, String author, int quantity, double price) {
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.quantity = quantity;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}