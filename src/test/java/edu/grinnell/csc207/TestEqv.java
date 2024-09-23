package edu.grinnell.csc207;


import edu.grinnell.csc207.blocks.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TestEqv {
    @Test
    public void testAsciiEqv() throws Exception { 
        AsciiBlock line = new Line("HI");
        AsciiBlock line1 = new Line("HI");

        assertEquals(true, AsciiBlock.eqv(line, line1));
    }

    @Test
    public void testPadded() throws Exception { 
        AsciiBlock rect = new Rect('x', 2, 3);
        AsciiBlock boxed = new Boxed(rect);
        AsciiBlock padded = new Padded(boxed, '*', HAlignment.CENTER, VAlignment.TOP, 4, 5);
        AsciiBlock padded1 = new Padded(boxed, '*', HAlignment.CENTER, VAlignment.TOP, 4, 5);
        AsciiBlock padded2 = new Padded(boxed, '*', HAlignment.CENTER, VAlignment.BOTTOM, 4, 5);
        AsciiBlock boxed1 = new Boxed(rect);
        AsciiBlock padded3 = new Padded(boxed1, '*', HAlignment.CENTER, VAlignment.BOTTOM, 4, 5);

        assertEquals(true, padded.eqv(padded1));
        assertEquals(false, padded1.eqv(padded2));
        assertEquals(true, padded2.eqv(padded3));
    }

    @Test
    public void testLine() throws Exception { 
        AsciiBlock line = new Line("HI");
        AsciiBlock line1 = new Line("HI");

        assertEquals(true, line.eqv(line1));
    }

    @Test
    public void testBoxed() throws Exception { 
        AsciiBlock line = new Line("HI");
        AsciiBlock line1 = new Line("HI");
        AsciiBlock box = new Boxed(line);
        AsciiBlock box1 = new Boxed(line);

        assertEquals(true, box.eqv(box1));
    }

    @Test
    public void testHComp() throws Exception { 
        AsciiBlock[] li = {
            new Rect('x', 2, 3),
            new Rect('x', 5, 3),
            new Rect('x', 7, 2)
        };
        AsciiBlock hcomp = new HComp(VAlignment.CENTER, li);
        AsciiBlock hcomp1 = new HComp(VAlignment.CENTER, li);

        assertEquals(true, hcomp.eqv(hcomp1));
    }
}
