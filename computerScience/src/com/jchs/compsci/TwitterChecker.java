//package contains all JCHS Computer Science assignments
//assignment can be found at https://tinyurl.com/58vx7cwv
package com.jchs.compsci;

import java.util.*;


public class TwitterChecker {

	private static Scanner scan;
	private String tweet;

	/*
	 * constructor: TwitterChecker() purpose: initialize the scanner, initialize the
	 * String tweet
	 * TwitterChecker class is created postcondition: none
	 */
	public TwitterChecker() {
		scan = new Scanner(System.in);
		tweet = "";
	}

	/*
	 * method: check() purpose: to check if tweet is within bounds, and if it is then
	 * output to console that the length is correct and the number of #, @, and
	 * links OR if tweet is out of bounds then output to console the number of
	 * excess characters precondition: none postcondition: output to console of the
	 * either the length is correct and number of #, @, and links OR the number of
	 * excess characters
	 */
	public void check() {
		getTweet();
		if (tweetInBounds() == true) {
			System.out.println("Length Correct");
			System.out.println("Number of Hashtags: " + String.valueOf(numberOfHashtags()));
			System.out.println("Number of Attributions: " + String.valueOf(numberOfMentions()));
			System.out.println("Number of Links: " + String.valueOf(numberOfLinks()));
		} else {
			System.out.println("Excess Characters: " + String.valueOf(excessCharacters()));
		}
		
	}

	/*
	 * method: getTweet() purpose: to prompt for, input and return the users tweet
	 * precondition: a static Scanner object, scan, has been initialized; a String
	 * object, tweet, has been initialized postcondition: the String tweet is
	 * updated with the users input
	 */
	private void getTweet() {
		System.out.println("Please enter a tweet:");
		tweet = scan.nextLine();
		
	}

	/*
	 * method tweetInBounds() purpose: to check if tweet is within bounds
	 * precondition: tweet has been initialized with users input postcondition: an
	 * boolean is returned that signifies if the tweet is within bounds
	 */
	private boolean tweetInBounds() {
		if (tweet.length() <= 140) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * method excessCharacters() purpose: to find the number of excess characters in
	 * a tweet precondition: tweetInBounds is false; tweet has been initialized with
	 * users input postcondition: the number of excess characters is returned
	 */
	private int excessCharacters() {
		return Math.abs(140 - tweet.length());
	}

	/*
	 * method: numberOfMentions() purpose: to find the number of '@' symbols in a
	 * tweet precondition: tweet has been initialized with users input
	 * postcondition: the number of '@' symbols is returned
	 */
	private int numberOfMentions() {
		int counter = 0;
		for (int i = 0; i < tweet.length(); i++) {  //said I might go out of bounds here (somewhere around here)
			if (tweet.charAt(i) == '@') {
				if (i == tweet.length()-1 || tweet.charAt(i+1) == ' ') {	// this statement checks if the @ is the last character of string or if the next character after is empty			
					//do nothing
				} else {
					counter++;   
				}
			}
		}
		return counter;
	}

	/*
	 * method: numberOfHashtags() purpose: to find the number of '#' symbols in a
	 * tweet precondition: tweet has been initialized with users input
	 * postcondition: the number of '#' symbols is returned
	 */
	private int numberOfHashtags() {
		int counter = 0;
		for (int i = 0; i < tweet.length(); i++) {
			if (tweet.charAt(i) == '#') {
				if (i == tweet.length()-1 || tweet.charAt(i+1) == ' ') {					
					//do nothing
				} else {
					counter++;
				}
			}
		}
		return counter;
	}

	/*
	 * method: numberofLinks() purpose: to find the number of 'http://' phrases in a
	 * tweet precondition: tweet has been initialized with users input
	 * postcondition: the number of 'http://' phrases is returned
	 */
	private int numberOfLinks() {
		String tweetLowerCase = tweet.toLowerCase();
		int counter = 0;
		int index = 0;
		while (true) {
			int currIndex = tweetLowerCase.indexOf("http://", index);
			if (currIndex != -1) {
				index = currIndex + 1;
				counter++;
			} else {
				break;
			}
		}
		return counter;
		
		
	}
	/*
	 * method: repeat
	 * purpose: to run the program and prompt user if they would like to run it again
	 * precondition: Scanner class, check() methods are initialized
	 * postcondition: none
	 */
	public void repeat() {
		int x = 1;
		while (x == 1) {
			check();
			System.out.println();
			System.out.println("1 to contiue; 2 to stop");
			x = Integer.valueOf(scan.nextLine());
			System.out.println();
		}
		System.out.println("Program Stopped");
	}

}
