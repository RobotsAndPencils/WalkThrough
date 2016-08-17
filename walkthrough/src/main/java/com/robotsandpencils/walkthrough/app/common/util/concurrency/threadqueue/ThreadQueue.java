package com.robotsandpencils.walkthrough.app.common.util.concurrency.threadqueue;

public class ThreadQueue {

    private boolean mIsEnabled;
    private ThreadRunner mThreadRunner;

    public interface ThreadRunner {
        void run(Runnable runnable);

        void runDelayed(Runnable runnable, long delayMilliseconds);

        void clear();
    }

    public ThreadQueue(ThreadRunner threadRunner) {
        mThreadRunner = threadRunner;
    }

    public void run(Runnable runnable) {
        if (isEnabled()) {
            mThreadRunner.run(runnable);
        }
    }

    public void runDelayed(Runnable runnable, long delayMilliseconds) {
        if (isEnabled()) {
            mThreadRunner.runDelayed(runnable, delayMilliseconds);
        }
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.mIsEnabled = enabled;

        if (!isEnabled()) {
            clear();
        }
    }

    public void clear() {
        mThreadRunner.clear();
    }
}
