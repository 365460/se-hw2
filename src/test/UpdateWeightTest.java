package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import GradeSystem.*;

public class UpdateWeightTest {

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
	
	
	@Test(expected = UpdateWeightExecption.class) 
	public void test_update_weight1() throws UpdateWeightExecption {
		double[] update_weight = new double[5]; 
		for(int i=0;i<5;i++){
			update_weight[i]=10;
		}		

		system.update_weight(update_weight);
	}
	
	@Test(expected = UpdateWeightExecption.class) 
	public void test_update_weight2() throws UpdateWeightExecption {
		double[] update_weight = new double[5]; 
		update_weight[0] = -20;
		update_weight[1] = 20;
		update_weight[2] = 20;
		update_weight[3] = 20;
		update_weight[4] = 60;

		system.update_weight(update_weight);
	}
	 
}
