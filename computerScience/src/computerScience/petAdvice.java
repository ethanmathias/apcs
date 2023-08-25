package computerScience;

import java.util.*;

public class petAdvice {

	private static Scanner scan = new Scanner(System.in);

	// gets current location of person
	public char getLocation() {
		System.out.println("Do you live in a:");
		System.out.println("A) an apartment");
		System.out.println("H) house");
		System.out.println("D) dormitory");

		String input = scan.nextLine();
		char locationLower = input.charAt(0);
		char locationUpper = Character.toUpperCase(locationLower);

		return locationUpper;
	}

	// gets hours worked by person
	public char getHours() {
		Scanner scanHours = new Scanner(System.in);
		System.out.println("How many hours are you at home per day:");
		System.out.println("A) 18 or more");
		System.out.println("B) 10 to 17");
		System.out.println("C) 8 to 9");
		System.out.println("D) 6 to 7");
		System.out.println("E) 0 to 5");

		String input = scanHours.nextLine();
		char hoursLower = input.charAt(0);
		char hoursUpper = Character.toUpperCase(hoursLower);
		scanHours.close();
		return hoursUpper;

	}

	// logic for determining which pet person should get
	public String getRecomendation(char location, char hours) {
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
			if (hours == 'A' || hours == 'B' || hours == 'E' || hours == 'D') {
				return "Fish";
			}
			if (hours == 'E') {
				return "Ant Farm";
			}

		}

		return "Incorrect Input";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		petAdvice obj = new petAdvice();
		char location = obj.getLocation();
		char hours = obj.getHours();
		String output = obj.getRecomendation(location, hours);
		System.out.println(output);

	}
}
