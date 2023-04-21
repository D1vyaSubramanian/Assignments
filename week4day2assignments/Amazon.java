package week4.week4day2assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		/*Psuedo Code
		 *  1.Load the URL https://www.amazon.in/
			2.search as oneplus 9 pro 
			3.Get the price of the first product
			4. Print the number of customer ratings for the first displayed product
			5. Click the first text link of the first image
			6. Take a screen shot of the product displayed
			7. Click 'Add to Cart' button
			8. Get the cart subtotal and verify if it is correct.
			9.close the browser
		 */
		
		
		
		
		ChromeDriver driver= new ChromeDriver();
		ChromeOptions noti= new ChromeOptions();
		noti.addArguments("--disable-notifications");
		
		//Open the url
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("oneplus 9 pro");
		searchbox.sendKeys(Keys.ENTER);
		
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1));
		//wait.wait();
		Thread.sleep(1000);
		
		String Price_FirstProduct = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String Price_symbol = driver.findElement(By.xpath("(//span[@class='a-price-symbol'])[1]")).getText();
		
		String Price= Price_symbol+Price_FirstProduct;
		String CustomerRating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		
		
		System.out.println("The Price details are \t"+Price+"\nThe number of Customer rating is \t"+CustomerRating);
		
		driver.findElement(By.xpath("(//a[contains(@class,'s-underline-link-text')])[1]")).click();
		Thread.sleep(1000);
		
		
				//WINDOW HANDLES
		
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> windows = new ArrayList<String>(windowHandles);
				driver.switchTo().window(windows.get(1));
				Thread.sleep(1000);		
				
				//SNAPSHOT
				File source = driver.getScreenshotAs(OutputType.FILE);
				File dest= new File("./snaps/flights.png");
				FileUtils.copyFile(source, dest);
				
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement until = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"))));
		String cartsubtotal = until.getText();
		System.out.println("The Cart SubTotal is \t"+cartsubtotal);
		
		
		
		if(cartsubtotal.contains(Price)) {
			System.out.println("The Price in the Cart remains same ");
		}else {
			System.out.println("The Price in the Cart varies");
		}
		
	driver.quit();	
		
		

		
}

}
