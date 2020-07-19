/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests.scenarios;

import java.util.ArrayList;
import llipowicz.SauceDemo.tests.tools.CartTools;
import llipowicz.SauceDemo.tests.tools.InventoryTools;
import llipowicz.SauceDemo.tests.tools.LoginTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author llipowicz
 */
public class CartScenarios {
    public static int getNumberOfItemsInTheCartAfterPuttingInsideFollowingItems(ArrayList<String>items, WebDriver driver){
        LoginTools.loginToPage(driver);
        CartTools.addElementsToCart(items, driver);
        return CartTools.getNumberOfItemsInTheCartBasedOnIcon(driver);
    }
   
    public static ArrayList<String> getListOfItemsInTheCartAfterPuttingIntoItTheFollowing(ArrayList<String>items, WebDriver driver){
        LoginTools.loginToPage(driver);
        CartTools.addElementsToCart(items, driver);
        CartTools.inspectTheCart(driver);
        return CartTools.getItemsInCart(driver);
    }
    
}
