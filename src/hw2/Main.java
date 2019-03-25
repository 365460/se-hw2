package hw2;

import GradeSystem.*;

public class Main {

	public static void main(String[] args) {
		
		int num_score = 5;
		String[] score_name = {"lab1", "lab2", "lab3", "mid-term", "final exam"};
		double[] score_weight = {0.1, 0.1, 0.1, 0.3, 0.4};
		String student_file = "input.txt";

		GradeSystem system = new GradeSystem(num_score, score_weight, score_name, student_file);

		/*
		 * Main Loop
		 **/
	}
}
