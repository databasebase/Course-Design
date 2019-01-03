package Test;
import com.entity.*;
import dao.*;

public class ActorTest {
	public static void main(String[] args) {
		view();
		change();
		view();
	}
	
	public static void view() {
		actorDao ac = new actorDao();
		ac.view();
	}
	
	public static void insert() {
		actorDao ac = new actorDao();
		actor a = new actor();
		a.setActor_name("刘凯博");
		a.setActor_intro("帅气");
		ac.insert(a);
	}
	
	public static void delete() {
		actorDao ac = new actorDao();
		ac.delete(4);
	}
	
	public static void change() {
		actorDao ac = new actorDao();
		actor a = new actor();
		a.setActor_intro("哈哈");
		a.setActor_name("丽丽");
		a.setActor_id(2);
		ac.change(a);
	}
}
