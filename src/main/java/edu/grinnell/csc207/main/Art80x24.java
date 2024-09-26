package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.*;
import java.io.PrintWriter;

/**
 * Create and print an amazing 80x24 ASCII artwork.
 *
 * @author Your Name Here
 * @author Your Name Here
 */
public class Art80x24 {
  /**
   * Create the artwork.
   *
   * @param args Command-line arguments (currently ignored).
   * @exception Exception If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    AsciiBlock art = new Rect('^', 80, 24);
    Circle test = new Circle('C', 3);
    AsciiBlock.print(pen, new Surrounded(test, 'x'));

    pen.close();
  } // main(String[])
} // class Art80x24
