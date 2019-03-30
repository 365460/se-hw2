package hw2;

import static org.junit.Assert.assertNotNull;

import java.util.Scanner;

import GradeSystem.*;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) throws NoSuchIDExecption {
		
		int num_score = 5;
		String[] score_name = {"lab1", "lab2", "lab3", "mid-term", "final exam"};
		double[] score_weight = {0.1, 0.1, 0.1, 0.3, 0.4};
		String student_file = "input.txt";

		GradeSystem system = new GradeSystem(num_score, score_weight, score_name, student_file);

		scanner = new Scanner(System.in);
		boolean quit = false;
		while(quit == false) {	
			
			System.out.println("Input ID or Q");
			String in = scanner.next();
			
			if(in.equals("Q")){
				break;
			}else{
				
				boolean exit = false;
				Student student = null;
				int ID = Integer.valueOf(in);
				
				try {
					student = system.get_student(ID);
					System.out.println("Welcome " + student.get_name());
				} catch(NoSuchIDExecption e) {
					assertNotNull(e.getMessage());
					System.out.println("Wrong ID");
					exit = true;
				}
							
				
				while(exit==false){
					
					String option = scanner.next();
					
					if(option.equals("G")){
						for(int i = 0 ; i < 5 ; i++){
							System.out.println(score_name[i] + ":" + Double.toString(student.get_score(i)));
						}
						System.out.println("Total grade:" + Double.toString(system.cal_total_grade(student)));
					}
					else if(option.equals("R")){
						System.out.println("Rank:" +  Integer.toString(student.get_rank()));
					}
					else if(option.equals("A")){
						System.out.println("Average:" +  Double.toString(student.get_average()));	
					}
					else if(option.equals("W")){
						//Show old weight
						System.out.println("Old weight");
						for(int i = 0 ; i < 5 ; i++){
							Double tmp = 100*score_weight[i];
							System.out.println(score_name[i]+":"+ Integer.toString(tmp.intValue()) + "%");
						}
						
						//Input new weight
						boolean update = false;
						while(update== false){
							
							System.out.println("Input update weight.");
							double[] update_weight = new double[5]; 
							//double total = 0 ;
							for(int i = 0 ; i < 5 ; i++){
								System.out.print(score_name[i]+":");
								update_weight[i] = Double.valueOf(scanner.next())/100;
							//	total += update_weight[i];
								
							}
							
							//Check Input
							//if(total == 1){
								//Check  Input
								System.out.println("Input is correct or not. [y/n]");
								for(int i = 0 ; i < 5 ; i++){
									Double tmp_ = 100*update_weight[i];
									System.out.println(score_name[i]+":"+ Integer.toString(tmp_.intValue()) + "%");
								}
								//Update
								if(scanner.next().equals("y")){
									try {
										system.update_weight(update_weight);
										for(int i = 0 ; i < 5 ; i++){
											score_weight[i]=update_weight[i];
										}
										update = true;
									} catch(UpdateWeightExecption e) {
										System.out.println("Sum of update weight shoud be 100% and each of them should be greater than 0. Please try again!");
									}
								}
							
							/*}else{
								System.out.println("Total of update weight is not 100%. Please try again!");
							}	
							*/
							
						}
					}
					else if(option.equals("E")){
						exit = true;
					}
					else{
						System.out.println("Please type G,R,A,W,E !"+"\n");
					}
				}	
			}			
		}
		System.out.println("Quit!");
	}
}
