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

  /** A placeholder. */
  @Test
  public void testCircle() {
    Circle test1 = new Circle(5);
    Circle test2 = new Circle('C', 3);
    Circle test3 = new Circle('C', 3);
    Circle test4 = new Circle('X', 3);
    assertEquals(5, test1.height());
    assertEquals(3, test2.height());
    assertEquals("CCC", test2.row(0));
    assertTrue(test2.eqv(test3));
    assertFalse(test1.eqv(test3));
    assertFalse(test3.eqv(test4));
  } // testCircle
} // class TestNewBlock
