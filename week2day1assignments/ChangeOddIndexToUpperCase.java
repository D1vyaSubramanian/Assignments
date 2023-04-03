package week2.week2day1assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		String test = "changeme";
		char[] ch= test.toCharArray();
		for(int i=1;i<ch.length;i=i+2)
		{
			ch[i]=Character.toUpperCase(ch[i]);
		}
		System.out.print(ch);
	}

}
