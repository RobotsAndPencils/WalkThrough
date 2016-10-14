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

package com.robotsandpencils.walkthrough.presentation.main.paging;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robotsandpencils.walkthrough.R;
import com.robotsandpencils.walkthrough.databinding.FragmentPagerBinding;
import com.robotsandpencils.walkthrough.presentation.common.Navigator;
import com.robotsandpencils.walkthrough.presentation.common.dependency.dagger.DaggerWrapper;
import com.robotsandpencils.walkthrough.presentation.communication.LayoutTheme;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.ScreensAdapter;

import javax.inject.Inject;

/**
 * farhankhan
 * 2016-08-04
 */

public class PagerFragment extends Fragment implements PagerPresenter.View {

    @Inject
    PagerPresenter mPresenter;

    @Inject
    Navigator mNavigator;

    private FragmentPagerBinding mBinding;

    public static PagerFragment newInstance(@NonNull LayoutTheme layoutTheme) {
        PagerFragment pagerFragment = new PagerFragment();
        pagerFragment.setLayoutTheme(layoutTheme);
        return pagerFragment;
    }

    LayoutTheme mLayoutTheme;

    private void setLayoutTheme(@NonNull LayoutTheme layoutTheme) {
        mLayoutTheme = layoutTheme;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerWrapper.getObjectGraph().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_pager, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.setContext(getActivity());
        mPresenter.attach(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detach();
    }

    @Override
    public void onAttached(PagerViewModel viewModel) {
        mBinding.setViewModel(viewModel);
        ScreensAdapter screensAdapter = getAdapter();
        mBinding.viewPager.setAdapter(screensAdapter);
        if (screensAdapter.getCount() > 1) {
            mBinding.pageIndicator.setViewPager(mBinding.viewPager);
            mBinding.pageIndicator.setFillColor(ContextCompat.getColor(getContext(),
                    mLayoutTheme.getPagerIndicatorFillColor()));
            mBinding.pageIndicator.setStrokeColor(ContextCompat.getColor(getContext(),
                    mLayoutTheme.getPagerIndicatorStrokeColor()));
        }
    }

    private ScreensAdapter getAdapter() {
        return new ScreensAdapter(mNavigator.getPageList());
    }

    public boolean goToNextPage() {
        int nextPagePosition = mBinding.viewPager.getCurrentItem() + 1;
        if (nextPagePosition >= mNavigator.getPageList().size()) return false;
        mBinding.viewPager.setCurrentItem(nextPagePosition);
        return true;
    }

    public boolean goToPreviousPage() {
        int previousPagePosition = mBinding.viewPager.getCurrentItem() - 1;
        if (previousPagePosition < 0) return false;
        mBinding.viewPager.setCurrentItem(previousPagePosition);
        return true;
    }

    public boolean deletePage() {
        PagerAdapter adapter = mBinding.viewPager.getAdapter();
        ((ScreensAdapter)(mBinding.viewPager.getAdapter())).removePage(mBinding.viewPager.getCurrentItem());
        adapter.notifyDataSetChanged();
        return mBinding.viewPager.getAdapter().getCount() > 0;
    }
}
