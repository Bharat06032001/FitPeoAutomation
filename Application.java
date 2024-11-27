package fitPeoApplication;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import fitPeoWebElements.FitPeoElements;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Application {
	
	@Test
	public void naviagtion() throws InterruptedException, AWTException {
		
			//ChromeDriver Setup
			WebDriverManager.chromedriver().setup();
			
			//Driver Object
			ChromeDriver driver = new ChromeDriver();
			
			//maximize window
			driver.manage().window().maximize();
			
			//Navigate to FitPeo application
			driver.navigate().to("https://www.fitpeo.com/");
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
			
			//Revenue Calculator
			FitPeoElements.revenueCalculator(driver).click();
			Thread.sleep(2000);
			
			
			//Page Scroll Down			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 500)", "");
			Thread.sleep(2000);
			
			
			//slider Element  (Imported from FitPeoElements class)
			WebElement slider=FitPeoElements.sliderElement(driver);
			
			
			//getting slider width
			int sliderWidth = slider.getSize().getWidth();
			System.out.println("Width of the slider "+sliderWidth);
			
			
			//Setting the slider value as 820
			int currentValue = 200;
			int desiredValue = 820; 
			int maxValue = 2000;
			
			int move = (desiredValue - currentValue) * (sliderWidth / maxValue); 		
			
			Actions act = new Actions(driver);
			act.moveToElement(slider).dragAndDropBy(slider, move, 0).build().perform();			
			Thread.sleep(2000);
			
	
			
			//setting value 560 in value field
			WebElement inputField=FitPeoElements.valueField(driver);			
			inputField.click();
			
			Robot robot = new Robot();
			
			for (int i = 0; i < 3; i++) { 
				
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE); 
				}
			Thread.sleep(2000);
			
			inputField.sendKeys("560");
			Thread.sleep(2000);
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0, 700)", "");
			Thread.sleep(2000);
			
			
			
			
			//Clicking Check Boxes
			
			List<WebElement> checkboxes = driver.findElements(By.cssSelector(".PrivateSwitchBase-input.css-1m9pwf3")); 

			int numberOfCheckboxes = checkboxes.size(); 
			System.out.println("Number of checkboxes found: " + numberOfCheckboxes); 
			
			// Selecting the desired check boxes by index 
				
			checkboxes.get(0).click();
			Thread.sleep(1000);
			
			checkboxes.get(1).click();
			Thread.sleep(1000);
			
			checkboxes.get(2).click();
			Thread.sleep(1000);
			
			checkboxes.get(7).click();
			Thread.sleep(3000);
			
			
			
			 	
			driver.quit();
	}
	
	
	
	


}
