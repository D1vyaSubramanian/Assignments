package week3.week3day2assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingElementIn_Collection {

	public static void main(String[] args) {
		 
		// Here is the input
				int[] arr1 = {1,2,3,4,7,6,8};

				//Psuedo code: 
					//Sort the array	
					// loop through the array (start i from arr[0] till the length of the array)

					// check if the iterator variable is not equal to the array values respectively
					
					// print the number
				
					// once printed break the iteration
				
				List<Integer> List1=new ArrayList<Integer>();
				
				for(int i=0;i<arr1.length;i++)
				{
					List1.add(arr1[i]);
				}
				Collections.sort(List1);
				
				System.out.println("The missing number is");
				for(int i=List1.get(0);i<List1.size();i++) {
					if(List1.get(i-1)!=i) {
						System.out.println(i);
						break;
					}
				}

	}

}
