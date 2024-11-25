package Selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCategory {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		
		String parent=driver.getWindowHandle();
		driver.get("https://freelance-learn-automation.vercel.app/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='New user? Signup']")).click();
		int boxes = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		System.out.println("no of boxes:"+boxes);
		if(boxes>5)
		{
			System.out.println("verified checkboxes are greater than 5");
		
	    }
		else
		{
			System.out.println(" checkboxes are not greater than 5");
		}
	
		driver.navigate().back();
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Actions actions = new Actions(driver);
		WebElement hoverElement = driver.findElement(By.xpath("//span[text() = 'Manage']"));
		actions.moveToElement(hoverElement).perform();
		
	//	driver.findElement(By.xpath("//span[text() = 'Manage']")).click();
		WebElement ManageCategory = driver.findElement(By.xpath("//a[normalize-space()='Manage Categories']"));
		ManageCategory.click();
		//actions.moveToElement(ManageCategory).perform();
		//Set<String> Windows=driver.getWindowHandles();
		Set<String> allWindows=driver.getWindowHandles();
		for(String handle:allWindows) 
		{
			
			if(!parent.equals(handle))
			{
				System.out.println(driver.getCurrentUrl());
				driver.switchTo().window(handle);
				System.out.println(driver.getCurrentUrl());				
				driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();
			
			}
		}
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		
	    String inputText = "Ali Cloud New 3";
	    alert.sendKeys(inputText);
	    Thread.sleep(1000);
	    alert.accept();
	    boolean status= driver.findElement(By.xpath(" //table//td[text()='"+inputText+"']")).isDisplayed();
	    
	    if(status)
	    {
	    	System.out.print("Validation Pass - Course Added");
	    }else
	    {
	    	System.out.print("Validation Fail - Course Could Not Added");
	    }
		
	    driver.findElement(By.xpath("//img[@alt='menu']")).click();
	    
	    driver.findElement(By.xpath("//button[text()= 'Sign out']")).click();
	    
	    driver.close();
	    
	    driver.switchTo().window(parent);
	    
	    
		driver.get("https://freelance-learn-automation.vercel.app/");
		
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='New user? Signup']")).click();
		
		if(driver.findElement(By.xpath("//label[text()='"+inputText+"']")).isDisplayed())
		{
			System.out.print("Catergory is present in registration page");
		}
		else
		{
			System.out.print("Catergory isnot  present in registration page");

		}
		
		driver.navigate().back();
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//input[@name='email1']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		WebElement hoverElemenNewt = driver.findElement(By.xpath("//span[text() = 'Manage']"));

		actions.moveToElement(hoverElemenNewt).perform();
	
		WebElement ManageCategoryNew = driver.findElement(By.xpath("//a[normalize-space()='Manage Categories']"));

		ManageCategoryNew.click();
		
		Set<String> allWindowsNew=driver.getWindowHandles();
		for(String handle:allWindowsNew) 
		{
			
			if(!parent.equals(handle))
			{
				System.out.println(driver.getCurrentUrl());
				driver.switchTo().window(handle);
				System.out.println(driver.getCurrentUrl());				
				// delete here
			
			}
		}
		
		
	
	}

}
