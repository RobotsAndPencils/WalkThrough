package com.robotsandpencils.walkthroughsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.robotsandpencils.walkthrough.presentation.main.paging.screens.WalkThroughView;
import com.robotsandpencils.walkthroughsample.databinding.WalkThroughScreenViewBinding;

/**
 * farhankhan
 * 2016-08-05
 */

public class WalkThroughScreenView extends WalkThroughView {

    private WalkThroughScreenViewBinding mBinding;
    private WalkThroughScreenViewModel mViewModel;

    public WalkThroughScreenView(Context context) {
        this(context, null);
    }

    public WalkThroughScreenView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBinding = DataBindingUtil.inflate((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE),
                R.layout.walk_through_screen_view, this, true);
        mViewModel = new WalkThroughScreenViewModel();

        mBinding.buttonBack.setOnClickListener(v -> previousWalkThrough());
        mBinding.buttonShowMe.setOnClickListener(v -> nextWalkThrough());
        mBinding.buttonClose.setOnClickListener(v -> exitWalkThrough("exit"));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mBinding.setViewModel(mViewModel);
    }

    public WalkThroughScreenView setMessage(String message) {
        mViewModel.setMessage(message);
        return this;
    }

    public WalkThroughScreenView showClose(boolean show) {
        mViewModel.setCloseEnabled(show);
        return this;
    }

    public WalkThroughScreenView showBack(boolean show) {
        mViewModel.setBackEnabled(show);
        return this;
    }

    public WalkThroughScreenView showNext(boolean show) {
        mViewModel.setNextEnabled(show);
        return this;
    }
}
