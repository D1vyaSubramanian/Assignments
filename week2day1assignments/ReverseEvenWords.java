package week2.week2day1assignments;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String test = "I am a software tester";
		String[] array=test.split(" ");
		char ch[];
/*		for(int i=0;i<array.length;i++)
		{	
			System.out.println(array[i]);
		}
*/		
		for(int i=0;i<array.length;i++)
		{
			if(i%2 ==1)
			{
				ch=array[i].toCharArray();
				for (int j=ch.length-1;j>=0;j--)
				{
					System.out.print(ch[j]);
				}
			}
			else
			{
				System.out.print(array[i]);
			}
			System.out.print(" ");
			
			}
		}

	}

