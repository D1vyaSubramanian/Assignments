package week1.day2assignments;

public class NegToPosUsingFor {
	//Method2
	public static void main(String[] args) {
		int num1=10;
		for(int i =1; i<3; i++)
		{
			if (num1>0) {
				System.out.println(num1+"\t It's a positive number\n");
				num1= -num1;
			}else if (num1<0) {
				System.out.println(num1+"\tIt's a negative number.\nSo Converting \n"+num1+" to");
				num1=-(num1);
				System.out.println(num1);
							
			}else {
				System.out.println(num1+"\tIt's a whole number\n");
				}
		}
	}

}
