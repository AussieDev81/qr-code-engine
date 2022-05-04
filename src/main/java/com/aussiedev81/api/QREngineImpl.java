package com.aussiedev81.api;

import com.aussiedev81.model.QRCode;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

class QREngineImpl implements QREngine {

    public static String OUTPUT_DIR = System.getProperty("user.home");
    private static QRHandler handler;

    public QREngineImpl() {
        handler = new QRHandler();
    }

    @Override
    public File createQrCode(Object data) {
        try {
            return handler.getImageFile(new QRCode(data));
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object readQrCodeByPath(Path path) {
        try{
            File file = new File(path.toString());
            return readQrCodeByFile(file);
        } catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public Object readQrCodeByFile(File file) {
        try{
            return handler.readImageFile(file.getPath());
        } catch (NotFoundException | IOException e){
            return e.getMessage();
        }
    }

    @Override
    public String getWorkingDirectory() {
        return OUTPUT_DIR;
    }

    @Override
    public void setWorkingDirectory(String path){
        OUTPUT_DIR = path;
    }
}
