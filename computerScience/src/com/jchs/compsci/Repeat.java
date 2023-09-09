package com.jchs.compsci;
import java.util.*;
 

public class Repeat {
	public boolean checkRepeat() {
		System.out.println("Would you like to run this code again?");
		System.out.println("Enter 1 to run again | Enter 2 to stop");
		Scanner scan = new Scanner (System.in);
		scan.nextLine();
		int x = scan.nextInt();
		if (x == 1) {
			return true;
		} else {
			return false;
		}
	}
	
}
