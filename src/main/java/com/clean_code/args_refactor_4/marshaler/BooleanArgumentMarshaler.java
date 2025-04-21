package com.clean_code.args_refactor_4.marshaler;

import java.util.Iterator;

import com.clean_code.args_refactor_4.exception.ArgsException;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {       
    private boolean booleanValue = false;

    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }

    public Object get() {
        return booleanValue;
    }
}
