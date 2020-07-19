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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author llipowicz
 */
public class CartScenarios {
    public static int getNumberOfItemsInTheCartAfterPuttingInsideFollowingItems(ArrayList<String>items, WebDriver driver){
        LoginTools.loginToPage(driver);
        for (String item : items){
            WebElement element = InventoryTools.findItemByName(item, driver);
            InventoryTools.addItemToCart(element);
        }
        return CartTools.getNumberOfItemsInTheCartBasedOnIcon(driver);
    }
}
