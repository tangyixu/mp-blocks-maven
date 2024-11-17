package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.grinnell.csc207.blocks.*;
import org.junit.jupiter.api.Test;
import java.util.Random;

/** Tests of the new block. */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /** Testing circles of normal int value as diameters */
  @Test
  public void testCircle() {
    Circle test1 = new Circle(5);
    Circle test2 = new Circle('C', 8);
    Circle test3 = new Circle('C', 8);
    Circle test4 = new Circle('X', 8);
    Empty empt = new Empty();
    Padded pad = new Padded(test4, ' ', HAlignment.LEFT, VAlignment.TOP, test4.width(), test4.height());
    assertEquals(5, test1.height());
    assertEquals(8, test2.height());
    assertEquals("CCCCCCCC", test2.row(4));
    assertTrue(test2.eqv(test3));
    assertFalse(test1.eqv(test3));
    assertFalse(test3.eqv(test4));
    assertFalse(test3.eqv(empt));
    assertFalse(test4.eqv(pad));
  } // testCircle

  /** Testing an empty case. */
  @Test
  public void testEmpty() {
    Circle test = new Circle(' ', 5);
    
    assertEquals(5, test.height());
    assertEquals("     ", test.row(0));

    Circle test2 = new Circle(' ', 5);
    assertTrue(test.eqv(test2));

    Circle test3 = new Circle('a', 3);
    assertFalse(test3.eqv(test));
  } // testEmpty

  /** Testing circles with randomly generated diameters. */
  @Test
  public void randomTest() {
    Random rand = new Random();

    int generate1 = rand.nextInt(50);
    int generate2 = rand.nextInt(50);

    Circle t1 = new Circle(generate1);
    Circle t2 = new Circle(generate2);

    assertFalse(t2.eqv(t1));

    String r1 = t1.row(generate1 - 1);
    String r2 = t2.row(generate2 - 1);

    assertEquals(r2, t2.row(generate2 - 1));
    assertEquals(r1, t1.row(generate1 - 1));
    assertEquals(generate1, t1.height());
    assertEquals(generate2, t2.height());
  } // randomTest

  /** Testing different circles with different contents. */
  @Test
  public void testFill() {
    Circle t1 = new Circle(10);
    Circle t2 = new Circle('f', 10);
    Circle t3 = new Circle('a', 10);
    Padded pad = new Padded(t1, 'o', HAlignment.CENTER, VAlignment.CENTER, 3, 2);
  
    assertFalse(t1.eqv(pad));
    assertEquals(t2.height(), t3.height());
    assertEquals("ffffffffff", t2.row(5));
    assertEquals(" aaaaaaaa ", t3.row(1));
  } // testFill

  /** Testing building circles with small numbers */
  @Test
  public void testSmall() {
    Circle t1 = new Circle('a',1);
    Circle t2 = new Circle('b', 2);
    Circle t3 = new Circle('c', 3);
    assertFalse(t1.eqv(t2));
    assertEquals(t2.height() + 1, t3.height());
    assertEquals("a", t1.row(0));
    assertEquals("bb", t2.row(0));
  } // testSmall

  /** Testing building circles with zero */
  @Test
  public void testZero() {
    Circle t1 = new Circle('a',0);
    Circle t2 = new Circle('a',1);
    //Empty e1 = new Empty();
    assertFalse(t1.eqv(t2));
    assertEquals("",t1.row(0));
  } // testZero
} // class TestNewBlock
