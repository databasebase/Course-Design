package Test;

import com.entity.movie_label;

import dao.movie_labelDao;

public class movie_labelTest {
	public static void main(String[] args) {
		view();
//		insert();
		delete();
//		change();
		view();
	}
	
	public static void view() {
		movie_labelDao obj = new movie_labelDao();
		obj.view();
	}
	
	public static void insert() {
		movie_labelDao obj = new movie_labelDao();
		movie_label a = new movie_label();
		a.setMovie_id(3);
		a.setLabel_id(1);
		obj.insert(a);
	}
	
	public static void delete() {
		movie_labelDao obj = new movie_labelDao();
		obj.delete(3, 1);
	}
	
	public static void change() {
		movie_labelDao obj = new movie_labelDao();
		movie_label a = new movie_label();
		
		obj.change(a);
	}
}
