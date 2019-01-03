package Test;

import dao.movie_starDao;
import com.entity.*;

public class movie_starTest {
	public static void main(String[] args) {
		view();
//		insert();
//		delete();
		change();
		view();
	}
	
	public static void view() {
		movie_starDao obj = new movie_starDao();
		obj.view();
	}
	
	public static void insert() {
		movie_starDao obj = new movie_starDao();
		movie_star a = new movie_star();
		a.setMovie_id(2);
		a.setUser_id(2);
		a.setStar(8);
		obj.insert(a);
	}
	
	public static void delete() {
		movie_starDao obj = new movie_starDao();
		obj.delete(2, 2);
	}
	
	public static void change() {
		movie_starDao obj = new movie_starDao();
		movie_star a = new movie_star();
		a.setMovie_id(2);
		a.setUser_id(1);
		a.setStar(8);
		obj.change(a);
	}
}
