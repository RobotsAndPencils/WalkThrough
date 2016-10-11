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

package com.robotsandpencils.walkthrough.presentation.main.paging.screens;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * farhankhan
 * 2016-08-04
 */

public class WalkThroughView extends LinearLayout {

    interface Listener {
        void onClose(String exitText);

        void onNext();

        void onBack();

        boolean onNextPage();

        boolean onPreviousPage();

        boolean onDeletePage();
    }

    private Listener mListener;

    public WalkThroughView(Context context) {
        super(context);
    }

    public WalkThroughView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void exitWalkThrough(String exitText) {
        mListener.onClose(exitText);
    }

    protected void nextWalkThrough() {
        mListener.onNext();
    }

    protected void previousWalkThrough() {
        mListener.onBack();
    }

    protected boolean nextPage() { return mListener.onNextPage(); }

    protected boolean previousPage() { return mListener.onPreviousPage(); }

    public boolean deletePage(String reason) {
        if (!mListener.onDeletePage()) {
            mListener.onClose(reason);
            return false;
        }
        return true;
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }
}
