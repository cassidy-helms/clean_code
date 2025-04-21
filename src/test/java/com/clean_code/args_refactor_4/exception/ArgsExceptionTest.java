package com.clean_code.args_refactor_4.exception;

import junit.framework.TestCase;

public class ArgsExceptionTest extends TestCase {
    public void testUnexpectedMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT, 'x', null);
        assertEquals("Argument -x unexpected.", e.errorMessage());
    }

    public void testInvalidArgumentMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_ARGUMENT_NAME, '#', null);
        assertEquals("Argument expects a string but was '#'", e.errorMessage());
    }

    public void testInvalidFormatMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_FORMAT, 'f', null);
        assertEquals("Invalid format for 'f'", e.errorMessage());
    }


    public void testMissingStringMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_STRING, 'x', null);
        assertEquals("Could not find string parameter for -x.", e.errorMessage());
    }

    public void testMissingStringArrayMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_ARRAY, 'x', null);
        assertEquals("Could not find string array parameter for -x.", e.errorMessage());
    }

    public void testInvalidIntegerMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER, 'x', "forty two");
        assertEquals("Argument -x expects an integer but was 'forty two'.", e.errorMessage());
    }

    public void testMissingIntegerMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER, 'x', null);
        assertEquals("Could not find integer parameter for -x.", e.errorMessage());
    }

    public void testInvalidDoubleMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE, 'x', "forty two");
        assertEquals("Argument -x expects a double but was 'forty two'.", e.errorMessage());
    }

    public void testMissingDoubleMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE, 'x', null);
        assertEquals("Could not find double parameter for -x.", e.errorMessage());
    }
}
