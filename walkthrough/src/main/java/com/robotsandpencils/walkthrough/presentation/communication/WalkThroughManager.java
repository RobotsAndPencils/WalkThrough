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
