/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llipowicz.SauceDemo.tests.scenarios;

import llipowicz.SauceDemo.tests.tools.LeftMenuTools;
import llipowicz.SauceDemo.tests.tools.LoginTools;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author llipowicz
 */
public class LoginScenarios {
    public static String loginAndGetLogoutButtonText(WebDriver driver, String login, String password){
        LoginTools.loginToPage(driver, login, password);
        LeftMenuTools.clickOnMenuButton(driver);
        return LeftMenuTools.getLogoutButtonText(driver);
    }    
}
