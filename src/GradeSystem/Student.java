package GradeSystem;

public class Student {

	private	double[] score;
	private	String name;
	private	double average;
	private double total_grade;
	private int rank;
	private int ID;

	public Student(String name, int index, double[] score, double total_grade) {

		this.name = name;

		this.ID = index;

		this.score = new double[score.length];

		this.total_grade = total_grade;

		double sum = 0;
		for(int i=0; i<score.length; i++) {
			this.score[i] = score[i];
			sum += score[i];
		}

		this.average = sum/(double)(score.length);
	}

	public double get_score(int index) {
		if( index >= score.length || index < 0) {
			System.out.println("[Error] get_score: wrong index ");
			return 0;
		}
		return score[index];
	}

	public String get_name() {
		return name;
	}

	public double get_total_grade() {
		return total_grade;
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
