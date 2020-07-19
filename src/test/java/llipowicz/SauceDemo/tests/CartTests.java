/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import llipowicz.SauceDemo.tests.scenarios.CartScenarios;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author llipowicz
 */
public class CartTests {
    
    WebDriver driver;    
    
    public CartTests() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        WebDriverManager.firefoxdriver().setup();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        driver  = new FirefoxDriver();
        driver.get("https://www.saucedemo.com");
    }
    
    @AfterEach
    public void tearDown() {
        driver.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
    public void addTwoItemsIntoTheCartAndCheckIfCartIconDisplaysTwoItems() {
        assertEquals(2, CartScenarios.getNumberOfItemsInTheCartAfterPuttingInsideFollowingItems(new ArrayList<>(List.of("Test.allTheThings() T-Shirt (Red)","Sauce Labs Onesie")), driver));
    }
    
     @Test
    public void addTwoItemsIntoTheCartAndCheckIfDetailsAreDisplayed() {
        assertEquals((new ArrayList<>(List.of("Test.allTheThings() T-Shirt (Red)","Sauce Labs Onesie"))), CartScenarios.getListOfItemsInTheCartAfterPuttingIntoItTheFollowing(new ArrayList<>(List.of("Test.allTheThings() T-Shirt (Red)","Sauce Labs Onesie")), driver));
    }    
    
}
