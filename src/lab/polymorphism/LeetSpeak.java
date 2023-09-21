package lab.polymorphism;

/**
 * A text block where some letters are replaced with numbers to mimic 'leet-speak'
 * 
 * @author Jayson Kunkel
 */
public class LeetSpeak implements TextBlock{
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
  public LeetSpeak (TextBlock _contents){
    this.contents = _contents;
  } // LeetSpeak (TextBlock)

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

    result = toLeet(result);
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
   * Converts some characters in a String to numbers.
   * 
   * @param row The String to be converted
   * @return The converted String
   */
  public static String toLeet(String row) {
        
    char[] rowArr = row.toCharArray();
    char ch;

    for (int i = 0; i < rowArr.length; i++) {
      
      ch = rowArr[i];

      // replace some letters with numbers
      switch(ch){
        case 'l': case 'L': rowArr[i] = '1';
          break;
        case 'e': case 'E': rowArr[i] = '3';
          break;
        case 'a': case 'A': rowArr[i] = '4';
          break;
        case 't': case 'T': rowArr[i] = '7';
          break;
        case 'o': case 'O': rowArr[i] = '0';
          break;
        default: break;
      }

    }
    return new String(rowArr);  
  } // toLeet (String)

  /**
   * Access the contents of the block.
   */
  public TextBlock getContents(){
    return this.contents;
  } // getContents()
  
  /**
   * Determine if two TextBlocks are equal (built in the same way)
   */
  public boolean eqv(TextBlock other){
    boolean sameType = this instanceof LeetSpeak && other instanceof LeetSpeak;
    return sameType && this.contents.eqv(other.getContents());
  } // eqv (TextBlock)

} // class LeetSpeak
