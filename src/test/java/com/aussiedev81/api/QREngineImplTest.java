package com.aussiedev81.api;

import com.aussiedev81.model.QRCode;
import com.google.zxing.NotFoundException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class QREngineImplTest {
    @Test
    public void testCreateQrCode() {
        QREngineImpl impl = new QREngineImpl();
        assertEquals( File.class, impl.createQrCode("TEST").getClass());
    }

    @Test
    public void testCreateQrCodeFile() {
        var impl = new QREngineImpl();
        assertEquals( File.class, impl.createQrCode("TEST").getClass());
    }

    @Test
    public void testReadQrCodeFile() throws NotFoundException, IOException {
        var code = new QRCode();
        var path = "TEST_QR.png";
        new QREngineImpl().readQrCodeByPath(Path.of(path));
        assertEquals("Some test data", code.readImageFile(path));
    }
}
