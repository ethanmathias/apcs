package com.jchs.compsci;

import java.util.*;

public class TwitterChecker {

	private Scanner scan;
	private String tweet;
	
	public TwitterChecker() {
		scan = new Scanner(System.in);
		tweet = "";
		run();
	}
	
	private void getTweet() {
		System.out.println("Please enter a tweet:");
		tweet = scan.nextLine();
		scan.close();
	}

	private boolean tweetInBounds() {
		if (tweet.length() <= 140) {
			return true;
		} else {
			return false;
		}
	}
	
	private int excessCharacters() {
		return Math.abs(140 - tweet.length());
	}

	private int numberOfMetions() {
		int counter = 0;
		for (int i = 0; i < tweet.length(); i++) {
			if (tweet.charAt(i) == '@') {
				counter++;
			}
		}
		return counter;
	}
	
	private int numberOfHashtags() {
		int counter = 0;
		for (int i = 0; i < tweet.length(); i++) {
			if (tweet.charAt(i) == '#') {
				counter++;
			}
		}
		return counter;
	}
	
	private int numberofLinks() {
		String tweetLowerCase = tweet.toLowerCase();
		int counter = 0;
		int index = 0;
		while (index < tweet.length()) {
		int	currIndex = tweetLowerCase.indexOf("http://", index);
			if (currIndex != -1) {
			index = currIndex +1;
			counter++;
			} else {
				break;
			}		
		}
		return counter;
	}
	
	private void run() {
		getTweet();
		if (tweetInBounds() == true) {
			System.out.println("Length Correct");
			System.out.println("Number of Hashtags: " + String.valueOf(numberOfHashtags()));
			System.out.println("Number of Attributions: " + String.valueOf(numberOfMetions()));
			System.out.println("Number of Links: " + String.valueOf(numberofLinks()));
		} else {
			System.out.println("Excess Characters: " + String.valueOf(excessCharacters())); 
		}
	}

}
