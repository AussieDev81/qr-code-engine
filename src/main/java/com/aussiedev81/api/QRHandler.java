package com.aussiedev81.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.aussiedev81.model.QRCode;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QRHandler {

    public File getImageFile(QRCode qrCode) throws WriterException, IOException {

        var bitMatrix = getBitMatrix(qrCode);
        var codePath = getCodePath(qrCode);

        MatrixToImageWriter.writeToPath(
                bitMatrix,
                qrCode.getFORMAT(),
                Paths.get(codePath));

        return new File(qrCode.getCodePath());
    }

    public String readImageFile(String path) throws IOException, NotFoundException {
        return new MultiFormatReader().decode(getBitMap(path)).getText();
    }

    private BitMatrix getBitMatrix(QRCode qr) throws WriterException {
        return new MultiFormatWriter().encode(
                new String(
                        qr.getDATA().toString().getBytes(qr.getCHARSET()),
                        qr.getCHARSET()),
                BarcodeFormat.QR_CODE, qr.getSIZE(), qr.getSIZE(), qr.getMAP());
    }

    private String getCodePath(QRCode qr) {
        qr.setCodePath(qr.getENGINE().getWorkingDirectory().concat(File.separator).concat(
                String.format("%s%s.%s", qr.getPREFIX(), System.currentTimeMillis(), qr.getFORMAT())));
        return qr.getCodePath();
    }

    private BinaryBitmap getBitMap(String path) throws FileNotFoundException, IOException{
        return new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(
                ImageIO.read(new FileInputStream(path)))));
    }

}
