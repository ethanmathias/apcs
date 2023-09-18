package com.jchs.compsci;



import java.util.*;

public class DisplayFraction {

	private String value = ""; 
	private Scanner scan = new Scanner(System.in);

	private int num; // numerator
	private int den; // denominator

	public void getFraction() {
		System.out.println(simplyfy());
	}

	private String simplyfy() {
		getInput();
		if (isInteger()) {
			return value;
		}

		splitString();
		bothNegative();
		boolean negative = oneNegative();
		String concate = "";

		if (negative) {
			concate = "-";
		}

		if (num == den) {
			return concate + 1;
		}

		if (num == 0) {
			return concate + num;
		}

		if (den == 0) {
			return "undefined";
		}

		simplfyUsingGCD();

		if (den == 1) {
			return concate + num;
		}
		return concate + num + "/" + den;
	}

	private String getInput() {
		System.out.println("Please input Fraction: ");
		value = scan.nextLine();
		return value;
	}

	private void bothNegative() {
		String numString = String.valueOf(num);
		String denString = String.valueOf(den);

		if (numString.charAt(0) == '-' && denString.charAt(0) == '-') {
			numString = numString.substring(1);
			denString = denString.substring(1);
			num = Integer.parseInt(numString);
			den = Integer.parseInt(denString);

		}
	}

	private boolean oneNegative() {
		String numString = String.valueOf(num);
		String denString = String.valueOf(den);

		if (numString.charAt(0) == '-') {
			numString = numString.substring(1);
			num = Integer.parseInt(numString);
			return true;
		}
		if (denString.charAt(0) == '-') {
			denString = denString.substring(1);
			den = Integer.parseInt(denString);

			return true;
		}
		return false;
	}

	private boolean isInteger() {
		int index = value.indexOf('/');
		if (index == -1) {
			return true;
		} else {
			return false;
		}
	}

	// populated s1 or s2
	private void splitString() {
		String[] splitStrings = value.split("/", 2);
		num = Integer.parseInt(splitStrings[0]);
		den = Integer.parseInt(splitStrings[1]);

	}


	private void simplfyUsingGCD() {
		int currNum = num;
		int currDen = den;

		int numRemainder = -1;
		int denRemainder = -1;
		while (true) {
			if (numRemainder == 0 || denRemainder == 0) {
				if (numRemainder == 0) {
					num = num / denRemainder;
					den = den / denRemainder;
					break;
				} else {
					num = num / numRemainder;
					den = den / numRemainder;
					break;
				}
			} else {
				numRemainder = currDen % currNum;
				denRemainder = currNum % currDen;
				currDen = numRemainder;
				currNum = denRemainder;
			} 
		}

	}

	public void repeat() {
		String x = "";
		while (true) {
			getFraction();
			System.out.println();
			System.out.println("any key to continue | press 2 to stop");
			x = scan.nextLine();
			System.out.println();
			if (x.compareTo("2") == 0) {
				break;
			}
		}
		System.out.println("Program Stopped");
	}

}
