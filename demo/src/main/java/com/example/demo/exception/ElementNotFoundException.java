package com.example.demo.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ElementNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementNotFoundException.class);
    public ElementNotFoundException(String message) {
        super(message);
        LOGGER.info("ElementNotFoundException:"+message);
    }
    
}

