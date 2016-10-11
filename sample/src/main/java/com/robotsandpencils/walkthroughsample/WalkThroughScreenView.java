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
        mBinding.nextPageButton.setOnClickListener(v -> nextPage());
        mBinding.previousPageButton.setOnClickListener(v -> previousPage());
        mBinding.buttonNoThanks.setOnClickListener(v -> deletePage("reject"));
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

    public WalkThroughScreenView showNextPage(boolean show) {
        mViewModel.setNextPageEnabled(show);
        return this;
    }

    public WalkThroughScreenView showPreviousPage(boolean show) {
        mViewModel.setPreviousPageEnabled(show);
        return this;
    }

    public WalkThroughScreenView showDeletePage(boolean show) {
        mViewModel.setDeletePageEnabled(show);
        return this;
    }
}
