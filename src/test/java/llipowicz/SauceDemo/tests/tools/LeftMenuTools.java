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
public class LeftMenuTools {

    
    public static void clickOnMenuButton(WebDriver driver){
        WebElement menuButton = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button"));
        menuButton.click();
    }
    
    public static String getLogoutButtonText(WebDriver driver){
        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        return logoutButton.getText();
    }    
}
