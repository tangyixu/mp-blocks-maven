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
   * @param args
   *   Command-line arguments (currently ignored).
   *
   * @exception Exception
   *   If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Circle mountainbase = new Circle('*',11) ;
    AsciiBlock sky = new Rect(' ', 80, 10); 
    AsciiBlock grass = new Rect('^', 80, 1);
    //Circle emptyheart = new Circle('+',2);
    //AsciiBlock linedheart = new Surrounded(emptyheart,'.');
    Trimmed trimmedbase = new Trimmed(mountainbase,HAlignment.LEFT, VAlignment.TOP, 11, 4);
    AsciiBlock.print(pen, trimmedbase);
    //AsciiBlock.print(pen, mountainbase);
    AsciiBlock.print(pen, sky);
    AsciiBlock.print(pen, grass);
    

    pen.close();
  } // main(String[])
} // class Art80x24
