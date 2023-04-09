package week2.week2day3assignments;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

//import com.graphbuilder.curve.Point;

public class LeafGround_TextBox {

	

	public static void main(String[] args) throws InterruptedException {

		/* Psuedo Code
		
		TextBox
		=======
		https://www.leafground.com/input.xhtml
		1. Type your name
		2. Append Country to this City
		3. Verify if text box is disabled
		4. Clear the typed text
		5. Retrieve the typed text
		6. Type email and Tab. Confirm control moved to next element
		7. Type about yourself
		8. Text Editor
		9. Just Press Enter and confirm error message*
		10. Click and Confirm Label Position Changes
		11. Type your name and choose the third option
		12. Click and Confirm Keyboard appears
		13. Custom Toolbar

				*/
				
		ChromeDriver driver= new ChromeDriver();
		
		//Open the url
				driver.get("https://www.leafground.com/input.xhtml");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		//TEXTBOX
				
				//Name
				WebElement Name=driver.findElement(By.xpath("//input[@placeholder='Babu Manickam']"));
				Name.click();
				Name.clear();
				Name.sendKeys("DIVYA SUBRAMANIAN");
				
				//Append Country
				driver.findElement(By.xpath("//input[@value='Chennai']")).sendKeys("India");
				
				//Verify if text box disabled
				Thread.sleep(3000);
				WebElement Text_Disable = driver.findElement(By.xpath("//input[contains(@aria-disabled,'true')]"));
				boolean Text= Text_Disable.isEnabled();
				
				if(Text)
				{
					System.out.println("The text box is Enabled");
				}else {
					System.out.println("The text box is Disabled");
				}
				
				
				//Clear and Retrieve the typed text
				driver.findElement(By.xpath("//input[contains(@value,'clear')]")).clear();
				String TypedText= driver.findElement(By.xpath("//input[contains(@value,'learning')]")).getAttribute("value");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[contains(@value,'learning')]")).clear();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[contains(@value,'learning')]")).sendKeys(TypedText);
				
				//Tab and check if control shifts
				WebElement Email= driver.findElement(By.xpath("//input[contains(@placeholder,'email')]"));
				Email.sendKeys("divyas.us17@gmail.com");
				Thread.sleep(1000);
				Email.sendKeys(Keys.TAB);
				Thread.sleep(1000);
				WebElement About_yourself = driver.findElement(By.xpath("//textarea[contains(@placeholder,'yourself')]"));
				boolean control= About_yourself.isDisplayed();
			if(control)
				{
					System.out.println("The control shifts");
				}else
				{
					System.out.println("the control has not been shifted");
				}
				
			//Type about Yourself
			driver.findElement(By.xpath("//textarea[contains(@placeholder,'yourself')]")).sendKeys("I am learning Automation testing");
			
			//Text Editor
			driver.findElement(By.xpath("(//div[contains(@class,'editor')])[3]")).sendKeys("Selenium with core Java");
			
			//Error
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[contains(@name,'age')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[contains(@name,'age')]")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			String ErrorMsg= driver.findElement(By.xpath("//span[contains(@class,'ui-message-error-detail')]")).getText();
			
			if(ErrorMsg.isEmpty()) {
				System.out.println("No Error Message");
			}else {
				System.out.println("The Error is \t"+ErrorMsg);
			}
				
			
			//Label Position Changes
			org.openqa.selenium.Point loc1= driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[contains(@name,'float')]")).click();
			Thread.sleep(1000);
			org.openqa.selenium.Point loc2= driver.findElement(By.xpath("//label[text()='Username']")).getLocation();
			
			System.out.println(loc1+"\n"+loc2);
			if(loc1!=loc2)
			{
				System.out.println("The Position change is confirmed");
			}else
			{
				System.out.println("the position remains the same");
			}
			
			
			//Name and DropDown
			driver.findElement(By.xpath("//li[contains(@class,'autocomplete')]//input")).sendKeys("Divya");
			driver.findElement(By.xpath("(//ul[contains(@class,'ui-autocomplete-list')]//li)[3]")).click();

			//Click and Confirm Keyboard
			driver.findElement(By.xpath("//input[contains(@class,'keyboard')]")).click();
			Thread.sleep(1000);
			if(driver.findElement(By.xpath("//div[contains(@class,'keypad-popup')]")).isDisplayed()) {
				System.out.println("The keyboard pop up is successfull");
			}else {
				System.out.println("the Keyboard pop up failed");
			}
			
			//Custom Toolbar
			driver.findElement(By.xpath("(//div[contains(@class,'ql-editor')])[2]")).sendKeys("The toolbar is customised");
			
			Thread.sleep(2000);
			driver.close();
				

	}

}
