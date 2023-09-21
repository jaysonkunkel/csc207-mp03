package lab.polymorphism;

/**
 * The vertical composition of two text blocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Jayson Kunkel
 * @version 1.2 of February 2019
 */
public class VComposition implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The top portion of the composition.
   */
  TextBlock top;

  /**
   * The bottom portion of the composition.
   */
  TextBlock bottom;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing top and bottom vertically.
   */
  public VComposition(TextBlock top, TextBlock bottom) {
    this.top = top;
    this.bottom = bottom;
  } // VComposition(TextBlock, TextBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    // Gather some basic information
    int th = this.top.height();
    int bh = this.bottom.height();
    int tw = this.top.width();
    int bw = this.bottom.width();
    int h = th + bh;

    // Determine padding
    String padtop = "";
    String padbot = "";
    if (tw > bw) {
      padbot = TBUtils.spaces(tw - bw);
    } else {
      padtop = TBUtils.spaces(bw - tw);
    } // the bottom is wider

    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } else if (i < th) {
      return this.top.row(i) + padtop;
    } else {
      return this.bottom.row(i - th) + padbot;
    } // if the row is in the bottom half
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    // The height is the sum of the heights of the top and bottom
    // blocks.
    return this.top.height() + this.bottom.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    // The width is the greater of the widths of the top and bottom
    // blocks.
    return Math.max(this.top.width(), this.bottom.width());
  } // width()

  /**
   * Access the contents of the block.
   */
  public TextBlock getContents(){
    return this;
  } // getContents()

  /**
   * Access the top part of the block.
   */
  public TextBlock getTop(){
    return this.top;
  } // getTop()

  /**
   * Access the bottom part of the block.
   */
  public TextBlock getBottom(){
    return this.bottom;
  } // getBottom()
  
  /**
   * Determine if two TextBlocks are equal (built in the same way)
   */
  public boolean eqv(TextBlock other){
    boolean sameType = this instanceof VComposition && other instanceof VComposition;

    if(!sameType){
      return false;
    }

    VComposition otherVC = (VComposition) other;
    return this.eqvTB(otherVC);

  } // eqv (TextBlock)

  /**
   * Determine if the left and right sides of an HComposition are equal (built in the same way)
   */
  public boolean eqvTB (VComposition other){
    boolean equalLefts = this.top.eqv(other.getTop());
    boolean equalRights = this.bottom.eqv(other.getBottom());
    return equalLefts && equalRights;
  } // eqvTB (VComposition)

} // class VComposition
