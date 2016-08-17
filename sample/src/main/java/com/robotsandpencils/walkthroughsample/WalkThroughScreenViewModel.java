package com.robotsandpencils.walkthroughsample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * farhankhan
 * 2016-08-07
 */

public class WalkThroughScreenViewModel extends BaseObservable {
    private String mMessage;
    private boolean mNextEnabled;
    private boolean mBackEnabled;
    private boolean mCloseEnabled;

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
}
