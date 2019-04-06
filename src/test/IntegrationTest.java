package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import hw2.*;

public class IntegrationTest {

	@Test
	public void testQuit() {

		final ByteArrayInputStream in = new ByteArrayInputStream("Q".getBytes());
		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(in);
		System.setOut(new PrintStream(out));

		String[] args = null;
		Main.main(args);

		String out_string = out.toString();
		String ans = "Input ID or Q\r\nQuit!\r\n";
		assertEquals(out_string.length(), ans.length());
		assertEquals(out_string, ans);
	}

	@Test
	public void testRank() {

		final ByteArrayInputStream in = new ByteArrayInputStream("962001051\nR\nE\nQ\n".getBytes());
		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(in);
		System.setOut(new PrintStream(out));

		String[] args = null;
		Main.main(args);

		String out_string = out.toString();
		
		String ans = "Input ID or Q\r\n" + 
				"Welcome 李威廷\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Rank:63\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Input ID or Q\r\n" + 
				"Quit!\r\n";

		assertEquals(out_string.length(), ans.length());
		assertEquals(out_string, ans);
	}

	@Test
	public void testGrade() {

		final ByteArrayInputStream in = new ByteArrayInputStream("962001051\nG\nE\nQ\n".getBytes());
		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(in);
		System.setOut(new PrintStream(out));

		String[] args = null;
		Main.main(args);

		String out_string = out.toString();
		
		String ans = "Input ID or Q\r\n" + 
				"Welcome 李威廷\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"lab1:81.0\r\n" + 
				"lab2:32.0\r\n" + 
				"lab3:50.0\r\n" + 
				"mid-term:90.0\r\n" + 
				"final exam:93.0\r\n" + 
				"Total grade:80.5\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Input ID or Q\r\n" + 
				"Quit!\r\n";
		assertEquals(out_string.length(), ans.length());
		assertEquals(out_string, ans);
	}

	@Test
	public void testAVE() {

		final ByteArrayInputStream in = new ByteArrayInputStream("962001051\nA\nE\nQ\n".getBytes());
		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(in);
		System.setOut(new PrintStream(out));

		String[] args = null;
		Main.main(args);

		String out_string = out.toString();
		
		String ans = "Input ID or Q\r\n" + 
				"Welcome 李威廷\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Average:69.2\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Input ID or Q\r\n" + 
				"Quit!\r\n";
		assertEquals(out_string.length(), ans.length());
		assertEquals(out_string, ans);
	}

	@Test
	public void testWrongID() {

		final ByteArrayInputStream in = new ByteArrayInputStream("123\nQ\n".getBytes());
		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(in);
		System.setOut(new PrintStream(out));

		String[] args = null;
		Main.main(args);
		
		String out_string = out.toString();
		String ans = "Input ID or Q\r\n" + 
				"Wrong ID\r\n" + 
				"Input ID or Q\r\n" + 
				"Quit!\r\n";
		assertEquals(out_string.length(), ans.length());
		assertEquals(out_string, ans);
	}

	@Test
	public void testUpdateWeight() {

		String in_string = "962001051\nW\n";
		in_string += "10\n";
		in_string += "10\n";
		in_string += "10\n";
		in_string += "10\n";
		in_string += "10\n";
		in_string += "y\n";

		in_string += "10\n";
		in_string += "10\n";
		in_string += "10\n";
		in_string += "35\n";
		in_string += "35\n";
		in_string += "y\n";

		in_string += "R\n";
		in_string += "A\n";
		in_string += "G\n";

		in_string += "E\n";
		in_string += "Q\n";
		
		final ByteArrayInputStream in = new ByteArrayInputStream(in_string.getBytes());
		final ByteArrayOutputStream out = new ByteArrayOutputStream();

		System.setIn(in);
		System.setOut(new PrintStream(out));

		String[] args = null;
		Main.main(args);
		
		String out_string = out.toString();
		String ans = "Input ID or Q\r\n" + 
				"Welcome 李威廷\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Old weight\r\n" + 
				"lab1:10%\r\n" + 
				"lab2:10%\r\n" + 
				"lab3:10%\r\n" + 
				"mid-term:30%\r\n" + 
				"final exam:40%\r\n" + 
				"Input update weight.\r\n" + 
				"lab1:lab2:lab3:mid-term:final exam:Input is correct or not. [y/n]\r\n" + 
				"lab1:10%\r\n" + 
				"lab2:10%\r\n" + 
				"lab3:10%\r\n" + 
				"mid-term:10%\r\n" + 
				"final exam:10%\r\n" + 
				"Sum of update weight shoud be 100% and each of them should be greater than 0. Please try again!\r\n" + 
				"Input update weight.\r\n" + 
				"lab1:lab2:lab3:mid-term:final exam:Input is correct or not. [y/n]\r\n" + 
				"lab1:10%\r\n" + 
				"lab2:10%\r\n" + 
				"lab3:10%\r\n" + 
				"mid-term:35%\r\n" + 
				"final exam:35%\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Rank:63\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Average:69.2\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"lab1:81.0\r\n" + 
				"lab2:32.0\r\n" + 
				"lab3:50.0\r\n" + 
				"mid-term:90.0\r\n" + 
				"final exam:93.0\r\n" + 
				"Total grade:80.35\r\n" + 
				"Please type G,R,A,W,E !\r\n" + 
				"Input ID or Q\r\n" + 
				"Quit!\r\n";
		assertEquals(out_string.length(), ans.length());
		assertEquals(out_string, ans);
	}

}
