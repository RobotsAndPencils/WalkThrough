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

        boolean onNextPage();

        boolean onPreviousPage();
    }

    private Listener mListener;

    @NonNull
    private final WalkThroughView mWalkThroughView;

    @NonNull
    private final List<Page> mPageList;

    public Page(@NonNull WalkThroughView walkThroughView, @Nullable List<Page> pageList) {
        mWalkThroughView = walkThroughView;
        WalkThroughView.Listener listener = new WalkThroughView.Listener() {
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

            @Override
            public boolean onNextPage() {
                return mListener.onNextPage();
            }

            @Override
            public boolean onPreviousPage() {
                return mListener.onPreviousPage();
            }
        };
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
