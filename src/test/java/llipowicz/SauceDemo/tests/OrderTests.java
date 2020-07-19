/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import llipowicz.SauceDemo.tests.scenarios.InventoryScenarios;
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
public class OrderTests {
    
    WebDriver driver;
    
    public OrderTests() {
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

    /**
     * This might be a controversial design and one might argue using 
     * Collections.sort might be a better solution, but I am ready to
     * defend my choices.
     */
     @Test
     public void testIfOrderedByPriceAscending() 
     {
         assertEquals(new ArrayList<>(List.of("$7.99","$9.99","$15.99","$15.99","$29.99","$49.99")), InventoryScenarios.getElementsInSortByPriceAscending(driver));
     }
     
     @Test
     public void testIfOrderedByPriceDescending() 
     {
         assertEquals(new ArrayList<>(List.of("$49.99","$29.99","$15.99","$15.99","$9.99","$7.99")), InventoryScenarios.getElementsInSortByPriceDescending(driver));
     }
     @Test
     public void testIfOrderedByNameAtoZ() 
     {
         assertEquals(new ArrayList<>(List.of("Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket", "Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)")), InventoryScenarios.getElementsInSortByNameAToZ(driver));
     }
     @Test
     public void testIfOrderedByNameZtoA() 
     {
         assertEquals(new ArrayList<>(List.of("Test.allTheThings() T-Shirt (Red)","Sauce Labs Onesie","Sauce Labs Fleece Jacket","Sauce Labs Bolt T-Shirt" ,"Sauce Labs Bike Light","Sauce Labs Backpack")), InventoryScenarios.getElementsInSortByNameZToA(driver));
     }        
}
