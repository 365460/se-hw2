package GradeSystem;

public class Student {

	private	double[] score;
	private	String name;
	private	double average;
	private int rank;
	private int ID;

	public Student(String name, int index, double[] score) {

		this.name = name;

		this.ID = index;

		this.score = new double[score.length];

		double sum = 0;
		for(int i=0; i<score.length; i++) {
			this.score[i] = score[i];
			sum += score[i];
		}

		this.average = sum/(double)(score.length);
	}

	/*
	 *  return the id-th score
	 *
	 *  @pram index: which score
	 *  
	 *  @throws: ArrayIndexOutOfBoundsException
	 */
	public double get_score(int index) throws ArrayIndexOutOfBoundsException{
		if( index >= score.length || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return score[index];
	}

	public String get_name() {
		return name;
	}

	public double get_average() {
		return average;
	}

	public int get_rank() {
		return rank;
	}

	public int get_ID() {
		return ID;
	}

	public void set_rank(int rank) {
		this.rank = rank;
	}
	
	
}
