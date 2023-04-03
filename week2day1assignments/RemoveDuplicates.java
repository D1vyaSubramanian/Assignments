package week2.week2day1assignments;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] array=text.split(" ");
		String result=text;
		int count=0;
		for (int i=0;i<array.length;i++)
		{
			for(int j=i+1;j<array.length;j++)	
			{
				if(array[i].equals(array[j]))
				{
					count=count+1;
				}
				
			}
			
			if(count>0)
			{
				result = result.replace(array[i],"");
				count=0;
			}
		}
	
		System.out.println(result);
	
	}

}
