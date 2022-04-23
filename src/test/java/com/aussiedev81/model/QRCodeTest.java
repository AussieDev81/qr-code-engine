package com.aussiedev81.model;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class QRCodeTest extends TestCase {

    public void testGetImageFile() throws IOException, WriterException {
        var data = "Some test data";
        var code = new QRCode(data);
        assertEquals(File.class, code.getImageFile().getClass());
        Files.deleteIfExists(Path.of(code.getCodePath()));
    }

    public void testReadImageFile() throws IOException, NotFoundException {
        var code = new QRCode();
        var response = code.readImageFile("TEST_QR.png");
        assertEquals("Some test data", response);
    }
}