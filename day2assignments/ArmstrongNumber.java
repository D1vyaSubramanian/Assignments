package week1.day2assignments;
public class ArmstrongNumber {

	public static void main(String[] args) {
		int input=153;
		int value=input;
		int quotient,remainder;
		double Arm_sum=0;
		System.out.println("The sum of");
		while(value>0)
		{
			quotient=value/10;
			remainder= value%10;
			value=quotient;
			System.out.println(+remainder+"*"+remainder+"*"+remainder);
			Arm_sum+=(remainder*remainder*remainder);
		}
		System.out.println("\nis\t"+Arm_sum+"\n");
		
		
		if(Arm_sum==input){
			System.out.println(+input+"\tis an Armstrong Number");
		}else {
			System.out.println(+input+"\tis not an Armstrong Number");
		}

	}

}
