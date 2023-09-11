package com.jchs.compsci;
import java.util.*;

public class ExecutingClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TwitterChecker Class
		Scanner scan = new Scanner(System.in);

		//Twitter Checker Object
		TwitterChecker tweet = new TwitterChecker();
		
		//repeater code
		int x = 1;
		while (x == 1) {
			tweet.check();
			System.out.println();
			System.out.println("1 to contiues; 2 to stop");
			x = Integer.valueOf(scan.nextLine());
			System.out.println();
		}
		System.out.println("Program Stopped");
		
		
		//PetAdvice Class
		/*
		PetAdvice pet = new PetAdvice();
		System.out.println(pet.getReccomendation());
		*/
	
	}

}
