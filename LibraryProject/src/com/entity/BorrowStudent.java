package com.entity;

public class BorrowStudent {
	private int borrow_student_id;
	private int stu_id;
	private int book_id;
	private String borrow_date;
	public int getBorrow_student_id() {
		return borrow_student_id;
	}
	public void setBorrow_student_id(int borrow_student_id) {
		this.borrow_student_id = borrow_student_id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
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
