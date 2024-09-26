package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import edu.grinnell.csc207.blocks.*;;

/**
 * Tests of the new block.
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A placeholder.
   */
  @Test
  public void testCircle() {
    Circle test1 = new Circle(5);
    Circle test2 = new Circle('C',3);
    Circle test3 = new Circle('C',3);
    assertEquals(5, test1.height());
    assertEquals(3,test2.height());
    assertEquals("CCC", test2.row(0));
    assertEquals(false,test2.eqv(test3));
    assertEquals(true,test2.eqv(test3));

  } // testCircle




} // class TestNewBlock
