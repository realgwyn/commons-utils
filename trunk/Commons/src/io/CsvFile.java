package io;

import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import console.TextPrinter;

public class CsvFile {

   TextPrinter textPrinter;

   public CsvFile() {
      textPrinter = TextPrinter.getInstance();
   }

   public void printCSVFile(String filePath) {
      try {
         CSVReader reader = new CSVReader(new FileReader(filePath));
         List<String[]> stringList = reader.readAll();
         reader.close();
         for (String[] array : stringList) {
            for (int i = 0; i < array.length; i++) {
               textPrinter.appendString(array[i]);
            }
            textPrinter.appendString("\n");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public List<String[]> readCSVFile(String filePath) {
      textPrinter.printLine("Loading CSV file: " + filePath);
      try {
         CSVReader reader = new CSVReader(new FileReader(filePath));
         List<String[]> stringList = reader.readAll();
         reader.close();
         return stringList;
      } catch (Exception e) {
         textPrinter.printLine("Error loading " + filePath + " - " + e.getMessage());
         e.printStackTrace();
         return null;
      }
   }
}
