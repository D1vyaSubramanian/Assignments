package week3.week3day4assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonBags {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*Psuedo code:
 			(Amazon)
		===============
	01) Launch Chrome  
	02) Load https://www.amazon.in/
     		add  implicitlyWait
     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	03) Type "Bags" in the Search box
	04) Choose the 	 item in the result (bags for boys)
	05) Print the total number of results (like 50000)
    		1-48 of over 50,000 results for "bags for boys"
	06) Select the first 2 brands in the left menu
    		(like American Tourister, Generic)
	07) Choose New Arrivals (Sort)
	08) Print the first resulting bag info (name, discounted price)
	09) Get the page title and close the browser(driver.close())
*/
		
		
		ChromeDriver driver= new ChromeDriver();
		String Search_product="Bags";
		
		//Open the url
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Type Bags
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		element.sendKeys(Search_product);
		
		//Bags for Boys
		driver.findElement(By.xpath("//div[contains(@class,'suggestion')]//span[contains(text(),'boys')]")).click();
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']//span)[1]")).getText();
		System.out.println(text);
		
		//Selecting Brands
		driver.findElement(By.xpath("//li[@aria-label='Safari']//div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@aria-label='American Tourister']//div")).click();
		Thread.sleep(2000);
		
		//Sorting
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
		driver.findElement(By.xpath("//div[@class='a-popover-wrapper']//a[text()='Newest Arrivals']")).click();
		
		//First bag info
		Thread.sleep(2000);
		WebElement Bagbrand = driver.findElement(By.xpath("((//div[contains(@class,'s-title-instructions-style')])[1]//span)[1]"));
		String bag_brandname = Bagbrand.getText();
		WebElement Baginfo = driver.findElement(By.xpath("((//div[contains(@class,'s-title-instructions-style')])[1]//span)[2]"));
		String bag_info = Baginfo.getText();
		WebElement bagprice_rupees = driver.findElement(By.xpath("((//div[contains(@class,'s-price-instructions-style')])[1]//span)[4]"));
		String rupees = bagprice_rupees.getText();
		WebElement bagprice = driver.findElement(By.xpath("((//div[contains(@class,'s-price-instructions-style')])[1]//span)[5]"));
		String price = bagprice.getText();		
		
		//Printing info
		System.out.println("\nThe bag details are as follows:\nBrand \t"+bag_brandname+"\nDetails \t"+bag_info+"\nDiscounted Price \t"+rupees+price);
		
		
		//Title
		String title = driver.getTitle();
		System.out.println("\nThe Page Title is \t"+title);
		
		
		driver.close();
		
		
		
	}

}
