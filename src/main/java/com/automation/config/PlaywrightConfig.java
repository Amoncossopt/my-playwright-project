package com.automation.config;

import com.microsoft.playwright.*;

public class PlaywrightConfig {
    private static Playwright playwright;
    private static Browser browser;

    public static Browser getBrowser() {
        if (browser == null) {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        }
        return browser;
    }

    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
            playwright.close();
        }
    }
}
