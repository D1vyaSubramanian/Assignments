package week3.week3day2assignments;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection_Collection {

	public static void main(String[] args) {
		/*
		 * Pseudo Code
		
		 * a) Declare An array for {3,2,11,4,6,7};	 
		 * b) Declare another array for {1,2,8,4,9,7};
		 * c) Declare for loop iterator from 0 to array length
		 * d) Declare a nested for another array from 0 to array length
		 * e) Compare Both the arrays using a condition statement
		 
		 *  f) Print the first array (shoud match item in both arrays)
		 */
		
		
		//Assigning Array values to List
		int[] arr1= {3,2,11,4,6,7};
		int[] arr2= {1,2,8,4,9,7};
		List<Integer> List1=new ArrayList<Integer>();
		List<Integer> List2=new ArrayList<Integer>();
		List<Integer> List3=new ArrayList<Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			List1.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++)
		{
			List2.add(arr2[i]);
		}
		


		
		//Find Intersection
		
		for (int i=0;i<List1.size();i++)
		{
			int count=0;
			for (int j=0;j<List2.size();j++)
			{
				if(List1.get(i)==List2.get(j))				{
					count++;
	
				}
			}
				if(count!=0)
				{
					List3.add(List1.get(i));
					
				}
		}
		System.out.println("The intersection elements are \t:"+List3);


}
}