package week2.week2day3assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafGround_Dropdown {
	public static void main(String[] args) throws InterruptedException {
		
		/* PSUEDO CODE
		DropDown
		========
		https://www.leafground.com/select.xhtml

		Checkbox
		=======
		https://www.leafground.com/checkbox.xhtml

		Radio
		=====
		https://www.leafground.com/radio.xhtml 
			*/
		
		ChromeDriver driver= new ChromeDriver();
	
		//DROPDOWN
		
				//Open the url
				driver.get("https://www.leafground.com/select.xhtml");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				
				WebElement select_element= driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
				Select menu=new Select(select_element);
				List<WebElement> options= menu.getOptions();
				
				for(int i=0;i<options.size();i++) {
					Thread.sleep(1000);
					options.get(i).click();
					
					if(options.get(i).getText().equalsIgnoreCase("puppeteer"))
					{
						break;
					}
				}
				
				
			//CHECKBOX
				//Open the url
				driver.get("https://www.leafground.com/checkbox.xhtml");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				
				
	}

}
