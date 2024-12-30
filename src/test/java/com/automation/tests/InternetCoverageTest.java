package com.automation.tests;

import com.automation.base.TestBase;
import com.automation.pages.InternetCoveragePage;
import com.automation.utils.FileUtils;
import com.automation.utils.TestDataProvider;
import com.automation.models.TestDataModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class InternetCoverageTest extends TestBase {

    private static final String TEST_DATA_PATH = "src/test/resources/testData.json";
    private static final String RESULTS_OUTPUT_PATH = "src/test/resources/results.json";

    @BeforeMethod
    public void setUpTest() {
        setup();
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

    @Test
    public void testInternetCoverage() {
        TestDataModel[] testData = TestDataProvider.getTestData(TEST_DATA_PATH);
        Map<String, String> results = new HashMap<>();
        InternetCoveragePage coveragePage = new InternetCoveragePage(page);

        for (TestDataModel data : testData) {
            try {
                page.navigate("https://www.digi.pt/cobertura-internet");

                // Perform steps using page object
                coveragePage.acceptCookies();
                coveragePage.fillPostalCode(data.getPostalCode());
                coveragePage.fillStreetName(data.getStreetName());
                coveragePage.selectSNOption();
                coveragePage.clickContinue();

                // Capture result
                String errorMessage = coveragePage.getErrorMessage();
                results.put(data.getPostalCode(), errorMessage);
            } catch (Exception e) {
                System.err.println("Test failed for postal code: " + data.getPostalCode() + ". Error: " + e.getMessage());
            }
        }

        FileUtils.saveToJsonFile(results, RESULTS_OUTPUT_PATH);
    }
}
