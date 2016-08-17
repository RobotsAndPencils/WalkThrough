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

    public void setListener(Listener listener) {
        mListener = listener;
    }
}
