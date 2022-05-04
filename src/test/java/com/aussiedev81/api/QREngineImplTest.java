package com.aussiedev81.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.aussiedev81.model.QRCode;

import org.junit.Test;

public class QREngineImplTest {

    @Test
    public void testCreateQrCode() {
        var qr = new QRCode();
        assertNotNull(qr);
    }

    @Test
    public void testGetWorkingDirectory() {
        var workingDirectory = new QREngineImpl().getWorkingDirectory();
        assertEquals(System.getProperty("user.home"), workingDirectory);
    }

    @Test
    public void testSetWorkingDirectory() {
        var userHome = System.getProperty("user.home");
        
        var newDirectory = "tests/test-directory";
        new QREngineImpl().setWorkingDirectory(newDirectory);
        assertEquals(newDirectory, new QREngineImpl().getWorkingDirectory());
        //Set it back
        new QREngineImpl().setWorkingDirectory(userHome);
    }
}
