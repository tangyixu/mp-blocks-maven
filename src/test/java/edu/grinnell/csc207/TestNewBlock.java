package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.grinnell.csc207.blocks.*;
import org.junit.jupiter.api.Test;

/** Tests of the new block. */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /** 
   * Basic tests for circle. Test eqv between different objects.
   * Test if circle has been constructed correctly.
   */
  @Test
  public void testCircle() {
    Circle test1 = new Circle(5);
    Circle test2 = new Circle('C', 3);
    Circle test3 = new Circle('C', 3);
    Circle test4 = new Circle('X', 3);
    Empty empt = new Empty();
    Padded pad = new Padded(test4, ' ', HAlignment.LEFT, VAlignment.TOP, test4.width(), test4.height());
    assertEquals(5, test1.height());
    assertEquals(3, test2.height());
    assertEquals("CCC", test2.row(0));
    assertTrue(test2.eqv(test3));
    assertFalse(test1.eqv(test3));
    assertFalse(test3.eqv(test4));
    assertFalse(test3.eqv(empt));
    assertFalse(test4.eqv(pad));
  } // testCircle()

  /**
   * Test for constructing a circle with diameter 0.
   */
  @Test
  public void testEmptyCircle() { 
    Circle empty = new Circle('x', 0);
    assertEquals("", empty.row(0));
  } // testEmptyCircle()

  /**
   * Test if Grid, Boxed, and other wrappers work on an empty circle
   */
  @Test
  public void testWrappedEmptyCircle() { 
    Circle emptyCircle = new Circle('x', 0);
    Boxed box = new Boxed(emptyCircle);
    Grid grid = new Grid(emptyCircle, 3, 3);
    Surrounded surrounded = new Surrounded(emptyCircle, '.');

    assertEquals(
      """
      /\\
      \\/
      """,
      TestUtils.toString(box));

    assertEquals(
      """
      """,
      TestUtils.toString(grid));

    assertEquals(
      """
      ..
      ..
      """,
      TestUtils.toString(surrounded));
  } // testWrappedEmptyCircle()

  /**
   * Test if the circle works in wrappers
   */
  @Test
  public void testWrapperCircle() { 
    Circle circle = new Circle('C', 5);
    assertEquals(
      " CCC \nCCCCC\nCCCCC\nCCCCC\n CCC \n",
      TestUtils.toString(circle));
    
    Boxed box = new Boxed(circle); 
    assertEquals(
      """
    /-----\\
    | CCC |
    |CCCCC|
    |CCCCC|
    |CCCCC|
    | CCC |
    \\-----/
      """,
      TestUtils.toString(box));

    Surrounded surrounded = new Surrounded(circle, 'a'); 
    assertEquals(
      """
    aaaaaaa
    a CCC a
    aCCCCCa
    aCCCCCa
    aCCCCCa
    a CCC a
    aaaaaaa
      """,
      TestUtils.toString(surrounded));
  } // testWrapperCircle()
} // class TestNewBlock
