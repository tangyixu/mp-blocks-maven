package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Boxed;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.Padded;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Surrounded;
import edu.grinnell.csc207.blocks.VAlignment;

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
   * @param args
   *   Command-line arguments (currently ignored).
   *
   * @exception Exception
   *   If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    // AsciiBlock art = new Rect('^', 80, 24);
    AsciiBlock line = new Line("HI");
    Surrounded test = new Surrounded(line, 'a');
    AsciiBlock boxed = new Boxed(line);
    AsciiBlock padded = new Padded(boxed, '*', HAlignment.CENTER, VAlignment.CENTER, 10, 9);

    // AsciiBlock.print(pen, art);
    pen.println("<------------------------->");
    AsciiBlock.print(pen, padded);
    AsciiBlock.print(pen, test);
    pen.close();
  } // main(String[])
} // class Art80x24
