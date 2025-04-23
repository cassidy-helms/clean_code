package com.clean_code.args.refactor_4.marshaler;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.clean_code.args.refactor_4.exception.ArgsException;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue = "";

    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch(NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_STRING);
        }
    }

    public Object get() {
        return stringValue;
    }
}