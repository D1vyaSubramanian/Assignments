package week3.week3day1Assignments;

public class Students {

	public String getStudentInfo(int id)
	{
		return "The Student Id is \t"+id;
	}
	
	public String getStudentInfo(int id, String name)
	{
		return "The Student Id and Name is \t "+id+"\t"+name;
	}
	
	public String getStudentInfo(String email, long Phonenumber)
	{
		return "The Student email and Phone number is  "+email+"\t"+Phonenumber;
		
	}
	
	
	public static void main(String[] args) {
		
		Students obj=new Students();
		System.out.println(obj.getStudentInfo(32));
		System.out.println(obj.getStudentInfo(32,"Divya"));
		System.out.println(obj.getStudentInfo("divyas.us17@gmail.com", 1007710077));
		
		

	}

}
