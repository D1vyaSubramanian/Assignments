package week2.week2day3assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		/*http://leaftaps.com/opentaps/control/main
	Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
*/

		ChromeDriver driver= new ChromeDriver();
		
		//Open the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Credentials
		driver.findElement(By.id("username")).sendKeys("DemoCsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Lead
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("91");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8012787044");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		WebElement LeadID_1=driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]//a"));
		String ID= LeadID_1.getText();
		
		//System.out.println(ID);
		
		LeadID_1.click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		
		//Check if Deleted
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Name and ID')]")).click();
		WebElement LeadId_input = driver.findElement(By.xpath("//input[contains(@name,'id')]"));
		//LeadId_input.click();
		LeadId_input.sendKeys(ID);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String Norecords= driver.findElement(By.xpath("//div[contains(text(),'No records to display')]")).getText();
		
		if(Norecords.contains("No records"))
		{
			System.out.println("The message shown is\n"+Norecords+"\nThe file has been deleted successfully");
		}
		
		Thread.sleep(5000);
		driver.close();
		
		}
}

