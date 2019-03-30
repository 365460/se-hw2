package GradeSystem;
import java.util.*;
import java.io.*;

public class GradeSystem {
	
	private HashMap<Integer, Student> students = new HashMap<Integer, Student>();
	private int num_score;
	private double[] score_weight;
	private String[] score_name;

	/*
	 * Create a grade system by default settings and specifced student's database
	 *
	 * 1. read files : O(N)
	 * 2. cal_rank : O(NLogN)
	 *
	 * time complexity: O(NlogN)
	 *
	 */
	public GradeSystem(String student_file) {

		num_score = 5;

		score_name = new String[num_score];
		score_name[0] = "lab1"; score_name[1] = "lab2"; score_name[2] = "lab3";
		score_name[3] = "mid-term"; score_name[4] = "final";

		score_weight = new double[num_score];
		score_weight[0] = score_weight[1] = score_weight[2] = 0.1;
		score_weight[3] = 0.3; score_weight[4] = 0.4;

		load_file(student_file);
		cal_rank();
	}

	/*
	 * Create a grade system.
	 *  1. Load student data and store to a Map<int, Student> students.    O(N)
	 * 	2. Calculate the student rank with the weight by calling cal_rank. O(NlogN)
	 *
	 * @pram num_score:    # of total score
	 * @pram score_weight: the initial weight of each score
	 * @pram score_name:   the name of each score
	 * @pram student_file: the database of student's score
	 *
	 * time complexity: O(NlogN)
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

	/* Read the student data from the files
	 *  Create a student by (Name, ID, score[], total_grade), where total_grade is obtained by 
	 *  score and score_weight
	 *
	 * @parm input_file: the file name of database
	 * 
	 * */
	private void load_file(String input_file) {

		BufferedReader br = null;

		try {
			br = new BufferedReader( new FileReader(input_file) );

			String line;
			while((line = br.readLine()) != null) {

				String[] tokens = line.split(" ");
				String name = tokens[1];
				int ID = Integer.parseInt(tokens[0]);
				double[] score = new double[num_score];
				for(int i=0; i<num_score; i++) score[i] = Double.parseDouble(tokens[i+2]);

				Student student = new Student(name, ID, score);
				students.put(ID, student);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* calculate the student's rank
	 * 1. store the pair <ID, total_grade> for each student to a temp array A. => O(N)
	 * 2. sort the array A by total_grade           => O(NlogN)
	 * 3. set each student rank by array A and ID.  => O(NlogN)
	 * time complexity : O(NlogN)
	 * */
	private void cal_rank() {
		class Pair {
			public double grade;
			public int id;
			Pair(int id, double grade) {
				this.id = id;
				this.grade = grade;
			}
		}

		ArrayList<Pair> temp = new ArrayList<Pair>();
		for(Student student : students.values()) {
			temp.add(new Pair(student.get_ID(), cal_total_grade(student)));
		}

		temp.sort((p1, p2) -> (p1.grade < p2.grade)? 1:-1);

		int rank = 1;
		for(Pair pair: temp) {
			students.get(pair.id).set_rank(rank++);
			//System.out.println(pair.grade );
		}
	}

	/* return the total grade of student
	 *
	 * @pram: Student oject
	 * time complexity : O(# of score)
	 */
	public double cal_total_grade(Student student) {
		double grade = 0;

		for(int i=0; i<num_score; i++) 
			grade += student.get_score(i) * score_weight[i];

		return grade;
	}

	/* Update the score weight
	 * 1. The new weight array has been checked if it is valid 
	 *	 (# of weight == # of score and sum of weight == 1)
	 * 2. recompute students rank by calling cal_rank
	 *
	 *  @pram score_weight: the new weight of score
	 * time complexity : O(# of score) + O(NlogN)
	 * */
	public void update_weight(double [] score_weight) {
		for(int i=0; i<num_score; i++) this.score_weight[i] = score_weight[i];
		cal_rank();
	}

	/* Return a student object by ID
	 *
	 * 	@pram id: student id
	 *
	 * 	@throws: NoSuchIDExecption
	 *  time complexity : O(logN)
	 */
	public Student get_student(int id) throws NoSuchIDExecption {
		if(students.containsKey(id) == false) throw new NoSuchIDExecption(id);
		return students.get(id);
	}
}

