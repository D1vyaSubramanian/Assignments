package week4.week4day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		/*Psuedo Code
			1) Go to https://www.nykaa.com/
			2) Mouseover on Brands and Search L'Oreal Paris
			3) Click L'Oreal Paris
			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
			5) Click sort By and select customer top rated
			6) Click Category and click Hair->Click haircare->Shampoo
			7) Click->Concern->Color Protection
			8)check whether the Filter is applied with Shampoo
			9) Click on L'Oreal Paris Colour Protect Shampoo
			10) GO to the new window and select size as 175ml
			11) Print the MRP of the product
			12) Click on ADD to BAG
			13) Go to Shopping Bag 
			14) Print the Grand Total amount
			15) Click Proceed
			16) Click on Continue as Guest
			17) Check if this grand total is the same in step 14
			18) Close all windows
			
			*/
		ChromeDriver driver= new ChromeDriver();
		ChromeOptions noti= new ChromeOptions();
		noti.addArguments("--disable-notifications");
		
		//Open the url
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Mouseover on brands and search L'oreal paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		
		Actions mouseover= new Actions(driver);
		mouseover.moveToElement(brands).perform();
		
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='scroller-container']/div[2]/a")).click();
		
		String lorealparis = driver.getTitle();
		if(lorealparis.equalsIgnoreCase("L'Oreal Paris")) {
			System.out.println("The page title is\n"+lorealparis );	
		}
		
		//Sort top Rated
		WebElement sort = driver.findElement(By.xpath("//span[@class='sort-name']"));
		sort.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//Select Category
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(1000);
		
		//Check Filters
		List<WebElement> filtervalues = driver.findElements(By.xpath("//span[@class='filter-value']"));
		List<String> filters = new ArrayList<String>();
		
		int totalfilters= filtervalues.size();
		for (int i = 0; i <totalfilters; i++) {
			filters.add(filtervalues.get(i).getText());
			
		}
		
		System.out.println("The Filters applied are \n"+filters);
		
		
		//Product
		driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
		
		
		//10) GO to the new window and select size as 175ml
		//WINDOW HANDLES
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows= new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windows.get(1));
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		
		//11) Print the MRP of the product
		String price = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']")).getText();
		System.out.println("The Price of the product is \t"+price);
		
		
		//12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]/parent::button")).click();
		
		
		//13) Go to Shopping Bag
		driver.findElement(By.xpath("//div[@class='css-0 e1ewpqpu1']//*[name()='svg']")).click();
		Thread.sleep(1000);
		
		driver.switchTo().frame(0);
		Thread.sleep(500);
		WebElement grandtotal = driver.findElement(By.xpath("(//div[@class='css-1mx04mv e25lf6d3']/div)[1]"));
		mouseover.scrollToElement(grandtotal);
		
		String grandtotalprice = grandtotal.getText();
		System.out.println("\nThe grandtotal is \t"+grandtotalprice);
		
		WebElement proceed = driver.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d1']/following-sibling::div[1]"));
		//proceed.click();
		//driver.executeScript("arguments[0].click()", proceed);
		
		
		//Other click methods didnt work so using ACTIONS
		mouseover.moveToElement(proceed).click(proceed).perform();
		
		//Continue as guest
		WebElement continueasguest = driver.findElement(By.xpath("//button[text()='Continue as guest']"));
		mouseover.moveToElement(continueasguest).click(continueasguest).perform();
		
		WebElement endprice = driver.findElement(By.xpath("(//div[@class='leftSelector css-1xck50t e87w9871'])[2]/p"));
		String End_price = endprice.getText();
		System.out.println("The End Price is \t"+End_price);
		
		if(End_price.equalsIgnoreCase(grandtotalprice)) {
			System.out.println("The Price value remains same at the end");
		}else {
			System.out.println("The Price value varies at the end");
		}
		
		driver.quit();
	}

}
