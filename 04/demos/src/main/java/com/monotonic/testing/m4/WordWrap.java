package com.monotonic.testing.m4;

import static java.lang.Math.min;

public class WordWrap {
    public static String wrap(String inputLine, int lineLength) {
        StringBuilder sb = new StringBuilder();

        sb.append(inputLine, 0, lineLength);
        sb.append('\n');
        sb.append(inputLine, lineLength, inputLine.length());

        return sb.toString();
    }
}
