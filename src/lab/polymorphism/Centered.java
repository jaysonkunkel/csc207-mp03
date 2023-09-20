package lab.polymorphism;

/**
 * A text block centered in a given width.
 *
 * @author Jayson Kunkel
 */
public class Centered implements TextBlock{
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
   * Build a new block by centering contents in a given width.
   */
  public Centered(TextBlock _contents, int _maxWidth) throws Exception
  {
    this.contents = _contents;

    if(_maxWidth < 0 || _maxWidth < _contents.width()){
      throw new Exception("Invalid width " + _maxWidth);
    }
    else{
      this.maxWidth = _maxWidth;
    } // if the width is invalid
  } // Centered(TextBlock, int)

/**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row (int i) throws Exception {
    
    int mw = this.maxWidth;
    int w = this.contents.width();
    int h = this.contents.height();

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    // determine padding
    if(w == mw){
      return this.contents.row(i);
    }
    else{
      String padFront = TBUtils.spaces((mw - w) / 2);
      String padBack = padFront;
      return "|" + padFront + this.contents.row(i) + padBack + "|";
    }
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
  
} // class Centered