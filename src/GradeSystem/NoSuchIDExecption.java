package GradeSystem;

public class NoSuchIDExecption extends Exception {

	public NoSuchIDExecption(int ID) {
		super("No such ID " + ID);
	}
}





/*
public class GradeLessThanZeroExecption extends Exception {

	public GradeLessThanZeroExecption() {
		super(" Grade Less Than Zero");
	}
}
*/

