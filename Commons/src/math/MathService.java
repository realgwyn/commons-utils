package math;

/**
 * 
 * @author rafcio
 * 
 */
public class MathService {

   /**
    * @param args
    */

   /**
    * Rounds down double number to specified decimal lenght
    * 
    * @param Double
    *           input number
    * @param digitsNumber
    *           how many decimal places
    * @return
    */
   public static Double round(Double d, double digitsNumber) {
      if (d != null) {
         double base = Math.pow(10, digitsNumber);
         int i = (int) base;
         return Math.floor(d * i) / i;
      } else {
         return null;
      }
   }

   /**
    * Computes arithmetic average of array of numbers
    * 
    * @param numberSet
    * @return Double average
    */
   public static Double average(Double[] numberSet) {
      double sum = 0;
      for (int i = 0; i < numberSet.length; i++) {
         sum += numberSet[i];
      }
      return sum / numberSet.length;
   }

   /**
    * Finds max value from array
    * 
    * @param numberSet
    * @return max value
    */
   public static Double max(Double[] numberSet) {
      if (numberSet.length != 0) {
         double max = numberSet[0];
         for (int i = 0; i < numberSet.length; i++) {
            if (max < numberSet[i]) {
               max = numberSet[i];
            }
         }
         return max;
      } else {
         return null;
      }
   }

   /**
    * Sums all numbers from array
    * 
    * @param numberSet
    * @return
    */
   public static double sum(double[] numberSet) {
      double sum = 0;
      for (int i = 0; i < numberSet.length; i++) {
         sum += numberSet[i];
      }
      return sum;
   }

   /**
    * 
    * @param numberSet
    * @param valueSet
    * @return
    */
   public static Double[] multiplyByValues(Double[] numberSet, Double[] valueSet) {
      for (int i = 0; i < numberSet.length; i++) {
         numberSet[i] = numberSet[i] * valueSet[i];
      }
      return numberSet;
   }

   /**
    * returns row of 2-dimensional array
    * 
    * @param array
    * @param rowIndex
    * @return
    */
   public static Double[] getRow(Double[][] array, int rowIndex) {
      Double row[] = new Double[array[rowIndex].length];
      for (int i = 0; i < array[rowIndex].length; i++) {
         row[i] = array[rowIndex][i];
      }
      return row;
   }

   /**
    * returns column of 2-dimensional array
    * 
    * @param array
    * @param columnIndex
    * @return
    */
   public static Double[] getColumn(Double[][] array, int columnIndex) {
      Double column[] = new Double[array.length];
      for (int i = 0; i < array.length; i++) {
         column[i] = array[i][columnIndex];
      }
      return column;
   }

   /**
    * sets row for 2-dimensional array
    * 
    * @param array
    * @param row
    * @param rowIndex
    * @return
    */
   public static Double[][] setRow(Double[][] array, Double[] row, int rowIndex) {
      for (int i = 0; i < array[rowIndex].length; i++) {
         array[rowIndex][i] = row[i];
      }
      return array;
   }

   /**
    * sets column for 2-dimensional array
    * 
    * @param array
    * @param column
    * @param columnIndex
    * @return
    */
   public static Double[][] setColumn(Double[][] array, Double[] column, int columnIndex) {
      for (int i = 0; i < array.length; i++) {
         array[i][columnIndex] = column[i];
      }
      return array;
   }

   /**
    * Creates copy of 2dimensional array
    * 
    * @param source
    * @param target
    *           - copied array[][]
    * @return copied array[][]
    */
   public static Double[][] arrayCopy(Double[][] source, Double[][] target) {
      for (int i = 0; i < source.length; i++) {
         System.arraycopy(source[i], 0, target[i], 0, source[i].length);
      }
      return target;
   }

}
