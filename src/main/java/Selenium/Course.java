package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Course {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Program Started");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String coursName = "Selenium With Python2";

		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("admin@email.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		WebElement Manage = driver.findElement(By.xpath("//span[normalize-space()='Manage']"));

		Actions action = new Actions(driver);
		action.moveToElement(Manage).click().build().perform();

		driver.findElement(By.xpath("//img[@alt='manage course']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New Course']")).click();

		driver.findElement(By.xpath("//input[@id='thumbnail']"))
				.sendKeys("C:\\Users\\DINESH KUMAR\\OneDrive\\Documents\\sample1.png");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(coursName);
		driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Selenium With Python1");
		driver.findElement(By.xpath("//input[@id='instructorNameId']")).sendKeys("Mukesh Otwani");
		WebElement price = driver.findElement(By.xpath("//input[@id='price']"));
		price.clear();
		price.sendKeys("20000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='startDate']")).clear();
		driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, October 10th, 2024']")).click();
		driver.findElement(By.xpath("//input[@name='endDate']")).clear();
		driver.findElement(By.xpath("//div[@aria-label='Choose Sunday, November 10th, 2024']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Select Category']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Selenium']")).click();
		driver.findElement(By.xpath("//button[@class='action-btn']")).click();

		Thread.sleep(2000);

		WebElement homePage = driver.findElement(By.xpath("//h1[normalize-space()='Learn Automation Courses']"));
		homePage.click();
		Thread.sleep(5000);

		WebElement courseDetailsPage = driver.findElement(By.xpath("//h2[normalize-space()='Selenium With Python2']"));
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);

		System.out.println(courseDetailsPage.getText());
		String crs = courseDetailsPage.getText();
		Thread.sleep(2000);
		if (crs.equalsIgnoreCase(coursName)) {
			System.out.println("Course Detail is presented on page " + crs);
		} else {
			System.out.println("Course Details is not presented " + crs);
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='cartBtn']")).click();
		Thread.sleep(2000);
		action.moveToElement(Manage).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='manage course']")).click();

		Thread.sleep(2000);
		WebElement delete = driver.findElement(By.xpath("//button[@class='action-btn delete-btn']"));

		Thread.sleep(2000);
		delete.click();
		Thread.sleep(4000);
		homePage.click();

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);

		if (!crs.contains(coursName)) {
			System.out.println("After Delete Course Detail is not presented on page " + crs);
		} else {
			System.out.println("Course Details is presented " + crs);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='menu']")).click();
		driver.findElement(By.xpath("//button[@class='nav-menu-item']")).click();

		driver.quit();
		System.out.println("Successfully Logged Out");

	}

}
