package lab.polymorphism;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");

    // Print out the block
    TBUtils.print(pen, block);

    TextBlock block2 = new TextLine ("this is a test.");
    TBUtils.print(pen, block2);

    TextBlock boxedLine = new TextLine("--- hello ---");
    TBUtils.print(pen, boxedLine);

    BoxedBlock lineBox = new BoxedBlock(boxedLine);
    TBUtils.print(pen, lineBox);

    BoxedBlock doubleBoxed = new BoxedBlock(lineBox);
    TBUtils.print(pen, doubleBoxed);

    TextBlock emptyLine = new TextLine("");
    BoxedBlock emptyBox= new BoxedBlock(emptyLine);
    TBUtils.print(pen, emptyBox);


    TextLine hello = new TextLine("Hello");
    TextLine goodbye = new TextLine("Goodbye");

    VComposition helloGoodbye = new VComposition(hello, goodbye);

    TBUtils.print(pen, new BoxedBlock(helloGoodbye));
    
    BoxedBlock helloBox = new BoxedBlock(hello);
    BoxedBlock goodbyeBox = new BoxedBlock(goodbye);

    VComposition helloGoodbye2 = new VComposition(helloBox, goodbyeBox);
    TBUtils.print(pen, helloGoodbye2);

    HComposition helloGoodbye3 = new HComposition(helloBox, goodbye);
    TBUtils.print(pen, helloGoodbye3);
    
    HComposition helloGoodbye4 = new HComposition(goodbye, helloBox);
    TBUtils.print(pen, helloGoodbye4);

    /**
     * HComposition
     * 
     * We would write String row(int rownum) in a similar way to BoxedBlock. 
     * If it's the top or bottom we return dashes, for everything else return the content.
     * Given the left/right parameters, we could have a check for where left ends and right
     * begins.
     * 
     * We would write width() as the width of left and right put together.
     * 
     * We would write height() by taking the maximum height between left and right.
     */
    // Clean up after ourselves.
    pen.close();

    /**
     * VComposition
     * 
     * For String row(int rownum), we would keep track of the widths of the top and bottom.
     * We return the contents of the row, plus spaces if the row is in the narrower of top and bottom.
     * 
     * width() would be the maximum width between top and bottom
     * height would be the sum of the heights of top and bottom
     * 
     */

  } // main(String[])

} // class TBExpt
