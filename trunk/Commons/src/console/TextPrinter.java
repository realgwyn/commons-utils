package console;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class TextPrinter {

	private JTextComponent textComponent;
	private PrintStream out = System.out;
	private static TextPrinter instance;
	private static boolean isShowTimestamp;
	private static boolean enabled = true;

	private TextPrinter() {
	}

	public static TextPrinter getInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = new TextPrinter();
			return instance;
		}
	}

	/**
	 * swiches from verbose to silent mode
	 * 
	 * @param isSilent
	 */
	public static void setEnabled(boolean isEnabled) {
		enabled = isEnabled;
	}

	/**
	 * If append timestamp
	 * 
	 * @param displayTime
	 */
	public static void showTimestamp(boolean showTimestamp) {
		isShowTimestamp = showTimestamp;
	}

	/**
	 * set text component
	 * 
	 * @param jTextArea
	 */
	public void setTargetComponent(JTextArea jTextArea) {
		this.textComponent = jTextArea;
	}

	/**
	 * set print output stream
	 * 
	 * @param out
	 */
	public void setStandartOutputStream(PrintStream out) {
		this.out = out;
	}

	public void appendString(String str) {
		if (enabled) {
			if (textComponent != null) {
				append(textComponent, str + " ");
			} else {
				out.print(str + " ");
			}
		}

	}

	public void printLine(String str) {
		if (enabled) {
			String displayString;
			if (isShowTimestamp) {
				displayString = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) + " " + str;
			} else {
				displayString = str;
			}

			if (textComponent != null) {
				append(textComponent, displayString + "\n");
			} else {
				out.println(displayString);
			}
		}

	}

	public void print(String str) {
		if (enabled) {
			if (textComponent != null) {
				append(textComponent, str);
			} else {
				out.print(str);
			}
		}

	}

	public void printLine() {
		if (enabled) {
			if (textComponent != null) {
				append(textComponent, "\n");
			} else {
				out.println();
			}
		}

	}

	/**
	 * prints array lines in one line
	 * 
	 * @param array
	 *            - String []
	 */
	public void printLine(String[] array) {
		if (enabled) {
			if (textComponent != null) {
				for (String str : array) {
					append(textComponent, str + " ");
				}
				append(textComponent, "\n");
			} else {
				for (String str : array) {
					out.print(str + " ");
				}
				out.print("\n");
			}
		}

	}

	private void append(JTextComponent component, String text) {
		if (enabled) {
			String sourceText = "";
			if (component.getText() != null) {
				sourceText = component.getText();
				sourceText += text;
			}
			component.setText(sourceText);
		}

	}

}
