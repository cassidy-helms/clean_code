package com.clean_code.args.refactor_3.marshaler;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.clean_code.args.refactor_3.exception.ArgsException;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int integerValue = 0;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;

        try { 
            parameter = currentArgument.next();
            integerValue = Integer.parseInt(parameter);
        } catch(NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER);
        } catch(NumberFormatException e) {
            throw new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER, parameter);
        }
    }

    public Object get() {
        return integerValue;
    }
}
