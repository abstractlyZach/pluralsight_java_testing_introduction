package com.monotonic.testing.m4;

import static java.lang.Math.min;

public class WordWrap {
    public static String wrap(final String inputLine, final int lineLength) {
        final StringBuilder accumulator = new StringBuilder();

        accumulator.append(inputLine, 0, lineLength);
        accumulator.append('\n');
        accumulator.append(inputLine, lineLength, inputLine.length());

        return accumulator.toString();
    }
}
