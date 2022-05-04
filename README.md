
[![License](https://img.shields.io/github/license/AussieDev81/qr-code-engine)](https://github.com/AussieDev81/qr-code-engine)
# QR Code Engine
___

## Add instant QR code functionality to your Java project.
At this stage there is only 3 functions this library performs, which are:
1. createQrCode
2. readQrCodeByPath
3. readQrCodeByFile
4. getWorkingDirectory
5. setWorkingDirectory

The first method is self-explanatory, it takes whatever object you pass to it and creates a QR code version of it for you. 
By default, the working directory is set to the system's user hom directory (E.g `C:\Users\nate`), but you can change this default directory by setting the following:
```
var engine = QREngineFactory.getInstance();
engine.setWorkingDirectory("my-new-directory");
```
## A simple demonstration
Here we just use a simple string message, but our input could be just about anything you want.

We then use the singleton [QREngineFactory](src/main/java/com/aussiedev81/api/QREngineFactory.java) class to get an instance of the [QREngineImpl](src/main/java/com/aussiedev81/api/QREngineImpl.java) class which implements the [QREngine](src/main/java/com/aussiedev81/api/QREngine.java) interface.
We can then call the available methods.

Firstly we create the QR code with our chosen input (message) and reference that in our "qrFile" variable.
Then we demonstrate both methods of reading the QR code file by file and path, and print the results.

Here, for simplicity, we have cast the type as 'String' because we know that is the type of our object, however this would be different depending on the object you pass to the QR code.
```java
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
```

The output for this is
```ps
Turn this message into a QR code
True
```
If you run this code you will find the QR code image file saves to your user home directory (for example `C:\Users\nate`).

The file should contain a QR code like the following, and if you scan it with your QR code scanner you will see it just contains some simple text which reads `Turn this message into a QR code` just as we declared above in our `message` variable.

![img.png](QRCodeImage.png)

If I have missed some details here (and I surely will), you can try reading the documentation by hovering (sometimes ctrl+ hover) over the class or method names.

Failing that, shoot me an email at [aussiedev81@gmail.com](mailto:aussiedev81@gmail.com?subject=QR%20Code%20Engine "Email me") 
