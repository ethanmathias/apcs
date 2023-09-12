package com.jchs.compsci;

import java.util.*;

public class DisplayFraction {

	private String value = "";
	public int num;
	public int den;

	public void run() {
		getInput();
		while (true) {
		if (isInteger() == true) {
			System.out.println(value);
			break;
		} 
		splitString();
		if (num == 0) {
			System.out.println(num);
			break;
		}
		if (den == 0) {
			System.out.println("undefined");
			break;
		}
		simplfyUsingGCD();
		if (den == 1) {
			System.out.println(num);
			break;
		} else {
			System.out.println(num + "/" + den);
			break;
		}
		}
	}

	public String getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input Fraction: ");
		value = scan.nextLine();
		return value;
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
	public int simplfyUsingGCD() {
		int a = num;
		int b = den;

		int x = 1;
		int numRemainder = -1;
		int denRemainder = -1;
		while (x == 1) {
			if (numRemainder != 0 || denRemainder != 0) {
				numRemainder = b % a;
				denRemainder = a % b;
				b = numRemainder;
				a = denRemainder;
			}
			if (numRemainder == 0) {
				num = num / denRemainder;
				den = den / denRemainder;
				return denRemainder;

			}
			if (denRemainder == 0) {
				num = num / numRemainder;
				den = den / numRemainder;
				return numRemainder;
			}

		}
		return -1;
	}

}

//Inputs 