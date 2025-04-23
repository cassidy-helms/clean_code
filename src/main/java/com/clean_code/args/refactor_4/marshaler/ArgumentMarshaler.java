package com.clean_code.args.refactor_4.marshaler;

import java.util.Iterator;

import com.clean_code.args.refactor_4.exception.ArgsException;

public interface ArgumentMarshaler {
    public abstract void set(Iterator<String> currentArgument) throws ArgsException;

    public abstract Object get();
}
