package com.aussiedev81.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QREngineFactoryTest {

    @Test
    public void testGetInstance() {
        var engine1 = QREngineFactory.getInstance();
        var engine2 = QREngineFactory.getInstance();
        assertEquals(engine1, engine2);
    }
}
