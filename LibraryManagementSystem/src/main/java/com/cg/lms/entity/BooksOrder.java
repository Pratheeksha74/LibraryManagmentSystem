package com.cg.lms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booksorder")
public class BooksOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookid")
	private Books books;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "publisherId")
	private Publishers publishers;
	
	private int quantity;
	private LocalDate orderDate;
	private String orderStatus;
	public BooksOrder() {
		super();
	}
	public BooksOrder(int orderId, Books books, Publishers publishers, int quantity, LocalDate orderDate,
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.books = books;
		this.publishers = publishers;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	
	public BooksOrder(Books books, Publishers publishers, int quantity, LocalDate orderDate,
			String orderStatus) {
		super();
		this.books = books;
		this.publishers = publishers;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public Publishers getPublishers() {
		return publishers;
	}
	public void setPublishers(Publishers publishers) {
		this.publishers = publishers;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
