package GradeSystem;
import java.util.*;

public class GradeSystem {
	
	private HashMap<Integer, Student> students;
	private int num_score;
	private double[] score_weight;
	private String[] score_name;

	/*
	 * Create a grade system.
	 * 	1. Load student data and store to a Map<int, Student> students .
	 * 	2. Calculate the student rank with the weight by calling cal_rank
	 *
	 * @pram num_score:    # of total score
	 * @pram score_weight: the initial weight of each score
	 * @pram score_name:   the name of each score
	 * @pram student_file: the database of student's score
	 *
	 */
	public GradeSystem(int num_score, double[] score_weight, String[] score_name, String student_file) {

		this.num_score = num_score;

		assert num_score == score_weight.length;
		assert num_score == score_name.length;

		this.score_weight = new double[ num_score ];
		this.score_name = new String[ num_score ];

		for(int i=0; i<num_score; i++) {
			this.score_weight[i] = score_weight[i];
			this.score_name[i] = score_name[i];
		}

		load_file(student_file);
		cal_rank();
	}

	/* waiting for user command*/
	public void main_loop() {

	}

	/* calculate the student's rank
	 * 1. store the pair <ID, total_grade> for each student to a temp array A. => O(N)
	 * 2. sort the array A by total_grade           => O(NlogN)
	 * 3. set each student rank by array A and ID.  => O(NlogN)
	 * 		3.1 get the student from students by id => O(logN)
	 * 		3.2 set the rank
	 * time complexity : O(NlogN)
	 * */
	private void cal_rank() {

	}

	/* Read the student data from the files
	 *  Create a student by (Name, ID, score[], total_grade), where total_grade is obtained by 
	 *  score and score_weight
	 *
	 * @parm input_file: the file name of database
	 * 
	 * */
	private void load_file(String input_file) {
		
	}

	/* Get the student by id, and print student's information to console 
	 *
	 * we have had maken sure that the student id is correct before call this function.
	 *
	 *  @pram id: student id 
	 * 
	 * */
	private void show_student(int id) {
		Student student = students.get(id);
		// TODO: print
	}

	/* Update the score weight
	 * 1. check if the new weight is correct (total weight is 1 and num_score == score_weight)
	 * 2. recompute students rank by calling cal_rank
	 *
	 *  @pram score_weight: the new weight of score
	 * */
	private void update_weight(double score_weight) {

	}
}
