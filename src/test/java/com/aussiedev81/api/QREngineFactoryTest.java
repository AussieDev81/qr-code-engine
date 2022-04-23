package com.aussiedev81.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class QREngineFactoryTest {

    @Test
    public void testGetInstance() {
        QREngine codeEngine = QREngineFactory.getInstance();
        assertNotNull(codeEngine);
        assertEquals(QREngineImpl.class, codeEngine.getClass());
    }

    @Test
    public void testSingleton(){
        var originalInstance = QREngineFactory.getInstance();
        assertSame(originalInstance, QREngineFactory.getInstance());
    }
}