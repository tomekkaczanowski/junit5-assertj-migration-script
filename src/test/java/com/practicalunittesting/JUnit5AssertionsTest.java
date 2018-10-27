package com.practicalunittesting.appendix_assertions.migration;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

public class JUnit5AssertionsTest {

    @Test
    public void basicEquals() {
        assertEquals("x", "x");
        assertEquals("x", "x", "equal expected");
        assertNotEquals("x", "y");
        assertNotEquals("x", "y", "not equal expected");
    }

    @Test
    public void nullNotNull() {
        assertNull(null);
        assertNull(null, "null expected");

        MyClass completelyNull = null;
        assertNull(completelyNull);
        assertNull(completelyNull, "null variable expected");

        assertNotNull("a");
        assertNotNull("a", "not null string expected");

        String notNull = "a";
        assertNotNull(notNull);
        assertNotNull(notNull, "not null variable expected");
    }

    @Test
    public void trueFalse() {
        assertTrue(true);
        assertTrue(true , "true expected");
        assertFalse(false);
        assertFalse(false, "false expected");
    }

    @Test
    public void same() {
        MyClass myObject = new MyClass();
        MyClass otherObject = new MyClass();

        assertSame(myObject, myObject);
        assertSame(myObject, myObject, "same expected");
        assertNotSame(myObject, otherObject);
        assertNotSame(myObject, otherObject, "different expected");
    }

    @Test
    public void delta() {
        assertEquals(0.123, 0.123);
        assertEquals(0.123, 0.123, "no delta");

        assertEquals(0.123, 0.124, 0.002);
        assertEquals(0.123, 0.124, 0.002, "delta used");
    }

    @Test
    public void collections() {
        int[] intarray = new int[]{3, 4};
        assertArrayEquals(intarray, intarray);
        assertArrayEquals(intarray, intarray, "arrays should be equal");
        assertEquals(0, new ArrayList<>().size());
        assertEquals(0, new ArrayList<>().size(), "zero size");
        assertEquals(1, Arrays.asList("abc").size());
        assertEquals(1, Arrays.asList("abc").size(), "one size");
    }

    @Test
    void fails() {
        fail();
        fail("ouch!");
        fail("ouch!", new Throwable());
        fail(new Throwable());
    }

    @Test
    public void collectionsZonk() {
        int[] intarray = new int[]{3, 4};
        assertArrayEquals(intarray, new int[] {3, 4});
        assertArrayEquals(intarray, new int[] {3, 4}, "arrays should be equal");
        assertArrayEquals(new int[] {3, 4}, new int[] {3, 4});
        assertArrayEquals(new int[] {3, 4}, new int[] {3, 4}, "arrays should be equal");
    }

    @Test
    public void lines() {
        assertLinesMatch(Arrays.asList("aaa", "bbb"), Arrays.asList("aaa", "bbb"));
    }

    @Test
    public void exceptions() {
        String emptyString = null;
        assertThrows(NullPointerException.class, () -> {
            emptyString.length();
        });

        assertDoesNotThrow(() -> new String());
    }

    @Test
    public void all() {
        assertAll("all or nothing",
                () -> assertSame("a", "a"),
                () -> assertEquals(1, 1)
        );
    }

    @Test
    public void timeout() {
        assertTimeout(Duration.ofMillis(10), () -> new String());
    }

    private class MyClass { }
}