package week3.week3day4assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundAlerts {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver= new ChromeDriver();
		
		//Open the url
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		//Shifting control to alert
		

		//Simple Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'simple_result')]")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String Msg1 = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println("\nSimple Alert Message\n------------------------------------------\n"+Msg1);
		
		
		//Confirmation Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'Did you call me')]")).click();
		Thread.sleep(1000);
		alert.accept();
		String Msg2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println("\nConfirmation Alert Message\n------------------------------------\n"+Msg2);
		
		//Sweet Alert
		driver.findElement(By.xpath("(//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'dlg2')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@aria-label='Close'])[1]")).click();
		System.out.println("\nSweet Alert\n--------------------------------\n1) Close the dialog box");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'dlg2')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-secondary')][1]")).click();
		String Msg3 = driver.findElement(By.xpath("//button[contains(@class,'ui-state-hover')]//span[@class='ui-button-text ui-c']")).getText();
		System.out.println("\n2)"+Msg3);
		
		
		//Sweet Modal Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'dlg3')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@aria-label='Close'])[2]")).click();
		System.out.println("\nSweet Modal Alert\n-----------------------------------\nClicking Close");
		
		
		//Prompt Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'prompt')]")).click();
		Thread.sleep(1000);
		alert.sendKeys("Divya Subramanian");
		alert.accept();
		String Msg4 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println("\nPrompt Alert\n-----------------------------------\n1)"+Msg4);
		
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'prompt')]")).click();
		Thread.sleep(1000);
		alert.dismiss();
		String Msg5 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println("\n2)"+Msg5);
		
		//Sweet Confirmation Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'dialog')]")).click();
		Thread.sleep(1000);
			//clicking yes
		driver.findElement(By.xpath("//button[contains(@class,'ui-confirmdialog-yes')]")).click();
		Thread.sleep(1000);
		System.out.println("\nSweet Confirmation Alert\n----------------------------------------\n1)Click Yes");
		
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'dialog')]")).click();
		Thread.sleep(1000);
		
			//Clicking No
		driver.findElement(By.xpath("//button[contains(@class,'ui-confirmdialog-no')]")).click();
		Thread.sleep(1000);
		System.out.println("\n2)Click No");
		
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'dialog')]")).click();
		Thread.sleep(1000);
		
			//Clicking Close
		driver.findElement(By.xpath("(//a[contains(@class,'ui-dialog-titlebar-close')])[4]")).click();
		Thread.sleep(1000);
		System.out.println("\n2)Click Close");
		
		//MinMax Sweet Alert
		driver.findElement(By.xpath("//button[contains(@class,'ui-button-text-icon-left') and contains(@onclick,'dlg4')]")).click();
		Thread.sleep(1000);
			//Click Minimize
		driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-minimize')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-minimize')]")).click();
		Thread.sleep(1000);
		System.out.println("\nMin Max Sweet Alert\n--------------------------------\n1)Minimize");
			//Click Maximize
		driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-maximize')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@class,'ui-dialog-titlebar-maximize')]")).click();
		Thread.sleep(1000);
		System.out.println("\n2)Maximize");
			//Click Close
		driver.findElement(By.xpath("(//a[contains(@class,'ui-dialog-titlebar-close')])[3]")).click();
		Thread.sleep(1000);
		System.out.println("\n3)Close");
		
		driver.close();
			
			}

}
