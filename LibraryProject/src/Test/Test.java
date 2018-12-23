package Test;

import java.util.Scanner;

/**
 * This is the main test
 * @author chenmengda
 *
 */
public class Test {
	public void mainTest()
	{
		System.out.println("Welcome to the library management system");
		System.out.println("Please choose your identity(Manager Student Teacher)");
		int ideflag = 0;
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		if(str.equals("Manager")) {
			ideflag = 1;
		}
		else if(str.equals("Student")) {
			ideflag = 2;
		}
		else if(str.equals("Teacher")) {
			ideflag = 3;
		}
		StudentTest st = new StudentTest();
		ManageTest mt = new ManageTest();
		TeacherTest tt = new TeacherTest();
		switch(ideflag)
		{
		case 1:
			mt.TestManager();
			break;
		case 2:
			st.TestStudent();
			break;
		case 3:
			tt.TestTeacher();
			break;
		default:
			break;
		}
	}
	
	
}
