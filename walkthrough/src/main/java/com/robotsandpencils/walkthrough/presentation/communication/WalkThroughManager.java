package com.robotsandpencils.walkthrough.presentation.communication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

import com.robotsandpencils.walkthrough.presentation.main.WalkThroughActivity;

import javax.inject.Singleton;

/**
 * farhankhan
 * 2016-08-03
 */

@Singleton
public class WalkThroughManager {

    private static WalkThroughManager sWalkThroughManager;
    public static final String WALKTHROUGH_DEFAULT_EXIT_MESSAGE = "exit_walk_through";

    private LayoutConfiguration mLayoutConfiguration;
    private
    @ColorRes
    int mDefaultColor = android.R.color.transparent;

    public interface Listener {
        void onWalkThroughComplete(String responseTag);
    }

    private Listener mListener;

    private WalkThroughManager() {
    }

    public void start(@NonNull Context context, @NonNull LayoutConfiguration layoutConfiguration, Listener listener) {
        mListener = listener;
        mLayoutConfiguration = layoutConfiguration;
        Intent intent = new Intent(context, WalkThroughActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static WalkThroughManager getInstance() {
        if (sWalkThroughManager == null) {
            sWalkThroughManager = new WalkThroughManager();
        }
        return sWalkThroughManager;
    }

    @NonNull
    public LayoutConfiguration getLayoutConfiguration() {
        return mLayoutConfiguration;
    }

    public void onComplete(String responseTag) {
        if (mListener != null) {
            mListener.onWalkThroughComplete(responseTag);
            mListener = null;
        }
    }

    public void setDefaultColor(int color) {
        this.mDefaultColor = color;
    }

    public int getDefaultColor() {
        return mDefaultColor;
    }
}
