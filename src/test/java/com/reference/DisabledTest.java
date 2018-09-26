package com.reference;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@Disabled
public class DisabledTest {

    @Test
    void testOne() {
        fail("This will never come to light since the whole test is disabled");
    }

    @Test
    void testTwo() {
        fail("This will never come to light since the whole test is disabled");
    }
}
