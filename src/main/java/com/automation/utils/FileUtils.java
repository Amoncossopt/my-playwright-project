package com.automation.utils;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileUtils {

    public static void saveToJsonFile(Map<String, String> data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            new Gson().toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
