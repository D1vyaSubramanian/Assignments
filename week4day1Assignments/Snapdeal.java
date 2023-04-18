package week4.week4day1Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		/*Psuedo code
		    1. Launch https://www.snapdeal.com/
			2. Go to Mens Fashion
			3. Go to Sports Shoes
			4. Get the count of the sports shoes
			5. Click Training shoes
			6. Sort by Low to High
			7. Check if the items displayed are sorted correctly
			8.Select the price range (500-1200)
			9.Filter with color yellow 
			10 verify the all applied filters 
			11. Mouse Hover on first resulting Training shoes
			12. click QuickView button
			13. Print the cost and the discount percentage
			14. Take the snapshot of the shoes.
		
		 */
		
		ChromeDriver driver= new ChromeDriver();
		
		//Open the url
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Men's fashion
		WebElement mensfashion = driver.findElement(By.xpath("//a[@class='menuLinks leftCategoriesProduct ']//span[2]"));
		Actions hover= new Actions(driver);
		hover.moveToElement(mensfashion).perform();
		
		//Sports Shoes
			//sport shoe click
			WebElement SportsShoes = driver.findElement(By.xpath("//div[@class=\"colDataInnerBlk\"]/p[2]/a/span[text()='Sports Shoes']"));
			SportsShoes.click();
			//find total count
			String Count=driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
			System.out.println("The total count of sports shoes is \t"+Count);
			Thread.sleep(1000);
			//Sort low to high
			WebElement sort = driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']"));
			sort.click();
			Thread.sleep(2000);

			String text=driver.findElement(By.xpath("//li[@data-sorttype='plth']")).getText();
			System.out.println(text);
			driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
			
			//Check if they are sorted
			
			List<WebElement> element=driver.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
			int totalcount = element.size();
			System.out.println(totalcount);
			List<String> price= new ArrayList<String>();
			Thread.sleep(2000);
			
			for (int i = 1; i < totalcount; i++) {
				Thread.sleep(100);
				price.add(driver.findElement(By.xpath("(//div[@id='products']//span[@class='lfloat product-price'])["+i+"]")).getText());
					}
			
			System.out.println(price);
			
			List<String> Sort= new ArrayList<String>();
			Sort.addAll(price);
			Collections.sort(Sort);
			int count=0;
			
			for (int i = 0; i < totalcount-1; i++) {
				if(!(Sort.get(i).equals(price.get(i)))) {
					count++;
				}
				
			}
			if(count!=0) {
				System.out.println("the sort price low to high is not working");
			}else {
				System.out.println("The Sorting works correctly");
			}
			
			
		//PRICE RANGE
			WebElement min = driver.findElement(By.xpath("//div[@class='price-text-box']//input[@name='fromVal']"));
			min.clear();
			min.sendKeys("500");
			
			WebElement max = driver.findElement(By.xpath("//div[@class='price-text-box']//input[@name='toVal']"));
			max.clear();
			max.sendKeys("1200");
			
			driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
			Thread.sleep(1000);
			
			
		//Color Select
			WebElement color = driver.findElement(By.xpath("//div[@class='sdCheckbox filters-list ']//label[@for='Color_s-Yellow']"));
			driver.executeScript("arguments[0].click()", color);
			Thread.sleep(1000);
			
		//Verify Filters
			
			List<WebElement> filterlist=driver.findElements(By.xpath("//div[@class='filters-top-selected']//div[@class='filters']//div"));
			int noofFilters=filterlist.size();
			//System.out.println(noofFilters+"\n"+filterlist);
			List<String> filters= new ArrayList<String>();
			
			for (int i = 1; i <= noofFilters; i++) {
				filters.add(driver.findElement(By.xpath("(//div[@class='filters-top-selected']//div[@class='filters']//div)["+i+"]")).getText());
				
			}
			System.out.println("The Filters applied are\n"+filters);
			
		//Mouse Hover and Quick View
			WebElement product1 = driver.findElement(By.xpath("//div[@data-js-pos='0']"));
			Actions mousehover= new Actions(driver);
			mousehover.moveToElement(product1);
			
			WebElement quickview = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
			driver.executeScript("arguments[0].click()", quickview);
			
		//Print Price and Discount
			WebElement price1 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']"));
			String priceDiscount = price1.getText();
			System.out.println("The price Details are\n"+priceDiscount);
			
		//Snapshot
			TakesScreenshot scrshot=((TakesScreenshot)driver);
			
			File source = scrshot.getScreenshotAs(OutputType.FILE);
			File dest= new File("./snaps/shoe.png");
			FileUtils.copyFile(source, dest);
			
			
		
		driver.close();
			

	}

}
