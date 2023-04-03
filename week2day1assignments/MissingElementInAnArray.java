package week2.week2day1assignments;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		System.out.println("The missing number is");
		
		for(int i=arr[0];i<arr.length;i++)
		{
			if(arr[i-1]!=i) {
				System.out.println(i);
				break;
			}
		}

	}

}
