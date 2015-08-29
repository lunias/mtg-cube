package com.ethanaa.mtg.cube;


public class CopyException extends Exception {

    public <T, O> CopyException(Class<T> copyTargetClazz, O copyTarget, Throwable cause) {

        super("Could not copy (" + copyTargetClazz.getSimpleName() + "): " + copyTarget, cause);
    }
}
