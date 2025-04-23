package com.clean_code.args.refactor_4.marshaler;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.clean_code.args.refactor_4.exception.ArgsException;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
    String[] stringArrayValue = new String[]{};

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringArrayValue = currentArgument.next().split(",");
        } catch(NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_ARRAY);
        }
    }

    @Override
    public Object get() {
        return stringArrayValue;
    }
    
}
