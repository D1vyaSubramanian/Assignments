package week3.week3day2assignments;

public class Automation extends MultipleLanguage {
	
	public void Java() //From Language Interface
	{
		System.out.println("The Language is Java");
	}
	
	public void Selenium()//From TestTool Interface
	{
		System.out.println("The Framework is Selenium");
	}

	public void ruby()//From Abstract class
	{
		System.out.println("The Language is Ruby");
	}
	
	public static void main(String[] args) {

		/*Psuedo code:
		 *  Interface :Language
     		Methods   :Java()
     		Interface :TestTool
     		Methods   :Selenium()
     		AbstractClass :MultipleLangauge
     		Methods   :python() and un implemented method as ruby()
  			Execution class: Automation 
			Implement all the methods of interface and abstract class in Automation class
		 */
		
		Automation obj=new Automation();
		obj.Selenium();
		obj.Java();
		obj.python();
		obj.ruby();
		
		
		
		
	}

}
