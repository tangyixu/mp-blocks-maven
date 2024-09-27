package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Circle;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Surrounded;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.VComp;
import java.io.PrintWriter;

/**
 * Create and print an amazing 80x24 ASCII artwork.
 *
 * @author Your Name Here
 * @author Your Name Here
 */
public class Art80x24 {

  /**
   * Trunk helper function.
   *
   * @param width width
   * @param height height
   * @return a rect representing the tree trunk
   * @throws Exception
   */
  public static AsciiBlock trunk(int width, int height) throws Exception {
    Rect trunkRect = new Rect('|', width, height);
    return trunkRect;
  } // trunk(int, int)

  /**
   * Creates tree leaves.
   *
   * @param size size of leave
   * @return AsciiBlock representing the leaves
   * @throws Exception
   */
  public static AsciiBlock leaves(int size) throws Exception {
    Rect[] combinedleaves = new Rect[size];
    for (int i = 0; i < size; i++) {
      int n = i;
      n += 2;
      if (i == 0) {
        n = 1;
      } // if
      if (n % 2 == 0) {
        n++;
      } // if
      combinedleaves[i] = new Rect('*', n, 1);
    } // for
    AsciiBlock leaves = new VComp(HAlignment.CENTER, combinedleaves);
    return leaves;
  } // leaves(int)

  /**
   * Creates a tree. Combining leaves and trunk
   *
   * @param leavesize size of leave
   * @param trunkwidth width of trunk
   * @param trunkheight height of trunk
   * @return AsciiBlock representing a single tree
   * @throws Exception
   */
  public static AsciiBlock tree(int leavesize, int trunkwidth, int trunkheight) throws Exception {
    AsciiBlock[] wholetree = {leaves(leavesize), trunk(trunkwidth, trunkheight)};
    AsciiBlock tree = new VComp(HAlignment.CENTER, wholetree);
    return tree;
  } // tree(int, int, int)

  /**
   * Create the artwork.
   *
   * @param args Command-line arguments (currently ignored).
   * @exception Exception If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Circle test = new Circle('C', 3);
    AsciiBlock.print(pen, new Surrounded(test, 'x'));

    // Make the grass and sky
    AsciiBlock sky = new Rect(' ', 80, 5);
    AsciiBlock grass = new Rect('^', 80, 1);

    // Make the trees in line
    AsciiBlock trees = new Rect(' ', 5, 5);
    AsciiBlock[] forest = new AsciiBlock[11];
    for (int n = 0; n < 11; n++) {
      if (n % 2 != 0) {
        forest[n] = new Rect(' ', 5, 5);
      } else {
        int treesize = (int) (Math.random() * 10 + 1);
        int trunkwidth = (int) (Math.random() * 10 + 1);
        if (trunkwidth > treesize) {
          int hold = treesize;
          treesize = trunkwidth;
          trunkwidth = hold;
        } // if
        int trunkheight = (int) (Math.random() * 10 + 1);

        forest[n] = tree(treesize, trunkwidth, trunkheight);
      } // if
      AsciiBlock hold = trees;
      trees = new HComp(VAlignment.BOTTOM, hold, forest[n]);
    } // for

    // Final Forest Picture
    AsciiBlock.print(pen, sky);
    AsciiBlock.print(pen, trees);
    AsciiBlock.print(pen, grass);

    pen.close();
  } // main(String[])
} // class  Art80x24
