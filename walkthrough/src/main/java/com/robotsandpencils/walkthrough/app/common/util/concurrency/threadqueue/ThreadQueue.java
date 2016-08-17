/*
 * MIT License
 *
 * Copyright (c) 2016 Robots and Pencils
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
