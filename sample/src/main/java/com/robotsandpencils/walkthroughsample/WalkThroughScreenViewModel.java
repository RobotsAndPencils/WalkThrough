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

package com.robotsandpencils.walkthroughsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;

/**
 * farhankhan
 * 2016-08-07
 */

public class WalkThroughScreenViewModel extends BaseObservable {
    private String mMessage;
    private boolean mNextEnabled;
    private boolean mBackEnabled;
    private boolean mCloseEnabled;
    private boolean mNextPageEnabled;
    private boolean mPreviousPageEnabled;

    @Bindable
    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
        notifyPropertyChanged(BR.message);
    }

    @Bindable
    public boolean isNextEnabled() {
        return mNextEnabled;
    }

    public void setNextEnabled(boolean nextEnabled) {
        mNextEnabled = nextEnabled;
        notifyPropertyChanged(BR.nextEnabled);
    }

    @Bindable
    public boolean isBackEnabled() {
        return mBackEnabled;
    }

    public void setBackEnabled(boolean backEnabled) {
        mBackEnabled = backEnabled;
        notifyPropertyChanged(BR.backEnabled);
    }

    @Bindable
    public boolean isCloseEnabled() {
        return mCloseEnabled;
    }

    public void setCloseEnabled(boolean closeEnabled) {
        mCloseEnabled = closeEnabled;
        notifyPropertyChanged(BR.closeEnabled);
    }

    @Bindable
    public boolean isNextPageEnabled() {
        return mNextPageEnabled;
    }

    public void setNextPageEnabled(boolean nextPageEnabled) {
        mNextPageEnabled = nextPageEnabled;
        notifyPropertyChanged(BR.nextPageEnabled);
    }

    @Bindable
    public boolean isPreviousPageEnabled() {
        return mPreviousPageEnabled;
    }

    public void setPreviousPageEnabled(boolean previousPageEnabled) {
        mPreviousPageEnabled = previousPageEnabled;
        notifyPropertyChanged(BR.previousPageEnabled);
    }

    @BindingAdapter({"showIfEnabled"})
    public static void showIfEnabled(View view, boolean enabled) {
        view.setVisibility(enabled ? View.VISIBLE : View.GONE);
    }
}
