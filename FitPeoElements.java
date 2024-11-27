package fitPeoWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FitPeoElements {
	
	
	public static WebElement revenueCalculator(WebDriver driver) {
		
		return driver.findElement(By.xpath("//a[@href='/revenue-calculator']"));
		
	}
	
	
	public static WebElement sliderElement(WebDriver driver) {
		
	 return driver.findElement(By.xpath("//span[@class='MuiSlider-rail css-3ndvyc']"));
	}
	
	
	public static WebElement valueField(WebDriver driver) {
		
		 return driver.findElement(By.xpath("//input[@id=':r0:']"));
		}
	
	
	
	
	

}
