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
public class CartTools {
    
    public static int getNumberOfItemsInTheCartBasedOnIcon(WebDriver driver){
        WebElement icon = driver.findElement(By.className("shopping_cart_badge"));
        return Integer.parseInt(icon.getText().trim());
    }
}
