package com.automation.utils;

import com.google.gson.Gson;
import com.automation.models.TestDataModel;

import java.io.FileReader;
import java.io.IOException;

public class TestDataProvider {

    public static TestDataModel[] getTestData(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return new Gson().fromJson(reader, TestDataModel[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new TestDataModel[0];
    }
}
