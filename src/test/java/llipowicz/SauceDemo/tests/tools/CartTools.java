/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests.tools;

import java.util.ArrayList;
import java.util.List;
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
    
    public static void addElementsToCart(ArrayList<String>items, WebDriver driver){
        for (String item : items){
            WebElement element = InventoryTools.findItemByName(item, driver);
            InventoryTools.addItemToCart(element);
        }    
    }
    
    public static void inspectTheCart(WebDriver driver){
        driver.findElement(By.className("shopping_cart_link")).click();
    }    

    public static ArrayList<String> getItemsInCart(WebDriver driver) {
        ArrayList<String> results = new ArrayList<>();
        List<WebElement> findElements = driver.findElements(By.className("inventory_item_name"));
        for (WebElement e : findElements){
            results.add(e.getText());
        }
        return results;
    }
}
