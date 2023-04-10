package org.system;

public class Desktop extends Computer {
	
	public void desktopSize() {
		System.out.println("the Desktop size is 16.5");
	}

	public static void main(String[] args) {
		Desktop obj= new Desktop();
		obj.computerModel();
		obj.desktopSize();

	}

}
