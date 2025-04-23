package com.clean_code.junit.original;

public class Assert {
    public static String format(String message, String expected, String actual) {
        StringBuilder sb = new StringBuilder();

        if(message != null) {
            sb.append(message + " ");
        }

        sb.append("expected:<" + expected + "> but was:<" + actual + ">");

        return sb.toString();
    }
}
