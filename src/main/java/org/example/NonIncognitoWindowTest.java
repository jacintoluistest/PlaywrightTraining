package org.example;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserContext;

import java.nio.file.Paths;

public class NonIncognitoWindowTest {

    public static void main (String args[]) {
        Playwright myPlaywright = Playwright.create();
        Browser myBrowser = myPlaywright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context =
                myPlaywright.chromium().launchPersistentContext(Paths.get(""),new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
        Page myPage = context.newPage();
        myPage.navigate("http://way2automation.com");
        System.out.println(myPage.title());
        myPage.navigate("https://google.com");
        myPage.goBack(new Page.GoBackOptions().setTimeout(500));
        myPage.goForward(new Page.GoForwardOptions().setTimeout(500));
        myPage.close();
        myPlaywright.close();

    }

}
