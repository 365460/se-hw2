package GradeSystem;

public class NoSuchIDExecption extends Exception {

	public NoSuchIDExecption(int ID) {
		super("No such ID " + ID);
	}
}
