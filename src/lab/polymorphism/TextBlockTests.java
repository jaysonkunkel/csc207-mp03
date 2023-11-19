package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

/**
 * Test suites for TBUtils.equal, TBUtils.eqv, and TBUtils.eq
 * 
 * @author Jayson Kunkel
 */
public class TextBlockTests {
  
  TextBlock hello = new TextLine ("Hello");
  TextBlock goodbye = new TextLine("Goodbye");
  BoxedBlock helloBoxed = new BoxedBlock(hello);
  BoxedBlock goodbyeBoxed = new BoxedBlock(goodbye);
  
  // tests for TBUtils.equal

  @Test
  public void testEqualOne () throws Exception{
    assertEquals(true, TBUtils.equal(new TextLine(""), new TextLine("")),
      "two empty TextBlocks have the same contents");
  }

  @Test
  public void testEqualTwo() throws Exception{
    assertEquals(false, TBUtils.equal(hello, goodbye),
      "hello and goodbye do not have the same contents");
  }

  @Test
  public void testEqualThree() throws Exception{
    TextBlock helloCopy = hello;
    assertEquals(true, TBUtils.equal(hello, helloCopy),
      "a TextBlock has the same contents as a copy of itself");
  }

  @Test
  public void testEqualFour() throws Exception{
    TextBlock helloGoodbyeH = new HComposition(helloBoxed, goodbyeBoxed);
    TextBlock helloGoodbyeV =  new VComposition(helloBoxed, goodbyeBoxed);
    assertEquals(false, TBUtils.equal(helloGoodbyeH, helloGoodbyeV),
      "an HComposition and a VComposition - or any similar permutations - " + 
      "with the same contents are not equal");
  }

  @Test
  public void testEqualFive() throws Exception{
    TextBlock helloBoxedFlipped = new HorizontallyFlipped(helloBoxed);
    TextBlock helloBoxedFlipped2 = new HorizontallyFlipped(helloBoxed);
    assertEquals(true, TBUtils.equal(helloBoxedFlipped, helloBoxedFlipped2),
      "two multi-layer TextBlocks have the same contents");
  }

  @Test
  public void TestEqualSix() throws Exception{
    HorizontallyFlipped helloFlippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello")));
    assertEquals(true, TBUtils.equal(helloFlippedTwice, new TextLine("Hello")),
      "a twice-flipped block has the same contents as the original block");
  }

  @Test
  public void testEqualSeven() throws Exception{
    Truncated helloT = new Truncated(hello, 4);
    Truncated helloT2 =  new Truncated(hello, 5);
    assertEquals(false, TBUtils.equal(helloT, helloT2),
      "two differently-truncated blocks, even if the contents are technically the same, are not equal");
  }

  // tests for TBUtils.eqv

  @Test 
  public void testEqvOne(){
    assertEquals(true, TBUtils.eqv(new TextLine(""), new TextLine("")),
      "two empty TextBlocks are built in the same way");
  }

  @Test
  public void testEqvTwo(){
    assertEquals(true, TBUtils.eqv(hello, goodbye),
      "two single-layer TextBlocks are built in the same way if their types are equal");
  }

  @Test
  public void testEqvThree(){
    TextBlock helloBoxedFlipped = new HorizontallyFlipped(helloBoxed);
    TextBlock goodbyeBoxedFlipped = new HorizontallyFlipped(goodbyeBoxed);
    assertEquals(true, TBUtils.eqv(helloBoxedFlipped, goodbyeBoxedFlipped),
      "two multi-layer TextBlocks are built in the same way if each of their corresponding components" +
      "have equal types");
  }

  @Test
  public void testEqvFour(){
    TextBlock helloCopy = hello;
    assertEquals(true, TBUtils.eqv(hello, helloCopy),
      "a single-layered TextBlock and its copy are built in the same way");
  }

  @Test
  public void testEqvFive(){
    BoxedBlock helloBoxedCopy = helloBoxed;
    assertEquals(true, TBUtils.eqv(helloBoxed, helloBoxedCopy),
      "a multi-layered TextBlock and its copy are built in the same way");
  }

  @Test
  public void testEqvSix(){
    HorizontallyFlipped helloFlippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello")));
    assertEquals(false, TBUtils.eqv(helloFlippedTwice, new TextLine("Hello")),
      "a twice-flipped block is not built in the same way as the original block");
  }

  // tests for TBUtils.eq

  @Test
  public void testEqOne(){
    assertEquals(false, TBUtils.eq(new TextLine(""), new TextLine("")),
      "two empty TextBlocks do not occupy the same memory location");
  }

  @Test
  public void testEqTwo(){
    assertEquals(false, TBUtils.eq(hello, goodbye),
      "two TextBlocks with different contents do not occupy the same memory location");
  }

  @Test
  public void testEqThree(){
    assertEquals(false, TBUtils.eq(hello, new TextLine("Hello")),
      "two TextBlocks with the same contents do not occupy the same memory location");
  }

  @Test
  public void testEqFour(){
    TextBlock helloCopy = hello;
    assertEquals(true, TBUtils.eq(hello, helloCopy),
      "a TextBlock and its copy DO occupy the same memory location");
  }

  @Test
  public void testEqFive(){
    TextBlock helloBoxedFlipped = new HorizontallyFlipped(helloBoxed);
    TextBlock helloBoxedFlippedCopy = helloBoxedFlipped;
    assertEquals(true, TBUtils.eq(helloBoxedFlipped, helloBoxedFlippedCopy),
      "a multi-layered TextBlock and its copy DO occupy the same memory location");
  }

  @Test
  public void testEqSix(){
    HorizontallyFlipped helloFlippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hello")));
    assertEquals(false, TBUtils.eq(helloFlippedTwice, new TextLine("Hello")),
      "a twice-flipped block and the original block do not occupy the same memory location");
  }

  // add tests for centered, leet, right j, vertically flipped

  /**
   * Tests for the Centered blocks
   */
  @Test
  public void testCentered() throws Exception{
    Centered centered = new Centered(new LeetSpeak(new TextLine("computer science")), 10);
    assertEquals(false, TBUtils.equal(centered, new LeetSpeak(new TextLine("computer science"))));
    
    assertEquals(true, TBUtils.eqv(centered, new Centered(new LeetSpeak(new TextLine("")),7)));
  }

  //Tests for the RightJustified blocks
  @Test
  public void testRightJustified() throws Exception{
    RightJustified rj = new RightJustified(new LeetSpeak(new TextLine("hello")), 10);
    assertEquals(true, TBUtils.eqv(rj, new RightJustified(new LeetSpeak(new TextLine("hello")), 5)));
  }

  //Tests for the LeetSpeak blocks
  @Test
  public void testLeetSpeak() throws Exception{
    LeetSpeak ls = new LeetSpeak(new TextLine("computer science"));
    LeetSpeak ls2 = ls;
    assertEquals(true, TBUtils.eq(ls, ls2));
    assertEquals(true, TBUtils.eqv(ls, new LeetSpeak(new TextLine(""))));
    assertEquals(true, TBUtils.equal(new TextLine(""), new LeetSpeak(new TextLine(""))));
  }

  // Tests for the verticallyFLipped blocks
  @Test
  public void testVerticallyFlipped() throws Exception{
    VComposition vc = new VComposition(new TextLine("hello"), new TextLine("goodbye"));
    VerticallyFlipped vf = new VerticallyFlipped(vc);
    assertEquals(false, TBUtils.equal(vf, vc));
    assertEquals(true, TBUtils.equal(vc, new VerticallyFlipped(vf)));

    VerticallyFlipped vf2 = new VerticallyFlipped( new VComposition(new TextLine(""), new TextLine("")));
    assertEquals(true, TBUtils.equal(vf2, new VerticallyFlipped( new VComposition(new TextLine(""), new TextLine("")))));

    assertEquals(true, TBUtils.eqv(vf, vf2));

  }

  /**
   * Tests structures with empty blocks that I did not do so previously.
   */
  @Test
  public void testRestWithEmptyBlocks() throws Exception{
    // boxedblock, hcomp, horiz flipped, truncated
    BoxedBlock bb = new BoxedBlock(new TextLine("hello"));
    assertEquals(true, TBUtils.eqv(bb, new BoxedBlock(new TextLine(""))));
    
    HComposition hc = new HComposition(new TextLine(""), new TextLine(""));
    TextBlock tb = hc;
    assertEquals(true, TBUtils.eq(tb, hc));

    HorizontallyFlipped hv = new HorizontallyFlipped(new TextLine(""));
    assertEquals(true, TBUtils.equal(hv, new HorizontallyFlipped(hv)));

    Truncated t = new Truncated(bb, 3);
    assertEquals(false, TBUtils.eqv(t, new Truncated(new TextLine(""), 2)));

  }

}
