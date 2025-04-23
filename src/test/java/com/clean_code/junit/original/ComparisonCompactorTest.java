package com.clean_code.junit.original;

import junit.framework.TestCase;

/*
 * This is not my code.  I am doing a slow walkthough of the jUnit Framework Refactor in Chapter 15 of Robert C. Martin's Clean Code
 */
public class ComparisonCompactorTest extends TestCase {
    public void testMessage() {
        String failure = new ComparisonCompactor(0, "b", "c").compact("a");
        assertTrue("a expected:<[b]> but was:<[c]>".equals(failure));
    }

    public void testStartSame() {
        String failure = new ComparisonCompactor(1, "ba", "bc").compact(null);
        assertTrue("expected:<b[a]> but was:<b[c]>".equals(failure));
    }

    public void testEndSame() {
        String failure = new ComparisonCompactor(1, "ab", "cb").compact(null);
        assertTrue("expected:<[a]b> but was:<[c]b>".equals(failure));
    }

    public void testSame() {
        String failure = new ComparisonCompactor(1, "ab", "ab").compact(null);
        assertTrue("expected:<ab> but was:<ab>".equals(failure));
    }

    public void testNoContextStartAndEndSame() {
        String failure = new ComparisonCompactor(0, "abc", "adc").compact(null);
        assertTrue("expected:<...[b]...> but was:<...[d]...>".equals(failure));
    }

    public void testStartAndEndContext() {
        String failure = new ComparisonCompactor(1, "abc", "adc").compact(null);
        assertTrue("expected:<a[b]c> but was:<a[d]c>".equals(failure));
    }

    public void testStartAndEndContextWithEllipses() {
        String failure = new ComparisonCompactor(1, "abcde", "abfde").compact(null);
        assertTrue("expected:<...b[c]d...> but was:<...b[f]d...>".equals(failure));
    }

    public void testComparisonErrorStartSameComplete() {
        String failure = new ComparisonCompactor(2, "ab", "abc").compact(null);
        assertTrue("expected:<ab[]> but was:<ab[c]>".equals(failure));
    }

    public void testComparisonErrorEndSameComplete() {
        String failure = new ComparisonCompactor(0, "bc", "abc").compact(null);
        assertTrue("expected:<[]...> but was:<[a]...>".equals(failure));
    }

    public void testComparisonErrorEndSameCompleteContext() {
        String failure = new ComparisonCompactor(2, "bc", "abc").compact(null);
        assertTrue("expected:<[]bc> but was:<[a]bc>".equals(failure));
    }

    public void testComparisonErrorOverlappingMatches() {
        String failure = new ComparisonCompactor(0, "abc", "abbc").compact(null);
        assertTrue("expected:<...[]...> but was:<...[b]...>".equals(failure));
    }

    public void testComparisonErrorOverlappingMatchesContext() {
        String failure = new ComparisonCompactor(2, "abc", "abbc").compact(null);
        assertTrue("expected:<ab[]c> but was:<ab[b]c>".equals(failure));
    }

    public void testComparisonOverlappingMatches2() {
        String failure = new ComparisonCompactor(0, "abcdde", "abcde").compact(null);
        assertTrue("expected:<...[d]...> but was:<...[]...>".equals(failure));
    }

    public void testComparisonOverlappingMatches2Context() {
        String failure = new ComparisonCompactor(2, "abcdde", "abcde").compact(null);
        assertTrue("expected:<...cd[d]e> but was:<...cd[]e>".equals(failure));
    }

    public void testComparisonErrorWithActualNull() {
        String failure = new ComparisonCompactor(0, "a", null).compact(null);
        assertTrue("expected:<a> but was:<null>".equals(failure));
    }

    public void testComparisonErrorWithActualNullContext() {
        String failure = new ComparisonCompactor(2, "a", null).compact(null);
        assertTrue("expected:<a> but was:<null>".equals(failure));
    }

    public void testComparisonErrorWithExpectedNull() {
        String failure = new ComparisonCompactor(0, null, "a").compact(null);
        assertTrue("expected:<null> but was:<a>".equals(failure));
    }

    public void testComparisonErrorWithExpectedNullContext() {
        String failure = new ComparisonCompactor(2, null, "a").compact(null);
        assertTrue("expected:<null> but was:<a>".equals(failure));
    }

    public void testBug609972() {
        String failure = new ComparisonCompactor(10, "S&P500", "0").compact(null);
        assertTrue("expected:<[S&P50]0> but was:<[]0>".equals(failure));
    }
}
