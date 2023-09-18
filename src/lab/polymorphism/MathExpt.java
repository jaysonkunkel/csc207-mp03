package lab.polymorphism;

import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * A few simple experiments with our utilities.
 * Version 1.1 of February 2019.
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print some square roots.
    for (int i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    // Integer n1 = 16;
    // Float n2 = (float)(49.6);
    // Double n3 = 5.5;
    // //BigInteger n4 = new BigInteger(BigInteger.valueOf(4));
    // double n4 = 6.7;

    // pen.println(MathUtils.squareRoot(n1));
    // pen.println(MathUtils.squareRoot(n2));
    // pen.println(MathUtils.squareRoot(n3));
    // pen.println(MathUtils.squareRoot(n4));

    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
