package com.aussiedev81.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.aussiedev81.model.QRCode;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import org.junit.Test;

public class QRHandlerTest {
    @Test
    public void testGetImageFile() throws WriterException, IOException {
        var data = "Some test data";
        var imgFile = new QRHandler().getImageFile(new QRCode(data));
        assertNotNull(imgFile);
        Files.deleteIfExists(Path.of(imgFile.getPath()));
    }

    @Test
    public void testReadImageFile() throws NotFoundException, IOException {
        var response = new QRHandler().readImageFile("TEST_QR.png");
        assertEquals("Some test data", response);
    }
}
