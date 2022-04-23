package com.aussiedev81.api;

import java.io.File;
import java.nio.file.Path;

public interface QREngine {

    File createQrCode(Object data);
    Object readQrCodeByPath(Path path);
    Object readQrCodeByFile(File file);

    String getWorkingDirectory();

    void setWorkingDirectory(String path);
}
