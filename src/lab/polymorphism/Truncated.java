package lab.polymorphism;

/**
 * A text block truncated to a given width.
 *
 * @author Jayson Kunkel
 */
public class Truncated implements TextBlock{
  
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The text block.
   */
  TextBlock contents;

  /**
   * The desired width of the new block.
   */
  int maxWidth;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block from given contents and desired width.
   */
  public Truncated (TextBlock _contents, int _maxWidth) throws Exception{

    this.contents = _contents;

    if(_maxWidth < 0 ){
      throw new Exception("Invalid width " + maxWidth);
    }// if width is invalid
    else{
      this.maxWidth = _maxWidth;
    }
  } // Truncated (TextBlock, int)

/**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row (int i) throws Exception {

    int w = this.contents.width();
    int mw = this.maxWidth;
    int h = this.contents.height();

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result = this.contents.row(i);

    result = TBUtils.truncateRow(result, w, mw);
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
    return this.maxWidth;
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
    boolean sameType = this instanceof Truncated && other instanceof Truncated;
    return sameType && this.contents.eqv(other.getContents());
  } // eqv (TextBlock)

} // class Truncated
