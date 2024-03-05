package other_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataTypesTest {
    byte aByte = Byte.MAX_VALUE;
    char aChar = 'a';
    short aShort = Short.MIN_VALUE;
    int anInt = 127;
    long aLong = Long.MAX_VALUE;
    float aFloat = 0.0f;
    float infinity = 100 / 0.0f;
    double aDouble = 0.0;
    boolean aBoolean = true;

    @Test
    void dataTypesOperations() {
        assertEquals(Float.NaN, aFloat / aDouble);
        assertEquals("Infinity", String.valueOf(infinity));
        assertEquals(0, (int) (aLong + 1));
        assertTrue(aChar + 'b' == 195 && aChar + 98 == 195);
        assertTrue(aByte == anInt);
        assertEquals(aBoolean, anInt < aLong);
        assertEquals(aShort, (short) (aChar = (Character.MAX_VALUE + 1) / 2));
        assertEquals(1, anInt % 3);
    }
}