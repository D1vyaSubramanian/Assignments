package week3.week3day3Assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		/*
		 * Pseudo code 
		 
		 * a) Use the declared String text as input
			String text = "We learn java basics as part of java sessions in java week1";		
		 * b) Initialize an integer variable as count	  
		 * c) Split the String into array and iterate over it 
		 * d) Initialize another loop to check whether the word is there in the array
		 * e) if it is available then increase and count by 1. 
		 * f) if the count > 1 then replace the word as "" 
		 
		 * g) Displaying the String without duplicate words	
		 */
		
		String text = "We learn java basics as part of java sessions in java week1";
		String[] splitArr= text.split(" ");
		String output="";
		Set<String> Str_set = new LinkedHashSet<String>();
		
		for (String s:splitArr) {
			if(Str_set.add(s)) {
				output=output+s+" ";
			}
		}
		System.out.println("The output without Duplicates is  \n"+output);
	}

}
