package com.monotonic.testing.m4;

import static java.lang.Math.min;

public class WordWrap {
    public static String wrap(final String inputLine, final int lineLength) {
        final StringBuilder accumulator = new StringBuilder();
        final int length = inputLine.length();

        accumulator.append(inputLine, 0, min(length, lineLength));

        if (length > lineLength) {
            accumulator.append('\n');
            accumulator.append(inputLine, lineLength, length);
        }

        return accumulator.toString();
    }
}
