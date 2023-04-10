package week3.week3day1Assignments;

public class BankingInfo extends AxisBank {

	public void saving() {
		System.out.println("the Interest Rate for savings is 5%");
				
	}
	
	public void fixed() {
		System.out.println("The Interest Rate for fixed is 7%");
				
	}
	
	public void deposit() {
		System.out.println("The interest rate for deposit is 7.1%");
	}
	
	
	public static void main(String[] args) {


		BankingInfo obj= new BankingInfo();
		obj.deposit();

	}

}
