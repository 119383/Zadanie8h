/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests.scenarios;

import java.util.ArrayList;
import llipowicz.SauceDemo.tests.tools.InventoryTools;
import llipowicz.SauceDemo.tests.tools.LoginTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author llipowicz
 */
public class InventoryScenarios {
    // missing space after type
    public static ArrayList<String> getElementsInSortByPriceAscending(WebDriver driver){
        LoginTools.loginToPage(driver);
        Select dropDownMenu= new Select(driver.findElement(By.className("product_sort_container")));
        dropDownMenu.selectByVisibleText("Price (low to high)");
        return InventoryTools.getInventoryItemValuesInCurrentSort(driver, InventoryTools.VALUE.PRICE);
    }
    
    public static ArrayList<String>getElementsInSortByPriceDescending(WebDriver driver){
        LoginTools.loginToPage(driver);
        Select dropDownMenu= new Select(driver.findElement(By.className("product_sort_container")));
        dropDownMenu.selectByVisibleText("Price (high to low)");
        return InventoryTools.getInventoryItemValuesInCurrentSort(driver, InventoryTools.VALUE.PRICE);
    }
    
    public static ArrayList<String>getElementsInSortByNameAToZ(WebDriver driver){
        LoginTools.loginToPage(driver);
        Select dropDownMenu= new Select(driver.findElement(By.className("product_sort_container")));
        dropDownMenu.selectByVisibleText("Name (A to Z)");
        return InventoryTools.getInventoryItemValuesInCurrentSort(driver, InventoryTools.VALUE.NAME);
    }
    
    public static ArrayList<String>getElementsInSortByNameZToA(WebDriver driver){
        LoginTools.loginToPage(driver);
        Select dropDownMenu= new Select(driver.findElement(By.className("product_sort_container")));
        dropDownMenu.selectByVisibleText("Name (Z to A)");
        return InventoryTools.getInventoryItemValuesInCurrentSort(driver, InventoryTools.VALUE.NAME);
    }     
}
