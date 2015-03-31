package org.rafcio.commons.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {

   /**
    * loads text file lines to String array
    * 
    * @param path
    *           String - example C://file.txt
    * @return String[] fileLinesArray
    */
   public static String[] read(String path) {
      BufferedReader br = null;
      ArrayList<String> linesList = new ArrayList<String>();
      String[] linesArray = null;
      try {
         String line;
         br = new BufferedReader(new FileReader(path));

         while ((line = br.readLine()) != null) {
            linesList.add(line);
         }
         linesArray = linesList.toArray(new String[linesList.size()]);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try {
            if (br != null)
               br.close();
         } catch (IOException ex) {
            ex.printStackTrace();
         }
      }
      return linesArray;
   }

   /**
    * writes String array to file
    * 
    * @param path
    *           String - example C://file.txt
    * @param contentArray
    *           - String []
    */
   public static void write(String path, String[] contentArray) {
      try {
         File file = new File(path);
         // if file doesnt exists, then create it
         if (!file.exists()) {
            file.createNewFile();
         }
         FileWriter fw = new FileWriter(file.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);
         for (String content : contentArray) {
            bw.write(content + "\n");

         }
         bw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * appends String array to file
    * 
    * @param path
    *           String - example C://file.txt
    * @param linesArray
    *           - String []
    */
   public static void append(String path, String[] contentArray) {
      try {
         File file = new File(path);
         // if file doesnt exists, then create it
         if (!file.exists()) {
            file.createNewFile();
         }
         FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
         BufferedWriter bw = new BufferedWriter(fw);
         for (String content : contentArray) {
            bw.write(content + "\n");
         }
         bw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * deletes specified file
    * 
    * @param path
    */
   public static void delete(String path) {
      try {
         File file = new File(path);
         if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
         } else {
            System.out.println("Delete operation is failed.");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Renames specified path file name to new name
    * 
    * @param oldName
    * @param newName
    */
   public static void rename(String oldName, String newName) {
      File oldfile = new File(oldName);
      File newfile = new File(newName);

      if (oldfile.renameTo(newfile)) {
         System.out.println("Rename succesful");
      } else {
         System.out.println("Rename failed");
      }
   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}
