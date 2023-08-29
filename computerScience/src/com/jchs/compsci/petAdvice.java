package com.jchs.compsci; //package containing code for AP Computer Science

import java.util.*; //imports scanner

public class petAdvice { //petAdvice class for the petAdvice assignment

	private static Scanner scan = new Scanner(System.in); 

	//prints out instructions for use to console
	private void instructions() {
		System.out.println("Instructions:");
		System.out.println("enter the first letter of the choice you make - ex. if you choose [[ A) apartment ]] enter the first letter shown");
		System.out.println("");
	}
	
	//gets current location of person
	private char getLocation() {
		System.out.println("Do you live in a(n):");
		System.out.println("A) apartment");
		System.out.println("H) house");
		System.out.println("D) dormitory");

		String input = scan.nextLine(); //scans in line
		char locationLower = input.charAt(0); //converts string to char                 
		char locationUpper = Character.toUpperCase(locationLower); //converts char to uppercase char 

		return locationUpper;
	}
	
	// gets hours worked by person
	private char getHours() {
		System.out.println("How many hours are you home per day:");
		System.out.println("A) 18 or more");
		System.out.println("B) 10 to 17");
		System.out.println("C) 8 to 9");
		System.out.println("D) 6 to 7");
		System.out.println("E) 0 to 5");

		String input = scan.nextLine(); //scans in line
		char hoursLower = input.charAt(0); //converts string to char
		char hoursUpper = Character.toUpperCase(hoursLower); //converts char to uppercase char
		scan.close();
		return hoursUpper;

	}

	/* logic for determining which pet person should get
	 * takes the location and hours as inputs as a character
	 * 
	 * location character possiblilites:
	 * H - House
	 * A - apartment
	 * D - dormitory
	 * 
	 * hours character possibilities:
	 * A - 18 or more
	 * B - 10 to 17
	 * C - 8 to 9
	 * D - 6 to 7
	 * E - 0 to 5
	 * 
	 * in code, outside if statement refers to the location and inner if statements refer to hours
	 */
	private String logic(char location, char hours) {
		if (location == 'H') {
			if (hours == 'A') {
				return "Potbellied Pig";
			}
			if (hours == 'B') {
				return "Dog";
			}
			if (hours == 'C' || hours == 'D' || hours == 'E') {
				return "Snake";
			}
		}
		if (location == 'A') {
			if (hours == 'A' || hours == 'B') {
				return "Cat";
			}
			if (hours == 'C' || hours == 'D' || hours == 'E') {
				return "Hamster";
			}

		}
		if (location == 'D') {
			if (hours == 'A' || hours == 'B' || hours == 'C' || hours == 'D') {
				return "Fish";
			}
			if (hours == 'E') {
				return "Ant Farm";
			}

		}

		return "Invalid Inputs"; //returns invalid inputs as at this point a character has been entered in either getHours or getLocation which is not part of the list in logic
	}
	
	//calls getLocation and getHours to get neccesary inputs for logic and then runs logic in order to get recommendation as a string
	public String getReccomendation() {
		instructions();
		char location = getLocation(); //the location
		char hours = getHours(); //the number of hours worked
		String output = logic(location, hours); //the recommendation

		return output;
	}

	public static void main(String[] args) {
		petAdvice pet = new petAdvice();
		System.out.println(pet.getReccomendation());
	}
}
