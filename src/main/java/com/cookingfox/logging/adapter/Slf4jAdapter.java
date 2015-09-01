package com.cookingfox.logging.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Log adapter implementation using SLF4J library.
 */
public class Slf4jAdapter implements Adapter {

    //----------------------------------------------------------------------------------------------
    // PRIVATE PROPERTIES
    //----------------------------------------------------------------------------------------------

    /**
     * Collection of loggers, where the key is the caller class name.
     */
    private final Map<String, Logger> loggers = new LinkedHashMap<>();

    //----------------------------------------------------------------------------------------------
    // PUBLIC METHODS
    //----------------------------------------------------------------------------------------------

    @Override
    public void debug(String caller, String message) {
        getLogger(caller).debug(message);
    }

    @Override
    public void error(String caller, String message) {
        getLogger(caller).error(message);
    }

    @Override
    public void info(String caller, String message) {
        getLogger(caller).info(message);
    }

    @Override
    public void verbose(String caller, String message) {
        getLogger(caller).trace(message);
    }

    @Override
    public void warn(String caller, String message) {
        getLogger(caller).warn(message);
    }

    //----------------------------------------------------------------------------------------------
    // PRIVATE METHODS
    //----------------------------------------------------------------------------------------------

    /**
     * Creates and / or returns an SLF4J Logger instance for the calling class.
     *
     * @param caller The name of calling class.
     * @return SLF4J Logger instance.
     */
    private Logger getLogger(String caller) {
        Logger logger = loggers.get(caller);

        if (null == logger) {
            logger = LoggerFactory.getLogger(caller);
            loggers.put(caller, logger);
        }

        return logger;
    }

}
