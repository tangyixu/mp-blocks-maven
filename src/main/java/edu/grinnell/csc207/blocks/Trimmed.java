package edu.grinnell.csc207.blocks;

/**
 * A trimmed ASCII block.
 *
 * @author Samuel A. Rebelsky
 * @author Nicole
 * @author Tiffany
 * @author Harrison
 */
public class Trimmed implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /** The original block. */
  AsciiBlock block;

  /** Which part of the block do we keep horizontally? */
  HAlignment halign;

  /** Which part of the block do we keep vertically? */
  VAlignment valign;

  /** How much of the block do we keep horizontally? */
  int width;

  /** How much of the block do we keep vertically? */
  int height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param original The original block.
   * @param horiz How the trimmed block is horizontally aligned on the original.
   * @param vert How the trimmed block is vertically aligned on the original.
   * @param trimmedWidth The width of the trimmed block.
   * @param trimmedHeight The height of the trimmed block.
   */
  public Trimmed(
      AsciiBlock original, HAlignment horiz, VAlignment vert, int trimmedWidth, int trimmedHeight) {
    this.block = original;
    this.halign = horiz;
    this.valign = vert;
    this.width = trimmedWidth;
    this.height = trimmedHeight;
  } // Trimmed(AsciiBlock, HAlignment, VAlignment, int, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   * @return row i.
   * @exception Exception If the row is invalid.
   */
  public String row(int i) throws Exception {
    if(this.height > this.block.height() || this.width > this.block.width()) {
      throw new Exception("Trim dimensions exceed those of the input block. Try again.");
    } // if

    int hOffset;
    int vOffset;

    String result = "";

    if (this.halign == HAlignment.LEFT) {
      hOffset = 0;
    } else if (this.halign == HAlignment.CENTER) {
      hOffset = (this.block.width() - 2) / 2;
    } else {
      hOffset = this.block.width() - this.width;
    } // if...else
    
    if (this.valign == VAlignment.TOP) {
      vOffset = 0;
    } else if (this.valign == VAlignment.CENTER) {
      vOffset = (this.block.height() - 2) / 2;
    } else {
      vOffset = this.block.height() - this.height;
    } // if...else

    result = this.block.row(vOffset + i).substring(hOffset, this.width + hOffset);

    return result;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.width;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return other instanceof Trimmed && this.eqv((Trimmed) other);
  } // eqv(AsciiBlock)

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(Trimmed other) {
    return other.width() == this.width()
        && other.height() == this.height()
        && other.halign == this.halign
        && other.valign == this.valign
        && other.block.eqv(this.block);
  } // eqv(AsciiBlock)
} // class Trimmed
