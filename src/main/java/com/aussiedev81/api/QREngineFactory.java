package com.aussiedev81.api;

public final class QREngineFactory {

    private static QREngineImpl impl = null;

    private QREngineFactory() {
        impl = new QREngineImpl();
    }

    public static QREngine getInstance(){
        if(impl == null)
            impl = new QREngineImpl();
        return impl;
    }
}
