/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author llipowicz
 */
public class LoginTools {

    public static String loginAndGetMessage(WebDriver driver, String login, String password) {
        loginToPage( driver,  login,  password);
        return getMessage(driver);
    }
    
    public static void loginToPage(WebDriver driver){
        loginToPage(driver, "standard_user", "secret_sauce");
    }    
    
    public static void loginToPage(WebDriver driver, String login, String password){
        typeCredentials(driver,login, password);
        pressLogin(driver);
    }

    private static String getMessage(WebDriver driver) {
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
        return errorText.getText();
    }

    private static void typeCredentials(WebDriver driver, String login, String password) {
        WebElement usernameBox = driver.findElement(By.id("user-name"));
        usernameBox.sendKeys(login);
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys(password);
    }

    private static void pressLogin(WebDriver driver) {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    
}
