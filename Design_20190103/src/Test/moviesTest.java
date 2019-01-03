
package Test;

import com.entity.movies;

import dao.moviesDao;

public class moviesTest {
	public static void main(String[] args) {
		view();
//			insert();
//			delete();
			change();
			view();
	}

	public static void view() {
		moviesDao obj = new moviesDao();
		obj.view();
	}

	public static void insert() {
		moviesDao obj = new moviesDao();
		movies a = new movies();
		a.setMov_cou("美国");
		a.setMov_intro("蜘蛛侠平行世界");
		a.setMov_la("英语");
		a.setMov_name("蜘蛛侠");
		a.setMov_rel("2018-12-12");
		a.setMov_time("120");
		obj.insert(a);
	}

	public static void delete() {
		moviesDao obj = new moviesDao();
		obj.delete(5);
	}

	public static void change() {
		moviesDao obj = new moviesDao();
		movies a = new movies();
		a.setMov_id(2);
		a.setMov_cou("美国");
		a.setMov_intro("蜘蛛侠平行世界");
		a.setMov_la("英语");
		a.setMov_name("蜘蛛侠");
		a.setMov_rel("2018-12-12");
		a.setMov_time("120");
		obj.change(a);
	}
}
