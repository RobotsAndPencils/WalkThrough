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

import android.support.annotation.AnimatorRes;
import android.support.annotation.ColorRes;

import com.robotsandpencils.walkthrough.R;

/**
 * Created by lesfriesen on 2016-10-14.
 * Purpose: Provide theme values to the layout for parent layout customization.
 */

public class LayoutTheme {

    @ColorRes
    private int mPagerIndicatorFillColor = R.color.colorWhite;

    @ColorRes
    private int mPagerIndicatorStrokeColor = R.color.colorWhite;
    
    @AnimatorRes
    private int mPageListEnterAnimation = R.anim.in_from_right;

    @AnimatorRes
    private int mPageListExitAnimation = R.anim.out_to_left;

    @AnimatorRes
    private int mPageListPopEnterAnimation = R.anim.in_from_left;

    @AnimatorRes
    private int mPageListPopExitAnimation = R.anim.out_to_right;

    public int getPagerIndicatorFillColor() {
        return mPagerIndicatorFillColor;
    }

    private void setPagerIndicatorFillColor(int pagerIndicatorFillColor) {
        mPagerIndicatorFillColor = pagerIndicatorFillColor;
    }

    public int getPagerIndicatorStrokeColor() {
        return mPagerIndicatorStrokeColor;
    }

    private void setPagerIndicatorStrokeColor(int pagerIndicatorStrokeColor) {
        mPagerIndicatorStrokeColor = pagerIndicatorStrokeColor;
    }

    public int getPageListEnterAnimation() {
        return mPageListEnterAnimation;
    }

    public void setPageListEnterAnimation(int pageListEnterAnimation) {
        mPageListEnterAnimation = pageListEnterAnimation;
    }

    public int getPageListExitAnimation() {
        return mPageListExitAnimation;
    }

    public void setPageListExitAnimation(int pageListExitAnimation) {
        mPageListExitAnimation = pageListExitAnimation;
    }

    public int getPageListPopEnterAnimation() {
        return mPageListPopEnterAnimation;
    }

    public void setPageListPopEnterAnimation(int pageListPopEnterAnimation) {
        mPageListPopEnterAnimation = pageListPopEnterAnimation;
    }

    public int getPageListPopExitAnimation() {
        return mPageListPopExitAnimation;
    }

    public void setPageListPopExitAnimation(int pageListPopExitAnimation) {
        mPageListPopExitAnimation = pageListPopExitAnimation;
    }

    public static class Builder {

        @ColorRes
        private int mPagerIndicatorFillColor = R.color.colorWhite;

        @ColorRes
        private int mPagerIndicatorStrokeColor = R.color.colorWhite;

        @AnimatorRes
        private int mPageListEnterAnimation = R.anim.in_from_right;

        @AnimatorRes
        private int mPageListExitAnimation = R.anim.out_to_left;

        @AnimatorRes
        private int mPageListPopEnterAnimation = R.anim.in_from_left;

        @AnimatorRes
        private int mPageListPopExitAnimation = R.anim.out_to_right;

        public Builder setPagerIndicatorFillColor(int pagerIndicatorFillColor) {
            mPagerIndicatorFillColor = pagerIndicatorFillColor;
            return this;
        }

        public Builder setPagerIndicatorStrokeColor(int pagerIndicatorStrokeColor) {
            mPagerIndicatorStrokeColor = pagerIndicatorStrokeColor;
            return this;
        }

        public int getPageListEnterAnimation() {
            return mPageListEnterAnimation;
        }

        public Builder setPageListEnterAnimation(int pageListEnterAnimation) {
            mPageListEnterAnimation = pageListEnterAnimation;
            return this;
        }

        public int getPageListExitAnimation() {
            return mPageListExitAnimation;
        }

        public Builder setPageListExitAnimation(int pageListExitAnimation) {
            mPageListExitAnimation = pageListExitAnimation;
            return this;
        }

        public int getPageListPopEnterAnimation() {
            return mPageListPopEnterAnimation;
        }

        public Builder setPageListPopEnterAnimation(int pageListPopEnterAnimation) {
            mPageListPopEnterAnimation = pageListPopEnterAnimation;
            return this;
        }

        public int getPageListPopExitAnimation() {
            return mPageListPopExitAnimation;
        }

        public Builder setPageListPopExitAnimation(int pageListPopExitAnimation) {
            mPageListPopExitAnimation = pageListPopExitAnimation;
            return this;
        }

        public LayoutTheme build() {
            LayoutTheme layoutTheme = new LayoutTheme();
            layoutTheme.setPagerIndicatorFillColor(mPagerIndicatorFillColor);
            layoutTheme.setPagerIndicatorStrokeColor(mPagerIndicatorStrokeColor);
            layoutTheme.setPageListEnterAnimation(mPageListEnterAnimation);
            layoutTheme.setPageListExitAnimation(mPageListExitAnimation);
            layoutTheme.setPageListPopEnterAnimation(mPageListPopEnterAnimation);
            layoutTheme.setPageListPopExitAnimation(mPageListPopExitAnimation);
            return layoutTheme;
        }
    }
}
