package string;

/**
 * Converts different datatypes and collections to display-friendly string
 * 
 * @author rafcio
 * 
 */
public class ToStringConverter {

	public static String toString(Double[] array) {
		String s = "      [ ";
		s += "      [ ";
		for (int i = 0; i < array.length; i++) {
			s += round(array[i], 4);
		}
		s += "]\n";
		return s;
	}

	public static String toString(Integer[] array) {
		String s = "      [ ";
		if (array.length == 0) {
			s += "     ";
		} else {
			for (int i = 0; i < array.length; i++) {
				s += array[i] + " ";
			}
		}
		s += "]\n";
		return s;
	}

	public static String toString(Double[][] matrix) {
		String s = "Dimensions:" + matrix.length + " x " + matrix[0].length + "\n";
		for (int i = 0; i < matrix.length; i++) {
			s += "      | ";
			for (int j = 0; j < matrix[0].length; j++) {
				s += round(matrix[i][j], 4);
			}
			s += "|\n";
		}
		return s;
	}

	public static String toString(Integer[][] matrix) {
		String s = "Dimensions:" + matrix.length + " x " + matrix[0].length + "\n";
		for (int i = 0; i < matrix.length; i++) {
			s += "      | ";
			for (int j = 0; j < matrix[0].length; j++) {
				s += matrix[i][j] + " ";
			}
			s += "|\n";
		}
		return s;
	}

	public static String toString(Double[][] matrix, int numberOfDigits) {
		String s = "Dimensions:" + matrix.length + " x " + matrix[0].length + "\n";
		for (int i = 0; i < matrix.length; i++) {
			s += "      | ";
			for (int j = 0; j < matrix[0].length; j++) {
				s += round(matrix[i][j], numberOfDigits) + "\t";
			}
			s += "|\n";
		}
		return s;
	}

	private static Double round(Double d, double digitsNumber) {
		if (d != null) {
			double base = Math.pow(10, digitsNumber);
			int i = (int) base;
			return Math.floor(d * i) / i;
		} else {
			return null;
		}

	}

}
