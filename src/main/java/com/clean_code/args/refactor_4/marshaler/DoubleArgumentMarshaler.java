package com.clean_code.args.refactor_4.marshaler;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.clean_code.args.refactor_4.exception.ArgsException;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {
    private double doubleValue = 0;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;

        try {
            parameter = currentArgument.next();
            doubleValue = Double.parseDouble(parameter);
        } catch(NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE);
        } catch(NumberFormatException e) {
            throw new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE, parameter);
        }
    }

    public Object get() {
        return doubleValue;
    }
}