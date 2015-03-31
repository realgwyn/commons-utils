package org.rafcio.commons.io.file;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils {

   /**
    * Get standard input
    * 
    * @return BufferedReader Use: BufferedReader br =
    *         StreamIO.getStandardInput();<br>
    *         while((input=br.readLine())!=null){<br>
    *         System.out.println(input);<br>
    *         }<br>
    */
   public static BufferedReader getStandardInput() {
      return new BufferedReader(new InputStreamReader(System.in));
   }

   /**
    * Convert InputStream to String
    * 
    * @param InputStream
    * @return String
    */
   public static String getStringFromInputStream(InputStream is) {
      BufferedReader br = null;
      StringBuilder sb = new StringBuilder();

      String line;
      try {

         br = new BufferedReader(new InputStreamReader(is));
         while ((line = br.readLine()) != null) {
            sb.append(line);
         }

      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (br != null) {
            try {
               br.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
      }

      return sb.toString();
   }

   /**
    * Convert String to InputStream
    * 
    * @param String
    * @return InputStream
    */
   public static InputStream getInputStreamFromString(String string) {
      return new ByteArrayInputStream(string.getBytes());
   }

   /**
    * Convert byte array to InputStream
    * 
    * @param byte[]
    * @return InputStream
    */
   public static InputStream getInputStreamFromByteArray(byte[] array) {
      return new ByteArrayInputStream(array);
   }

}
