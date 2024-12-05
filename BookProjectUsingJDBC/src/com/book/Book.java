package com.book;
public class Book {
	private int id;
	private String name;
	private double price;
	private String aname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Book() {
		
	}
	public Book(int id, String name, double price, String aname) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", aname=" + aname + "]";
	}
	
	

}
