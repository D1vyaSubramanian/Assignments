package week3.week3day2assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest_collection {

	public static void main(String[] args) {
		
		// Here is the input
		//int[] data = {3,2,11,4,6,7};

		 /*Pseudo Code:
		 1) Arrange the array in ascending order
		 2) Pick the 2nd element from the last and print it
		 */
		
		int arr1[]= {3,2,11,4,6,7};
		List<Integer> List1=new ArrayList<Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			List1.add(arr1[i]);
		}
		Collections.sort(List1);
		System.out.println("The second Largest number is \t:"+List1.get(List1.size()-2));

	}

}
