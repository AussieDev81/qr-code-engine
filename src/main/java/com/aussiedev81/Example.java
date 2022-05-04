package com.aussiedev81;

import com.aussiedev81.api.QREngineFactory;

public class Example {

    public static void main(String[] args){

        //A demo message as an example
        var message = "Turn this message into a QR code";

        //Get an instance of the QREngine (QREngineImpl.java)
        var engine = QREngineFactory.getInstance();

        //The QR code file generated containing our message (this could be any object you choose)
        var qrFile = engine.createQrCode(message);

        //We know both objects are Strings
        var byFile = (String) engine.readQrCodeByFile(qrFile);
        var byPath = (String) engine.readQrCodeByPath(qrFile.toPath());

        //Read the contents of the QR code file
        System.out.println(engine.readQrCodeByFile(qrFile));
        //Both options return the same object
        System.out.println(byFile.equals(byPath));

    }
}
