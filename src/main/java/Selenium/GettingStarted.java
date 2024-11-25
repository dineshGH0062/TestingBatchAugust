package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GettingStarted {
	public static void main(String[] args) throws InterruptedException {
		String browser = "chrome";
		WebDriver driver = null;
		String url="https://www.selenium.dev/";
		String title="Selenium";

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Brower not found- Please enter any one Chrome,Edge or Firefox");
		}

		driver.get(url);
		String browserTitle=driver.getTitle();
		System.out.println("Expected Title  :- " + browserTitle);
		Thread.sleep(3000);
		if(browserTitle.equalsIgnoreCase(title))
		{
			System.out.println(browser + " Tested Passed");
			
		}
		else  {
			System.out.println(browser +" " + title + "   : -Tested Failed as Title is not matching with Exepeted Title ");
			
		}

		driver.quit();
		
			
		}
		}
		
	
	


