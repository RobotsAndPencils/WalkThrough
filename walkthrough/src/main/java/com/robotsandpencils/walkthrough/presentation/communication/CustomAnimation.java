package com.robotsandpencils.walkthrough.presentation.communication;

import android.support.annotation.AnimRes;

import com.robotsandpencils.walkthrough.R;

public class CustomAnimation {

    @AnimRes
    private int mEnter;

    @AnimRes
    private int mExit;

    @AnimRes
    private int mPopEnter;

    @AnimRes
    private int mPopExit;

    private CustomAnimation() {}

    public static CustomAnimation getEnterExitInstance(int enter, int exit) {
        CustomAnimation customAnimation = new CustomAnimation();
        customAnimation.mEnter = enter;
        customAnimation.mExit = exit;
        return customAnimation;
    }

    public static CustomAnimation getFullAnimationIntance(int enter, int exit, int popEnter, int popExit) {
        CustomAnimation customAnimation = getEnterExitInstance(enter, exit);
        customAnimation.mPopEnter = popEnter;
        customAnimation.mPopExit = popExit;
        return customAnimation;
    }
    public static CustomAnimation getDefault() {
        CustomAnimation defaultAnimations =
                getFullAnimationIntance(
                        R.anim.in_from_right, R.anim.out_to_left,
                        R.anim.in_from_left, R.anim.out_to_right);
        return defaultAnimations;
    }


    public int getEnter() {
        return mEnter;
    }

    public int getExit() {
        return mExit;
    }

    public int getPopEnter() {
        return mPopEnter;
    }

    public int getPopExit() {
        return mPopExit;
    }
}
