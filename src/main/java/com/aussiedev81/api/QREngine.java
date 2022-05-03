package com.aussiedev81.api;

import java.io.File;
import java.nio.file.Path;

public interface QREngine {

    /**
     * Create a QR Code file containing whatever object you pass in.
     * The size of the generated QR code will be determined by the volume of data it needs to store.
     * @param data Whatever object you pass to it
     * @return A {@link File} containing your QR code
     */
    File createQrCode(Object data);

    /**
     * Reads a pre-existing QR code file by filepath
     * @param path The path to your local file that is to be read
     * @return A generic {@link Object} containing the QR code's contents. Note that it is up to you to 
     * check and cast/parse the returned object into a usable item.
     */
    Object readQrCodeByPath(Path path);

    /**
     * Reads a pre-existing QR code file
     * @param file The file containing the QR code image
     * @return A generic {@link Object} containing the QR code's contents. Note that it is up to you to
     * check and cast/parse the returned object into a usable item.
     */
    Object readQrCodeByFile(File file);

    /**
     * Get's the destination directory (where QR codes will be saved). By default
     * this is set to your <code>user.home</code> directory (for example <code>C:\Users\nate\ </code>)
     * @return A {@link String} value of the destination file path.
     */
    String getWorkingDirectory();

    /**
     * Set the working directory to another directory to override the default
     * setting <code>user.home</code>.
     * For example you might set the default storage location to something like
     * <code> D:\Assets\QRCodes </code>
     * @param path The desired destination filepath represented by a {@link String} value.
     */
    void setWorkingDirectory(String path);
}
