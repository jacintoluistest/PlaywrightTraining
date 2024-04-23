package org.example;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class App {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        playwright.chromium().launch();
        }
    }
