package com.robotsandpencils.walkthrough.app.common.util.concurrency.threadqueue;

import android.os.Handler;

public class AndroidHandlerRunner implements ThreadQueue.ThreadRunner {

    private Handler mHandler;

    public AndroidHandlerRunner(Handler handler) {
        mHandler = handler;
    }

    @Override
    public void run(Runnable runnable) {
        mHandler.post(runnable);
    }

    @Override
    public void runDelayed(Runnable runnable, long delayMilliseconds) {
        mHandler.postDelayed(runnable, delayMilliseconds);
    }

    @Override
    public void clear() {
        mHandler.removeCallbacksAndMessages(null);
    }
}
