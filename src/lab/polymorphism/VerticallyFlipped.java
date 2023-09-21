package lab.polymorphism;

/**
 * A text block rearranged (flipped) vertically.
 *
 * @author Jayson Kunkel
 */
public class VerticallyFlipped implements TextBlock{
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
  public VerticallyFlipped (TextBlock _contents){
    this.contents = _contents;
  } // VerticallyFlipped (TextBlock)

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
  
    // returns opposite row from given index
    String result = this.contents.row(h-i-1);

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
   * Access the contents of the block.
   */
  public TextBlock getContents(){
    return this.contents;
  } // getContents()
  
  /**
   * Determine if two TextBlocks are equal (built in the same way)
   */
  public boolean eqv(TextBlock other){
    boolean sameType = this instanceof VerticallyFlipped && other instanceof VerticallyFlipped;
    return sameType && this.contents.eqv(other.getContents());
  } // eqv (TextBlock)

} // class VerticallyFlipped
