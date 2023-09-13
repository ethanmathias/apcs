package com.jchs.compsci;

import java.util.*;

public class DisplayFraction {

	private String value = "";
	private Scanner scan = new Scanner(System.in);

	public int num; // numerator
	public int den; // denominator

	public void run1() {
		  getInput();
		  if (isInteger()) {
		    System.out.println(value);
		    return;
		  }

		  splitString();
		  bothNegative();
		  boolean negative = oneNegative();
		  String concate = "";

		  if (negative) {
		    concate = "-";
		  }

		  if (num == den) {
		    System.out.println(concate + 1);
		    return;
		  }

		  if (num == 0) {
		    System.out.println(concate + num);
		    return;
		  }

		  if (den == 0) {
		    System.out.println("undefined");
		    return;
		  }

		  simplfyUsingGCD();

		  if (den == 1) {
		    System.out.println(concate + num);
		    return;
		  }

		  System.out.println(concate + num + "/" + den);
		}

	public String getInput() {
		System.out.println("Please input Fraction: ");
		value = scan.nextLine();
		return value;
	}

	public void bothNegative() {
		String numString = String.valueOf(num);
		String denString = String.valueOf(den);

		if (numString.charAt(0) == '-' && denString.charAt(0) == '-') {
			numString = numString.substring(1);
			denString = denString.substring(1);
			num = Integer.parseInt(numString);
			den = Integer.parseInt(denString);

		}
	}

	public boolean oneNegative() {
		String numString = String.valueOf(num);
		String denString = String.valueOf(den);

		if (numString.charAt(0) == '-') {
			numString = numString.substring(1);
			num = Integer.parseInt(numString);
			System.out.println(num);
			return true;
		}
		if (denString.charAt(0) == '-') {
			denString = denString.substring(1);
			den = Integer.parseInt(denString);
			System.out.println(den);

			return true;
		}
		return false;
	}

	public boolean isInteger() {
		int index = value.indexOf('/');
		if (index == -1) {
			return true;
		} else {
			return false;
		}
	}

	// populated s1 or s2
	public void splitString() {
		String[] splitStrings = value.split("/", 2);
		num = Integer.parseInt(splitStrings[0]);
		den = Integer.parseInt(splitStrings[1]);

	}

	// keep dividing till remainder one
	public void simplfyUsingGCD() {
		int currNum = num;
		int currDen = den;

		int numRemainder = -1;
		int denRemainder = -1;
		while (true) {

			if (numRemainder != 0 || denRemainder != 0) {
				numRemainder = currDen % currNum;
				denRemainder = currNum % currDen;
				currDen = numRemainder;
				currNum = denRemainder;
			}
			if (numRemainder == 0) {
				num = num / denRemainder;
				den = den / denRemainder;
				break;
			}
			if (denRemainder == 0) {
				num = num / numRemainder;
				den = den / numRemainder;
				break;
			}

		}

	}

	public void repeat() {
		String x = "";
		while (true) {
			run1();
			System.out.println();
			System.out.println("1 to contiue; 2 to stop");
			x = scan.nextLine();
			System.out.println();
			if (x.compareTo("1") != 0){
				break;
			}
		}
		System.out.println("Program Stopped");
	}

}

