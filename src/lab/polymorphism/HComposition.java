package lab.polymorphism;

/**
 * The horizontal composition of two text blocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Jayson Kunkel
 * @version 1.3 of February 2019
 */
public class HComposition implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left portion of the composition.
   */
  TextBlock left;

  /**
   * The right portion of the composition.
   */
  TextBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing left and right side by side.
   */
  public HComposition(TextBlock left, TextBlock right) {
    this.left = left;
    this.right = right;
  } // HComposition(TextBlock, Textblock)

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
    int lh = this.left.height();
    int rh = this.right.height();
    int h = Math.max(lh, rh);

    // Sanity check
    if ((i < 0) || (i >= h)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result;
    if (i < lh) {
      result = this.left.row(i);
    } else {
      result = TBUtils.spaces(this.left.width());
    }
    if (i < rh) {
      result = result.concat(this.right.row(i));
    } else {
      result = result.concat(TBUtils.spaces(this.right.width()));
    }

    return result;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    // The height is the greater of the heights of the left and right
    // blocks.
    return Math.max(this.left.height(), this.right.height());
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    // The number of columns is the width of the left plus the
    // width of the right.
    return this.left.width() + this.right.width();
  } // width()

  /**
   * Access the contents of the block.
   */
  public TextBlock getContents(){
    return this;
  } // getContents()

  /**
   * Access the left side of the block.
   */
  public TextBlock getLeft(){
    return this.left;
  } // getLeft()

  /**
   * Access the right side of the block.
   */
  public TextBlock getRight(){
    return this.right;
  } // getRight()
  
  /**
   * Determine if two TextBlocks are equal (built in the same way)
   */
  public boolean eqv(TextBlock other){
    boolean sameType = this instanceof HComposition && other instanceof HComposition;

    if(!sameType){
      return false;
    }

    HComposition otherHC = (HComposition) other;
    return this.eqvLR(otherHC);

  } // eqv (TextBlock)

  /**
   * Determine if the left and right sides of an HComposition are equal (built in the same way)
   */
  public boolean eqvLR (HComposition other){
    boolean equalLefts = this.left.eqv(other.getLeft());
    boolean equalRights = this.right.eqv(other.getRight());
    return equalLefts && equalRights;
  } // eqvLR (HComposition)
  
} // class HComposition
