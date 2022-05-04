package com.aussiedev81.model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.aussiedev81.api.QREngine;
import com.aussiedev81.api.QREngineFactory;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {

    private final int SIZE;
    private final int MIN_SIZE = 200;
    private final Object DATA;
    private final String PREFIX = "QR";
    private final String FORMAT = "png";
    private final Charset CHARSET = StandardCharsets.UTF_8;
    private final Map<EncodeHintType,Object> MAP;
    private String codePath;
    private final QREngine ENGINE = QREngineFactory.getInstance();

    public QRCode(Object data) {
        DATA = data;
        SIZE = Math.max(data.toString().length() / 2, MIN_SIZE);
        MAP = new HashMap<>(Map.of(
                EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L,
                EncodeHintType.CHARACTER_SET, CHARSET
        ));
    }

    public QRCode(){
        DATA = null;
        SIZE = MIN_SIZE;
        MAP = new HashMap<>(Map.of(
                EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L,
                EncodeHintType.CHARACTER_SET, CHARSET
        ));
    }

    public String getCodePath() {
        return this.codePath;
    }
    
    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }
    public Object getDATA() {
        return DATA;
    }
    public Charset getCHARSET() {
        return CHARSET;
    }
    public int getSIZE() {
        return SIZE;
    }
    public Map<EncodeHintType, Object> getMAP() {
        return MAP;
    }
    public String getPREFIX() {
        return PREFIX;
    }
    public String getFORMAT() {
        return FORMAT;
    }
    public QREngine getENGINE() {
        return ENGINE;
    }
    
}
