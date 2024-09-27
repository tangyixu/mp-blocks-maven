package edu.grinnell.csc207.main;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Circle;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Surrounded;
import edu.grinnell.csc207.blocks.VComp;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.VAlignment;
import java.io.PrintWriter;
import java.lang.Math;


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

   //trunk helper function
   public static AsciiBlock trunk (int width, int height) throws Exception
   {
    Rect a = new Rect ('|', width, height);
    return a;
   }

   //tree leave helper function
   public static AsciiBlock leaves (int size) throws Exception{
     Rect[] combinedleaves = new Rect[size];
     for(int i = 0;i < size;i++)
     {
      int n = i;
      n += 2;
      if (i == 0)
       n = 1;
      if (n % 2 == 0)
       n++;
      combinedleaves[i] = new Rect('*', n, 1);
     }
     AsciiBlock leaves = new VComp(HAlignment.CENTER, combinedleaves);
     return leaves;
   }

    //tree helper function
    public static AsciiBlock tree(int leavesize, int trunkwidth, int trunkheight)throws Exception
    {
      AsciiBlock[] wholetree = {leaves(leavesize), trunk(trunkwidth,trunkheight)};
      AsciiBlock tree = new VComp(HAlignment.CENTER, wholetree);
      return tree;
    }

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Circle test = new Circle('C', 3);
    AsciiBlock.print(pen, new Surrounded(test, 'x'));

    //Make the grass and sky
    AsciiBlock sky = new Rect(' ', 80, 5); 
    AsciiBlock grass = new Rect('^', 80, 1);

    //Make the trees in line
    AsciiBlock trees = new Rect(' ', 5, 5);;
    AsciiBlock forest[] = new AsciiBlock[11];
    for (int n = 0; n < 11; n++)
    {
      if ( n % 2 != 0)
       {
        forest[n] = new Rect(' ', 5, 5);
       }
      else 
       {
        int treesize = (int) (Math.random() *10 + 1);
        int trunkwidth = (int) (Math.random() *10 + 1);
        if (trunkwidth > treesize)
        { 
          int hold = treesize;
          treesize = trunkwidth;
          trunkwidth = hold;
        } 
        int trunkheight = (int) (Math.random() *10 + 1);

        forest[n] = tree(treesize,trunkwidth, trunkheight);
      
       }                
       AsciiBlock hold = trees;
       trees = new HComp(VAlignment.BOTTOM,hold, forest[n]);
    }

    //Final Forest Picture
    AsciiBlock.print(pen, sky);
    AsciiBlock.print(pen, trees);
    AsciiBlock.print(pen, grass);
    
    pen.close();
  } // main(String[])
 
  
 }// class  Art80x24
