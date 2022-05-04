package com.aussiedev81.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QRCodeTest {

    @Test
    public void createQRCode(){
        var qr = new QRCode();
        assertEquals(QRCode.class, qr.getClass());
    }
}
