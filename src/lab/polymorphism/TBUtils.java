package lab.polymorphism;

import java.io.PrintWriter;
import org.junit.platform.console.shadow.picocli.CommandLine.Help.Ansi.Text;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

    /**
   * Truncates a String to the specified width.
   * 
   * @param row String, the row to truncate
   * @param width The current width of the row
   * @param max The desired width of the row
   * @return The given row truncated to the desired width
   */
  public static String truncateRow (String row, int width, int max){

    char[] truncatedRow = new char[max];
    char[] rowArr = row.toCharArray();

    // pad with spaces to the right
    if(max > width){
      return row + TBUtils.spaces(max - width) + "|";
    }

    // truncate the row
    for(int i = 0; i < max; i++){
      truncatedRow[i] = rowArr[i];
    }

    return new String(truncatedRow);
  } // truncateRow (String, int, int)

  public static boolean equal(TextBlock t1, TextBlock t2) throws Exception{

    if(t1.height() != t2.height() || t1.width() != t2.width()){
      return false;
    }

    for(int i = 0; i < t1.height(); i++){
      if(t1.row(i) != t2.row(i)){
        return false;
      }
    }
    return true;
  } // equal (TextBlock, TextBlock)

  public static boolean eqv(TextBlock t1, TextBlock t2){
    return false;
  } // eqv (TextBlock, TextBlock)

  public static boolean eq(TextBlock t1, TextBlock t2){
    return t1 == t2;
  } // eq (TextBlock, TextBlock)

} // class TBUtils
