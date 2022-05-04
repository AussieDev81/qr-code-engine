package com.aussiedev81.api;

/**
 * A factory (enabler) to manage and distribute a single static instance of the
 * {@link QREngineImpl} class for implementing {@link QREngine} methods
 */
public final class QREngineFactory {

    private static QREngineImpl impl = null;

    /**
     * PRIVATE constructor to prevent external instantiation.
     * Instantiates the {@link QREngineImpl} class only in the event that
     * {@link #impl} in null, otherwise it will return the current {@link #impl}.
     */
    private QREngineFactory() {
        impl = new QREngineImpl();
    }

    /**
     * Get instance
     * @return An instance of the singleton {@link QREngineImpl} class
     */
    public static QREngine getInstance(){
        if(impl == null)
            impl = new QREngineImpl();
        return impl;
    }
}
