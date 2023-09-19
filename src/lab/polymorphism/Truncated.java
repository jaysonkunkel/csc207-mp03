package lab.polymorphism;

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

    if(_maxWidth < 0 || _maxWidth > this.contents.width()){
      throw new Exception("Invalid width " + maxWidth);
    }// if width is invalid
    else{
      this.maxWidth = _maxWidth;
    }
  } // Truncated)TextBlock, int

/**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row (int i) throws Exception {

    int mw = this.maxWidth;

    // Sanity check
    if ((i < 0) || (i >= mw)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    String result = this.contents.row(i);

    //result = this.row(i);
    //result = this.truncateRow(this.row(i), this.maxWidth);
    result = truncateRow(result, mw);
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


  public String truncateRow (String row, int max){

    char[] truncatedRow = new char[max];
    char[] rowArr = row.toCharArray();

    for(int i = 0; i < max; i++){
      truncatedRow[i] = rowArr[i];
    }

    return new String(truncatedRow);
  } // truncateRow (String, int)

} // class Truncated
