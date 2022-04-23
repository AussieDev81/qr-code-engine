package com.aussiedev81.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QREngineTest {

    private final int NUM_METHODS = 5;

    @Test
    public void testMethodAvailability() {
        var engine = QREngineFactory.getInstance();
        var methods = engine.getClass().getDeclaredMethods();
        assertEquals(NUM_METHODS, methods.length);
    }

}