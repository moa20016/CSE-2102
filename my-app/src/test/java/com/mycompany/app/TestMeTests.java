package com.mycompany.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMeTests {

        TestMe testMe;

        @Before
        public void setUp() throws Exception {
            testMe  = new TestMe();
        }

        @Test
        public void testAddition() {
                testMe.setValue(2);
                assertEquals(4, testMe.addition(), 0.0001);
        }
        @Test
        public void testSubtraction() {
                testMe.setValue(2);
                assertEquals(0, testMe.subtraction(), 0.0001);
        }
        @Test
        public void testMultBy2() {
                testMe.setValue(4);
                assertEquals(8, testMe.multBy2(), 0.0001);
        }
}

