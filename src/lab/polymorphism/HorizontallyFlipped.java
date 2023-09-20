package lab.polymorphism;

/**
 * A text block rearranged (flipped) horizontally.
 *
 * @author Jayson Kunkel
 */
public class HorizontallyFlipped implements TextBlock{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The text block.
   */
  TextBlock contents;

  /**
   * Build a new block from given contents and desired width.
   */
  public HorizontallyFlipped (TextBlock _contents){
    this.contents = _contents;
  } // HorizontallyFlipped (TextBlock)

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row (int i) throws Exception {

    int h = this.contents.height();

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
  
    String result = this.contents.row(i);

    result = reverseRow(result);
    return result;

  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height(){
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width(){
    return this.contents.width();
  } // width()

  /**
   * Reverses the characters in a String.
   * 
   * @param row The String to be reversed
   * @return The reversed String
   */
  public static String reverseRow(String row) {
        
    char[] rowArr = row.toCharArray();

    for (int i = 0; i < rowArr.length/2; i++) {
      char j = rowArr[i];
      rowArr[i] = rowArr[rowArr.length - i - 1];
      rowArr[rowArr.length - i - 1] = j;
    }

    return new String(rowArr);  
  } // reverseRow (String)

} // class HorizontallyFlipped
