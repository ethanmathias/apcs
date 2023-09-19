//package contains all JCHS Computer Science assignments
package com.jchs.compsci;
import java.util.*;

/*
 * Author: Ethan Mathias
 * Last Update: 9/1u/2023
 * Purpose: Assignment for Computer Science
 * Description: Display a Fraction that is simplified and adheres to a fraction syntax
 */
public class DisplayFraction {

	private String value = ""; 
	private Scanner scan = new Scanner(System.in);

	private int num; // numerator
	private int den; // denominator

	/*
	 * method: getFraction()
	 * purpose: to output to console the simplified String
	 * precondition: getInput() method
	 * postcondition: simplified fraction is outputted to console
	 */
	public void getFraction() {
		getInput();
		System.out.println(simplify());
	}

	/*
	 * method simplify()
	 * purpose: check each individual case in the syntax of fractions and return a fraction in its proper form
	 * precondition: isInteger method, splitString method, bothNegative method, and simplifyUsingGCD method
	 * postcondition: the simplified fraction is returned as a String
	 */
	private String simplify() {
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

	/*
	 * method: getInput()
	 * purpose: to receive users input and assign it to the String value
	 * precondition: String value has been initialized
	 * postcondition: the input is place in String value
	 */
	private String getInput() {
		System.out.println("Please input Fraction: ");
		value = scan.nextLine();
		return value;
	}

	/*
	 * method: bothNegative
	 * purpose: to check if fraction has both negative in the num and den and change it to a positive
	 * precondition: String num and String den have been population with the numerator and denominator, respectively
	 * postcondition: if both num and den are negative, then num and den are updated to their value without the negative sign. 
	 */
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

	/*
	 * method: oneNegative()
	 * purpose: to check if either the numerator or the denominator is negative (only one of them), return either true or false, and update either num or den without the negative
	 * precondition: String num and den have been initialized
	 * postcondition: num and dem are updated with their respective values, and true is returned if one is negative; else if neither or both are negative no update to num or den and false is returned 
	 */
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

	/*
	 * method isInteger()
	 * purpose: to check if String value is an integer
	 * precondition: String value has been populated
	 * postcondition: if value is Integer, true is returned, else false is returned
	 */
	private boolean isInteger() {
		int index = value.indexOf('/');
		if (index == -1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * method splitString()
	 * purpose: to check split String value into numerator and denomenator
	 * preconditon: String value, num, and den have been initialized
	 * postcondition: num and den are filled with the numerator and denominator of the fraction in value
	 */
	private void splitString() {
		String[] splitStrings = value.split("/", 2);
		num = Integer.parseInt(splitStrings[0]);
		den = Integer.parseInt(splitStrings[1]);

	}

	/*
	 * method simplfyUsingGCD()
	 * purpose: to simplify num and den to their simplest form
	 * precondition: num and den have been initialized and populated with numerator and denominator
	 * postcondition: num and den are updated with their simplest form
	 */
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
	/*
	 * method: repeat
	 * purpose: to run the program and prompt user if they would like to run it again
	 * precondition: Scanner class, getFraction() methods are initialized
	 * postcondition: none
	 */
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
