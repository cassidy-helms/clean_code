package com.clean_code.junit.refactor_2;

/*
 * This is not my code.  I am doing a slow walkthough of the jUnit Framework Refactor in Chapter 15 of Robert C. Martin's Clean Code
 */
public class ComparisonCompactor {
    private static final String ELLIPSIS = "...";
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";

    private int contextLength;
    private String expected;
    private String actual;
    private int prefixLength;
    private int suffixLength;

    public ComparisonCompactor(int contextLength, String expected, String actual) {
        this.contextLength = contextLength;
        this.expected = expected;
        this.actual = actual;
    }

    public String formatCompactedComparison(String message) {
        String compactExpected = expected;
        String compactActual = actual;
        if(shouldBeCompacted()) {
            findCommonPrefixAndSuffix();
            compactExpected = compact(expected);
            compactActual = compact(actual);            
        }

        return Assert.format(message, compactExpected, compactActual);
    }

    private boolean shouldBeCompacted() {
        return !shouldNotBeCompacted();
    }

    private boolean shouldNotBeCompacted() {
        return expected == null || actual == null || areStringsEqual();

    }

    private String compact(String source) {
        return new StringBuilder()
            .append(startingEllipses())
            .append(startingContext())
            .append(DELTA_START)
            .append(delta(source))
            .append(DELTA_END)
            .append(endingContext())
            .append(endingEllipsis())
            .toString();
    }

    private void findCommonPrefixAndSuffix() {
        findCommonPrefix();
        suffixLength = 0;
        
        for(; !suffixOverlapsPrefix(suffixLength); suffixLength++) {
            if(charFromEnd(expected, suffixLength) != charFromEnd(actual, suffixLength))
                break;
        }
    }

    private void findCommonPrefix() {
        prefixLength = 0;
        int end = Math.min(expected.length(), actual.length());
        for(; prefixLength < end; prefixLength++) {
            if(expected.charAt(prefixLength) != actual.charAt(prefixLength))
                break;
        }
    }

    private char charFromEnd(String s, int i) {
        return s.charAt(s.length() - i - 1);
    }

    private boolean suffixOverlapsPrefix(int suffixLength) {
        return actual.length() - suffixLength <= prefixLength
            || expected.length() - suffixLength <= prefixLength;
    }

    private String startingEllipses() {
        return prefixLength > contextLength ? ELLIPSIS : "";
    }

    private String startingContext() {
        int contextStart = Math.max(0, prefixLength - contextLength);
        int contextEnd = prefixLength;
        return expected.substring(contextStart, contextEnd);
    }

    private String endingContext() {
        int contextStart = expected.length() - suffixLength;
        int contextEnd = Math.min(contextStart + contextLength, expected.length());
        return expected.substring(contextStart, contextEnd);
    }

    private String endingEllipsis() {
        return suffixLength > contextLength ? ELLIPSIS : "";
    }

    private String delta(String s) {
        int deltaStart = prefixLength;
        int deltaEnd = s.length() - suffixLength;
        return s.substring(deltaStart, deltaEnd);
    }

    private boolean areStringsEqual() {
        return expected.equals(actual);
    }
}
