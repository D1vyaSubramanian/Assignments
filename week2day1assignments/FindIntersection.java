package week2.week2day1assignments;

public class FindIntersection {

	public static void main(String[] args) {
		int arr1[]= {3,2,11,4,6,7};
		int arr2[]= {1,2,8,4,9,7,4};
		System.out.println("The intersect values between the two arrays are\n");
		for (int i=0;i<arr1.length;i++)
		{
			int count=0;
			for (int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
				{
					count++;
	
				}
			}
				if(count!=0)
				{
					System.out.print("\t"+arr1[i]);
				}
				
		}

	}

}
