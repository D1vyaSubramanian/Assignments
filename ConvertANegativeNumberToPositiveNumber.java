package week1.day2assignments;

public class ConvertANegativeNumberToPositiveNumber {
	
	public static void main(String[] args) {
		int num=-50;
		if(num>0) {
			System.out.println("\n The number is already positive \t"+num);
		}else if(num<0) {
			System.out.println("\n The number is negative \t"+num);
			num=-(num);
			System.out.println("\n The converted positive number is \t"+num);
		}else {
			System.out.println("\n The number is neither positive nor negative \t"+num);
		}
		
		
	}

}
