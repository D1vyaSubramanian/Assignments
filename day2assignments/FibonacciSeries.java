package week1.day2assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		int num1=0,num2=1,range=8,Fib_sum;
		System.out.println("The Fibonacci series is\n");
		for(int i=0;i<range;i++) {
			System.out.println(num1);
			Fib_sum=num1+num2;
			num1=num2;
			num2=Fib_sum;
			
		}

	}

}
