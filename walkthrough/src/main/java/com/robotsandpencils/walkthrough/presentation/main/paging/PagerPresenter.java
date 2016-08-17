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

import com.robotsandpencils.walkthrough.app.common.util.concurrency.threadqueue.UiThreadQueue;

/**
 * farhankhan
 * 2016-08-04
 */

public class PagerPresenter {
    private UiThreadQueue mUiThreadQueue;
    private View mView;

    public interface View {
        void onAttached(PagerViewModel viewModel);
    }

    public PagerPresenter(UiThreadQueue uiThreadQueue) {
        mUiThreadQueue = uiThreadQueue;
    }

    void attach(View view) {
        mView = view;
        mUiThreadQueue.setEnabled(true);
        PagerViewModel pagerViewModel = createViewModel();
        mUiThreadQueue.run(() -> mView.onAttached(pagerViewModel));
    }

    void detach() {
        mUiThreadQueue.setEnabled(false);
    }

    private PagerViewModel createViewModel() {
        return new PagerViewModel();
    }

}
