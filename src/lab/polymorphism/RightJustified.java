package lab.polymorphism;

public class RightJustified implements TextBlock{
   // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The text block.
   */
  TextBlock inputTextBlock;

  /**
   * The width of the new block.
   */
  int width;

  /**
   * The height of the new block. 
   * 
   */
  int height;

    // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block by composing left and right side by side.
   */
  public RightJustified(TextBlock inputTextBlock, int width) {
    this.inputTextBlock = inputTextBlock;

    this.width = width;
  }
/**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row (int i) throws Exception {
    return "not yet implemented";
  }

  /**
   * Determine how many rows are in the block.
   */
  public int height(){
    return this.height;
  }

  /**
   * Determine how many columns are in the block.
   */
  public int width(){
    return this.width;
  }
  
  } // RightJustified
