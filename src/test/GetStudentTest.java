package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GradeSystem.*;

public class GetStudentTest {

	GradeSystem system;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		system = new GradeSystem("test_get_student_input.txt");
	}

	@After
	public void tearDown() throws Exception {
	}

	//123456 A 100 100 100 100 100
	//123454 B 10 10 10 10 10
	//123453 C 20 20 20 20 20
	//123452 D 40 30 30 40 30
	@Test
	public void test_get_student1() {
		double[] score = {100, 100, 100, 100, 100};
		String name = "A";
		int ID = 123456;
		try {
			Student student = system.get_student(ID);
			for(int i=0; i<score.length; i++) assertEquals(student.get_score(i), score[i], 0);
			assertEquals(student.get_name(), name);
			assertEquals(student.get_ID(), ID);
		} catch(NoSuchIDExecption e) {
		}
	}

	@Test(expected = NoSuchIDExecption.class) 
	public void test_get_student_with_wrong_ID() throws NoSuchIDExecption {
		int ID = 123;
		Student student = system.get_student(ID);
	}
	 
}
