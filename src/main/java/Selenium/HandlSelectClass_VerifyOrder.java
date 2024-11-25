package Selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlSelectClass_VerifyOrder {

    public static void main(String[] args) {
        
        // Initialize WebDriver to launch a new instance of Chrome browser
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the signup page where the state dropdown is located
        driver.get("www://freelance-learn-automation.vercel.app/signup");
        
        // Apply an implicit wait of 5 seconds to wait for elements to load before throwing an exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Locate the 'state' dropdown element by its ID and create a Select object to interact with it
        Select state = new Select(driver.findElement(By.id("state")));
        
        // Get all the options (state names) in the dropdown and store them in a list of WebElements
        List<WebElement> allStates = state.getOptions();
        
        // Create an empty list to store the actual order of state names as Strings
        List<String> actualList = new ArrayList<String>();
        
        // Loop through all the WebElements in the dropdown options
        for (WebElement ele : allStates) {
            String stateName = ele.getText(); // Get the text (state name) from each WebElement
            actualList.add(stateName);        // Add the state name to the actualList
        }
        
        // Create another list to store the expected sorted order of the states
        List<String> expectedList = new ArrayList<String>();
        
        // Copy all elements from actualList to expectedList
        expectedList.addAll(actualList);
        
        // Sort the expectedList in alphabetical order
        Collections.sort(expectedList);
        
        // Print both the actual and expected lists for comparison
        System.out.println("Actual List: " + actualList);
        System.out.println("Expected List: " + expectedList);
        
        // Compare the actual list with the expected sorted list
        if (expectedList.equals(actualList)) {
            System.out.println("Validation Passed - The state dropdown is sorted correctly.");
        } else {
            System.out.println("Validation Failed - The state dropdown is not sorted correctly.");
        }
        
        // Quit the browser and end the WebDriver session
        driver.quit();
    }
}
