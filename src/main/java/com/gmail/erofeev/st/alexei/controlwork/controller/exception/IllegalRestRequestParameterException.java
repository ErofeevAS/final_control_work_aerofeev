package com.gmail.erofeev.st.alexei.controlwork.controller.exception;

public class IllegalRestRequestParameterException extends RuntimeException {
    public IllegalRestRequestParameterException(String message, NumberFormatException e) {
        super(message, e);
    }

    public IllegalRestRequestParameterException(String message) {
        super(message);
    }
}
