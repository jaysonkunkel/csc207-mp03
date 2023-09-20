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

    // // Print out the block
    // TBUtils.print(pen, block);

    // TextBlock block2 = new TextLine ("this is a test.");
    // TBUtils.print(pen, block2);

    // TextBlock boxedLine = new TextLine("--- hello ---");
    // TBUtils.print(pen, boxedLine);

    // BoxedBlock lineBox = new BoxedBlock(boxedLine);
    // TBUtils.print(pen, lineBox);

    // BoxedBlock doubleBoxed = new BoxedBlock(lineBox);
    // TBUtils.print(pen, doubleBoxed);

    // TextBlock emptyLine = new TextLine("");
    // BoxedBlock emptyBox= new BoxedBlock(emptyLine);
    // TBUtils.print(pen, emptyBox);


    TextLine hello = new TextLine("Hello");
    TextLine goodbye = new TextLine("Goodbye");

    VComposition helloGoodbye = new VComposition(hello, goodbye);

    // TBUtils.print(pen, new BoxedBlock(helloGoodbye));
    
    // BoxedBlock helloBox = new BoxedBlock(hello);
    // BoxedBlock goodbyeBox = new BoxedBlock(goodbye);

    // VComposition helloGoodbye2 = new VComposition(helloBox, goodbyeBox);
    // TBUtils.print(pen, helloGoodbye2);

    // HComposition helloGoodbye3 = new HComposition(helloBox, goodbye);
    // TBUtils.print(pen, helloGoodbye3);
    
    // HComposition helloGoodbye4 = new HComposition(goodbye, helloBox);
    // TBUtils.print(pen, helloGoodbye4);

    // VComposition helloHello = new VComposition(hello, hello);
    // TBUtils.print(pen, helloHello);

    // for(int i = 0; i < helloGoodbye4.height(); i++){
    //   pen.println(helloGoodbye4.row(i));
    // }
     Truncated helloT = new Truncated(block, 2);
     Truncated helloGoodbyeT = new Truncated(helloGoodbye, 10);

    // TBUtils.print(pen, helloT);
    // TBUtils.print(pen, helloGoodbye);
    // TBUtils.print(pen, helloGoodbyeT);

    // RightJustified right10 = new RightJustified(helloGoodbye, 10);
    // RightJustified right20 = new RightJustified(helloGoodbye, 20);
    // RightJustified right100 = new RightJustified(helloGoodbye, 100);

    // Centered right10 = new  Centered(helloGoodbye, 10);
    // Centered right20 = new  Centered(helloGoodbye, 20);
    // Centered right100 = new Centered(helloGoodbye, 100);

    // TBUtils.print(pen, right10);
    // TBUtils.print(pen, right20);
    // TBUtils.print(pen, right100);

    HorizontallyFlipped helloHF = new HorizontallyFlipped(helloGoodbye);
    VerticallyFlipped helloVF = new VerticallyFlipped(helloGoodbye);
    LeetSpeak helloLeet = new LeetSpeak(helloGoodbye);

    // TBUtils.print(pen, helloHF);
    // TBUtils.print(pen, helloVF);
    TBUtils.print(pen, helloLeet);

    // Clean up after ourselves.
    pen.close(); 

  

  } // main(String[])

} // class TBExpt
