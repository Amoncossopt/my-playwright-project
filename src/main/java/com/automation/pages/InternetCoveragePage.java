package com.automation.pages;

import com.microsoft.playwright.Page;

public class InternetCoveragePage {
    private final Page page;

    // Locators as constants
    private static final String COOKIE_CONSENT_BUTTON = "#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll";
    private static final String POSTAL_CODE_INPUT = "#postalCodeAddressInput";
    private static final String STREET_NAME_INPUT = "#streetNameAddressInput_input";
    private static final String STREET_NAME_SUGGESTION = ".css-sgkfco";
    private static final String SN_RADIO_BUTTON = "#radioInputCenter";
    private static final String CONTINUE_BUTTON = "button:has-text('Continuar')";
    private static final String ERROR_MESSAGE = "[data-trl-id='responseKoStep:response_ko_step_title']";

    private static boolean cookiesAccepted = false; // Static flag to track cookie consent

    public InternetCoveragePage(Page page) {
        this.page = page;
    }

    public void acceptCookies() {
        if (!cookiesAccepted) {
            try {
                page.waitForSelector(COOKIE_CONSENT_BUTTON);
                page.click(COOKIE_CONSENT_BUTTON);
                cookiesAccepted = true; // Mark cookies as accepted
            } catch (Exception e) {
                System.out.println("Cookie consent button not found or already accepted: " + e.getMessage());
            }
        }
    }

    public void fillPostalCode(String postalCode) {
        page.fill(POSTAL_CODE_INPUT, postalCode);
    }

    public void fillStreetName(String streetName) {
        page.fill(STREET_NAME_INPUT, streetName);
        page.locator(STREET_NAME_SUGGESTION).first().click();
    }

    public void selectSNOption() {
        page.click(SN_RADIO_BUTTON);
    }

    public void clickContinue() {
        page.click(CONTINUE_BUTTON);
    }

    public String getErrorMessage() {
        return page.textContent(ERROR_MESSAGE);
    }
}
