package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GradeSystem.*;

public class CalTotalGradeTest{

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
	public void test_cal_total_grade1() throws CalTotalGradeException {
		int ID = 123456;
		Student student = system.get_student(ID);
		try {
			double total_grade = system.cal_total_grade(student);
		} catch(CalTotalGradeException e) {
		
		}
	}
	
	@Test
	public void test_cal_total_grade2() throws CalTotalGradeException {
		int ID = 123456;
		Student student = system.get_student(ID);
		try {
			double total_grade = system.cal_total_grade(student);
		} catch(CalTotalGradeException e) {
		
		}
	}
	
	 
}
