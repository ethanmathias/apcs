package computerScience;

import java.util.*;

public class petAdvice {

	private static Scanner scan = new Scanner(System.in);
	private static petAdvice pet = new petAdvice();

	// gets current location of person
	private static void instructions() {
		System.out.println("Instructions:");
		System.out.println("enter the first letter of the choice you make - ex. if you choose { A) apartment } enter the first letter shown");
		System.out.println("");
	}
	
	private char getLocation() {
		System.out.println("Do you live in a(n):");
		System.out.println("A) apartment");
		System.out.println("H) house");
		System.out.println("D) dormitory");

		String input = scan.nextLine();
		char locationLower = input.charAt(0);
		char locationUpper = Character.toUpperCase(locationLower);

		return locationUpper;
	}

	// gets hours worked by person
	private char getHours() {
		System.out.println("How many hours are you at home per day:");
		System.out.println("A) 18 or more");
		System.out.println("B) 10 to 17");
		System.out.println("C) 8 to 9");
		System.out.println("D) 6 to 7");
		System.out.println("E) 0 to 5");

		String input = scan.nextLine();
		char hoursLower = input.charAt(0);
		char hoursUpper = Character.toUpperCase(hoursLower);
		scan.close();
		return hoursUpper;

	}

	// logic for determining which pet person should get
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

		return "Incorrect Inputs";
	}

	public String getReccomendation() {
		pet.instructions();
		char location = pet.getLocation();
		char hours = pet.getHours();
		String output = pet.logic(location, hours);

		return output;
	}

	public static void main(String[] args) {
		System.out.println(pet.getReccomendation());
	}
}
