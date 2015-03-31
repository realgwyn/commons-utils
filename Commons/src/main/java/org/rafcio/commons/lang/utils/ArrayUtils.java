package org.rafcio.commons.lang.utils;

/**
 * @author rafal.kojta
 */
public class ArrayUtils {
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
