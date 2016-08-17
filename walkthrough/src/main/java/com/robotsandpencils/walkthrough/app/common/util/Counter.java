package com.robotsandpencils.walkthrough.app.common.util;

/**
 * farhankhan
 * 2016-08-07
 */

public class Counter {
    private int count = 0;

    public synchronized int next() {
        return ++count;
    }

    public int current() {
        return count;
    }
}
