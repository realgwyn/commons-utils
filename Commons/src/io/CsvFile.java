package io;

import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvFile {

//   TextPrinter textPrinter;

   public CsvFile() {
//      textPrinter = TextPrinter.getInstance();
   }

   public void printCSVFile(String filePath) {
      try {
         CSVReader reader = new CSVReader(new FileReader(filePath));
         List<String[]> stringList = reader.readAll();
         reader.close();
         for (String[] array : stringList) {
            for (int i = 0; i < array.length; i++) {
            	System.out.print(array[i]);
//               textPrinter.appendString(array[i]);
            }
            System.out.print("\n");
//            textPrinter.appendString("\n");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public List<String[]> readCSVFile(String filePath) {
	   System.out.println("Loading CSV file: " + filePath);
//      textPrinter.printLine("Loading CSV file: " + filePath);
      try {
         CSVReader reader = new CSVReader(new FileReader(filePath));
         List<String[]> stringList = reader.readAll();
         reader.close();
         return stringList;
      } catch (Exception e) {
    	  System.out.println("Error loading " + filePath + " - " + e.getMessage());
//         textPrinter.printLine("Error loading " + filePath + " - " + e.getMessage());
         e.printStackTrace();
         return null;
      }
   }
}
