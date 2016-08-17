package com.robotsandpencils.walkthrough.presentation.main.paging.screens;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * farhankhan
 * 2016-08-07
 */

public class Page {
    public interface Listener {
        void onClose(String exitText);

        void onNext(List<Page> pageList);

        void onBack();
    }

    private Listener mListener;

    private WalkThroughView.Listener listener = new WalkThroughView.Listener() {
        @Override
        public void onClose(String exitText) {
            mListener.onClose(exitText);
        }

        @Override
        public void onNext() {
            mListener.onNext(mPageList);
        }

        @Override
        public void onBack() {
            mListener.onBack();
        }
    };

    @NonNull
    private final WalkThroughView mWalkThroughView;

    @NonNull
    private final List<Page> mPageList;

    public Page(@NonNull WalkThroughView walkThroughView, @Nullable List<Page> pageList) {
        mWalkThroughView = walkThroughView;
        mWalkThroughView.setListener(listener);
        pageList = pageList == null ? new ArrayList<>() : pageList;
        mPageList = Collections.unmodifiableList(pageList);
        for (Page page : mPageList) {
            page.getView().setListener(listener);
        }
    }

    public WalkThroughView getView() {
        return mWalkThroughView;
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }
}
