package Test;
import com.entity.*;
import dao.*;

public class LabelTest {
	public static void main(String[] args) {
		view();
//		insert();
//		delete();
		change();
		view();
	}
	
	public static void view() {
		labelDao ab = new labelDao();
		ab.view();
	}
	
	public static void insert() {
		labelDao ac = new labelDao();
		label a = new label();
		a.setLabel_name("恐怖");
		a.setLabel_num(10);
		ac.insert(a);
	}
	
	public static void delete() {
		labelDao ac = new labelDao();
		ac.delete(4);
	}
	
	public static void change() {
		labelDao ac = new labelDao();
		label a = new label();
		a.setLabel_name("连续剧");
		a.setLabel_num(2);
		a.setLabel_id(2);
		ac.change(a);
	}
}
