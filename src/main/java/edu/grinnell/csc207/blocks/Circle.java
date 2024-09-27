package edu.grinnell.csc207.blocks;

/**
 * A Filled Circle.
 *
 * @author Harrison Zhu
 * @author Nicole Gorrell
 * @author Tiffany Tang
 */
public class Circle implements AsciiBlock {

  /** Character that the circle is filled with. */
  String unitchar;

  /** Diameter of the circle. */
  int diameter;

  /**
   * Constructs a circle.
   *
   * @param fillChar The character to fill the circle with
   * @param circleDiameter The diameter of circle
   */
  public Circle(char fillChar, int circleDiameter) {
    this.unitchar = Character.toString(fillChar);
    this.diameter = circleDiameter;
  } // Circle(char, int)

  /**
   * Constructs a circle. Sets fillChar to ' '.
   *
   * @param circleDiameter The diameter of circle
   */
  public Circle(int circleDiameter) {
    this(' ', circleDiameter);
  } // Circle(int)

  // Methods
  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   * @return row i.
   * @exception Exception if i is outside the range of valid rows.
   */
  public String row(int i) {
    String result = "";
    double center = (diameter - 1) / 2.0;
    for (double x = 0; x < diameter; x++) {
      if (Math.pow((center - x), 2) + Math.pow((i - center), 2) <= Math.pow(diameter / 2.0, 2)) {
        result += unitchar;
      } else {
        result += " ";
      } // if point is in range
    } // for
    return result;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.diameter;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.diameter;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return other instanceof Circle
        && other.width() == this.width()
        && other.height() == this.height()
        && ((Circle)other).unitchar.equals(this.unitchar);
  } // eqv(AsciiBlock)
} // Circle
