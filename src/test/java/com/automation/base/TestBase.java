package com.automation.base;

import com.automation.config.PlaywrightConfig;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public abstract class TestBase {
    protected Browser browser;
    protected Page page;

    public void setup() {
        browser = PlaywrightConfig.getBrowser();
        page = browser.newPage();
    }

    public void tearDown() {
        if (page != null) {
            page.close();
        }
        PlaywrightConfig.closeBrowser();
    }
}
