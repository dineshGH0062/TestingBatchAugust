
package Selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlSelectClass_ValidateAllStateValue {

    public static void main(String[] args) {
        
        // Initialize the WebDriver to launch a new Chrome browser instance
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the signup page where the state selection dropdown is located
        driver.get("https://freelance-learn-automation.vercel.app/signup");
        
        // Implicit wait of 5 seconds to give enough time for elements to load before throwing an exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // Locate the 'state' dropdown element by its ID and create a Select object to handle dropdown operations
        Select state = new Select(driver.findElement(By.id("state")));
        
        // Fetch all options available in the 'state' dropdown and store them in a list
        List<WebElement> allStateValues = state.getOptions();

        // Print the number of options available in the dropdown
        System.out.println(allStateValues.size());
        
        // Boolean variable to track whether all expected states are found in the dropdown
        boolean allStatus = true;
        
        // List of expected states that should be available in the dropdown for validation
        List<String> expectedStates = Arrays.asList("Bihar", "Karnataka");
        
        // Iterate over the list of expected states to check if they are present in the dropdown options
        for (String stateValues : expectedStates) {
            boolean status = false;
            
            // Loop through the options available in the dropdown
            for (WebElement ele : allStateValues) {
                String text = ele.getText(); // Get the visible text of each option
                
                // If the dropdown option contains the expected state, mark status as true and break out of the loop
                if (text.contains(stateValues)) {
                    status = true;
                    break;       
                }
            }
            
            // If the expected state is not found in the dropdown, print a message and set allStatus to false
            if (!status) {
                System.out.println("Could not find state: " + stateValues);
                allStatus = false;
            }
        }
        
        // If all expected states were found, print a success message. Otherwise, print a failure message.
        if (allStatus) {
            System.out.println("State found - Validation Pass");
        } else {
            System.out.println("Could not find State - Validation Fail");
        }
        
        // Close the browser instance and terminate the WebDriver session
        driver.quit();
    }
}
