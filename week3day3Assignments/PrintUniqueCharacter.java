package week3.week3day3Assignments;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		//PrintUniqueCharacter
		/*
		 * Problem
		 * 
		 * a) Take your name as input
		 * b) Print all unique characters only (any order)
		 * 
		 * Input:  babu
		 * Output: a u 
		 * 
		 */

		/*
		 * Psuedocode
		 * 
		 * a) Convert String to Character array
		 * b) Create a new Set -> HashSet
		 * c) Add each character to the Set and if it is already there, remove it
		 * d) Finally, print the set
		 * 
		 */
		
		String str_name="Adhish";
		char[] ch_name=str_name.toCharArray();
		Set<Character> set_name= new HashSet<Character>();
		 for (Character c: ch_name) {
			 set_name.add(c);
		 }
		 System.out.println("The output with all the unique characters is \n"+set_name);
		 
	}

}
