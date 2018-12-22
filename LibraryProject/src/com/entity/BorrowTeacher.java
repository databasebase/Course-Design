package com.entity;

public class BorrowTeacher {
	private int borrow_teacher_id;
	private int tea_id;
	private int book_id;
	private String borrow_date;
	public int getBorrow_teacher_id() {
		return borrow_teacher_id;
	}
	public void setBorrow_teacher_id(int borrow_teacher_id) {
		this.borrow_teacher_id = borrow_teacher_id;
	}
	public int getTea_id() {
		return tea_id;
	}
	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}
}
