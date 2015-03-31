package org.rafcio.commons.io.file;

import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CsvUtils {


   public CsvUtils() {
   }

   public void printCSVFile(String filePath) {
      try {
         CSVReader reader = new CSVReader(new FileReader(filePath));
         List<String[]> stringList = reader.readAll();
         reader.close();
         for (String[] array : stringList) {
            for (int i = 0; i < array.length; i++) {
            	System.out.print(array[i]);
            }
            System.out.print("\n");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public List<String[]> readCSVFile(String filePath) {
	   System.out.println("Loading CSV file: " + filePath);
      try {
         CSVReader reader = new CSVReader(new FileReader(filePath));
         List<String[]> stringList = reader.readAll();
         reader.close();
         return stringList;
      } catch (Exception e) {
    	  System.out.println("Error loading " + filePath + " - " + e.getMessage());
         e.printStackTrace();
         return null;
      }
   }
}
