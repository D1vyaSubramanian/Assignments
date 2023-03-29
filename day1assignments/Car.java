package week1.day1assignments;

public class Car {
	
	public void drivecar() {
		System.out.println("Put the car on Drive");

	}
	public void applyBrake() {
		System.out.println("Apply the Brake");

	}
	public void soundHorn() {
		System.out.println("Press the Horn");

	}
	public void isPuncture() {
		System.out.println("The tyre is punctured");

	}
	public static void main(String[] args) {
		Car checkstatus = new Car();
		checkstatus.drivecar();
		checkstatus.applyBrake();
		checkstatus.soundHorn();
		checkstatus.isPuncture();

	}

}
