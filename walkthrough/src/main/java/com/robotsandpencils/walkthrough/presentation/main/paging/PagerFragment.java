package com.robotsandpencils.walkthrough.presentation.main.paging;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robotsandpencils.walkthrough.R;
import com.robotsandpencils.walkthrough.databinding.FragmentPagerBinding;
import com.robotsandpencils.walkthrough.presentation.common.dependency.dagger.DaggerWrapper;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.ScreensAdapter;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

/**
 * farhankhan
 * 2016-08-04
 */

public class PagerFragment extends Fragment implements PagerPresenter.View {

    @Inject
    PagerPresenter mPresenter;

    private List<Page> mPageList;

    public void setPageList(List<Page> pageList) {
        mPageList = Collections.unmodifiableList(pageList);
    }

    private FragmentPagerBinding mBinding;

    public static PagerFragment newInstance(List<Page> pageList) {
        PagerFragment fragment = new PagerFragment();
        fragment.setPageList(pageList);
        return fragment;
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
        }
    }

    private ScreensAdapter getAdapter() {
        return new ScreensAdapter(mPageList);
    }

}
