package week3.week3day3Assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateChar {

	public static void main(String[] args) {
		
//		Declare a String as "PayPal India"
//		Convert it into a character array
//		Declare a Set as charSet for Character
//		Declare a Set as dupCharSet for duplicate Character
//		Iterate character array and add it into charSet
//		if the character is already in the charSet then, add it to the dupCharSet
//		Check the dupCharSet elements and remove those in the charSet
//		Iterate using charSet
//		Check the iterator variable isn't equals to an empty space
//		print it
		
		String str_input="PayPal India";
		String str_modifiedinput=str_input.toLowerCase();
		String[] str_mArrinput=str_modifiedinput.split(" ");
		Set<Character> charSet= new LinkedHashSet<Character>(); 
		Set<Character> dupCharSet= new LinkedHashSet<Character>(); 
		 char[] char_input=null;
		 
		 for (int i=0;i<str_mArrinput.length;i++) 
		 {
		   char_input=str_mArrinput[i].toCharArray();
		   
		   for(int j=0;j<char_input.length;j++) {
		   if(!(charSet.add(char_input[j]))) {
			   dupCharSet.add(char_input[j]);
		   }
		   }
		  
		 }
		 	
	System.out.println("The Character Set without duplicates"+charSet+"\nThe duplicates in the character set "+dupCharSet);
	}

}
