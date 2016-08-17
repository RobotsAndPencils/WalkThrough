package com.robotsandpencils.walkthrough.app.common.util.concurrency.threadqueue;

/**
 * farhankhan
 * 2016-08-04
 */

import android.os.Handler;
import android.os.Looper;

public class UiThreadQueue extends ThreadQueue {

    public UiThreadQueue() {
        super(new AndroidHandlerRunner(new Handler(Looper.getMainLooper())));
    }

}
