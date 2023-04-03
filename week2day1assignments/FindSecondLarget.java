package week2.week2day1assignments;

import java.util.Arrays;

public class FindSecondLarget {

	public static void main(String[] args) {
		int arr[]= {3,2,11,4,6,7};
		Arrays.sort(arr);
		System.out.println("The second Largest number is \t"+arr[arr.length-2]);

	}

}
