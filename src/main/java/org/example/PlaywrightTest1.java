package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.awt.*;

public class PlaywrightTest1{



    public static void main (String args[]) throws InterruptedException{


    setUpBrowser();



    }


    public static void setUpBrowser() throws InterruptedException{
        // Creating Playwright instance
        Playwright myPlaywright = Playwright.create();
        //Setting the browser instance headless in false to see the window
        BrowserType.LaunchOptions browerType = new BrowserType.LaunchOptions().setHeadless(false);
        //Getting browser window size
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        double w = screensize.getWidth();
        double h = screensize.getHeight();

        Browser myBrowser = myPlaywright.chromium().launch(browerType);
        BrowserContext  myBrowserContext = myBrowser.newContext(new Browser.NewContextOptions().setViewportSize((int) w, (int) h));
        Page testPage = myBrowserContext.newPage();
        testPage.navigate("https://automationexercise.com/");
        System.out.println(testPage.title());
        Thread.sleep(3000);
        //Locator productsLink = testPage.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("/products"));
        Locator productsLink = testPage.getByText("Products");
        productsLink.dblclick();
        Thread.sleep(3000);
        System.out.println(testPage.title());
        testPage.close();
        myPlaywright.close();
    }

    public void setPageElements(){

    }

}