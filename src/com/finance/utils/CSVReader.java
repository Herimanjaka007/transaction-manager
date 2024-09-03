package com.finance.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVReader {
    public static List<String> readDataFromCSV(String URI) {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(URI))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public static List<Map<String, String>> getData(List<String> transactions) {
        return transactions.stream()
                .map(transaction -> {
                    String[] data = transaction.split(",");
                    Map<String, String> result = new HashMap<>();
                    result.put("id", data[0]);
                    result.put("date", data[1]);
                    result.put("montant", data[2]);
                    result.put("type", data[3]);
                    result.put("categorie", data[4]);
                    result.put("description", data[5]);
                    return result;
                })
                .collect(Collectors.toList());
    }

    public static List<Map<String, String>> getDataFromCSV(String URI) {
        return CSVReader.getData(CSVReader.readDataFromCSV(URI));
    }
}
