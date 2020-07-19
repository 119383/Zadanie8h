/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import llipowicz.SauceDemo.tests.scenarios.LoginScenarios;
import llipowicz.SauceDemo.tests.tools.LeftMenuTools;
import llipowicz.SauceDemo.tests.tools.LoginTools;
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
public class LoginTests {
    
    WebDriver driver;
    
    public LoginTests() {
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
     public void testWrongLoginNameGivesWrongCredentialsError() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", LoginTools.loginAndGetMessage(driver,"wrongLogin","secret_sauce"));
     }
     
     @Test
     public void testWrongPasswordGivesWrongCredentialsError() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", LoginTools.loginAndGetMessage(driver,"standard_user","wrongpassword"));
     }
     
     @Test
     public void testLoginAsLockedOutUserGivesLockedOutUserError() {
        assertEquals("Epic sadface: Sorry, this user has been locked out.", LoginTools.loginAndGetMessage(driver,"locked_out_user","secret_sauce"));
     }
     
     @Test
     public void testWrongLoginNameWithSpecialCharsGivesWrongCredentialsError() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", LoginTools.loginAndGetMessage(driver,"special\\name%^&*(","secret_sauce"));
     }
     
     @Test
     public void testWrongPasswordWithSpecialCharsGivesWrongCredentialsError() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", LoginTools.loginAndGetMessage(driver,"standard_user","special!@#$%^&*()"));
     }   
     /**
      * This test assumes that you can see "Logout" button only if you have successfully logged in. 
      */     
     @Test
     public void testSuccessfullyLoggedInWithProperCredentials() {
        assertEquals("Logout",LoginScenarios.loginAndGetLogoutButtonText(driver, "standard_user", "secret_sauce"));
     } 
}
