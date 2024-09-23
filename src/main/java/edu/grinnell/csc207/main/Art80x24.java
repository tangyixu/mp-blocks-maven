package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Boxed;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.Padded;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Surrounded;
import edu.grinnell.csc207.blocks.VAlignment;
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
    AsciiBlock boxed = new Boxed(line);
    HFlip hflip = new HFlip(boxed);
    HFlip hflip2 = new HFlip(boxed);

    // AsciiBlock.print(pen, art);
    pen.println("<------------------------->");
    AsciiBlock.print(pen, boxed);
    AsciiBlock.print(pen, hflip);
    AsciiBlock.print(pen, hflip2);
    pen.println(hflip.eqv(hflip2));
    pen.println(hflip.eqv(boxed));

    pen.close();
  } // main(String[])
} // class Art80x24
