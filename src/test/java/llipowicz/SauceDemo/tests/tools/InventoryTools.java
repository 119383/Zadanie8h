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
/*
you should not creat such class
you should depend on page objects, lean page objects and components
https://www.selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/
https://johnfergusonsmart.com/page-objects-that-suck-less-tips-for-writing-more-maintainable-page-objects/
 */
public class InventoryTools {
    
    public enum VALUE{
        NAME,
        PRICE
    }

    // you are passing driver to every method-should be covered by constructor and class field
    public static ArrayList<String> getInventoryItemValuesInCurrentSort(WebDriver driver, VALUE value){
        String searchTag = "";
        if (value.equals(VALUE.NAME)){
            searchTag = "inventory_item_name";
        }
        else {
            searchTag = "inventory_item_price";
        }
        ArrayList<String>itemValues = new ArrayList<>();
        // you should store selectors in variables: @FindBy(yourSelector) private WebElement yourElement;
        List<WebElement> allItemElements = driver.findElements(By.className("inventory_item"));
        for (WebElement singleItem : allItemElements){
            String valueInPage = singleItem.findElement(By.className(searchTag)).getText().replaceAll("\n", "");
            itemValues.add(valueInPage);
        }
        return itemValues;
    }
    
    public static WebElement findItemByName(String itemName, WebDriver driver){
        WebElement result = null;
        List<WebElement> allItemElements = driver.findElements(By.className("inventory_item"));
        for (WebElement singleItem : allItemElements){
            String valueInPage = singleItem.findElement(By.className("inventory_item_name")).getText();
            if (valueInPage.equals(itemName)){
                result = singleItem;
                // missing break (you found item? why iterate further?)
            }
        }
        return result;
    }
    
    public static void addItemToCart(WebElement element){
        WebElement addButton = element.findElement(By.className("btn_inventory"));
        addButton.click();
    }
}
