package week1.day2assignments;

public class PrimeNumber {

	public static void main(String[] args) {
		int num=25;
		boolean flag=false;
				
		
		for(int i=2;i<=(num/2);i++)
		{
			if((num%i)==0){
				flag= true;;
			}
		}
		
		if( flag==false) {
			System.out.println(+num+" is a Prime Number \n");
		}else {
			System.out.println(+num+" is not a Prime Number \n");
		}

	}

}
