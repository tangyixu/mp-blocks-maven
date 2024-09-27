package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Harrison Zhu, Tiffany Tang
 */
public class VComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** The blocks. */
  AsciiBlock[] blocks;

  /** How the blocks are aligned. */
  HAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment The way in which the blocks should be aligned.
   * @param topBlock The block on the top.
   * @param bottomBlock The block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock, AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
  } // VComp(HAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment The alignment of the blocks.
   * @param blocksToCompose The blocks we will be composing.
   */
  public VComp(HAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // VComp(HAlignment, AsciiBLOCK[])

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   * @return row i.
   * @exception Exception if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    int index = 0;
    int maxRow = this.blocks[index].height() - 1;
    while (i > maxRow) {
      maxRow += this.blocks[++index].height();
    } // while

    Padded helper =
        new Padded(
            this.blocks[index],
            ' ',
            this.align,
            VAlignment.TOP,
            this.width(),
            this.blocks[index].height());

    return helper.row(i - maxRow + this.blocks[index].height() - 1);
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    int result = 0;
    for (AsciiBlock element : this.blocks) {
      result += element.height();
    } // for
    return result;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int maxWidth = 0;
    for (AsciiBlock element : this.blocks) {
      if (element.width() > maxWidth) {
        maxWidth = element.width();
      } // if
    } // for
    return maxWidth;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return other instanceof VComp && this.eqv((VComp) other);
  } // eqv(AsciiBlock)

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(VComp other) {
    /*
     * Three conditions to check
     * 1. Same alignment
     * 2. Same blocks.length
     * 3. All items in blocks array eqv each other
     */
    if (!(this.align == other.align)) {
      return false;
    } // if not same alignment

    if (!(this.blocks.length == other.blocks.length)) {
      return false;
    } // if not same length

    for (int i = 0; i < this.blocks.length; ++i) {
      if (!this.blocks[i].eqv(other.blocks[i])) {
        return false;
      } // if blocks not eqv
    } // for

    return true;
  } // eqv(HComp)
} // class VComp
