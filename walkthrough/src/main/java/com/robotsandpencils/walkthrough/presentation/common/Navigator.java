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

package com.robotsandpencils.walkthrough.presentation.common;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.robotsandpencils.walkthrough.R;
import com.robotsandpencils.walkthrough.app.common.util.Counter;
import com.robotsandpencils.walkthrough.presentation.main.paging.PagerFragment;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;

import java.util.List;
import java.util.Stack;

/**
 * farhankhan
 * 2016-08-04
 */

public class Navigator {

    private static final String TAG_PAGER_FRAGMENT = "tag_pager_fragment";
    private final Counter mCounter = new Counter();
    private Stack<List<Page>> mPageListStack = new Stack<>();
    private PagerFragment mPagerFragment;

    public void showPagerFragment(FragmentManager fragmentManager, List<Page> pageList) {
        pushPageList(pageList);
        mPagerFragment = PagerFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left,
                R.anim.in_from_left, R.anim.out_to_right);
        fragmentTransaction.replace(R.id.fragment_container, mPagerFragment, TAG_PAGER_FRAGMENT + mCounter.next());
        fragmentTransaction.addToBackStack(TAG_PAGER_FRAGMENT + mCounter.current());
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void onUpPressed(FragmentManager fragmentManager) {
        popPageList();
        fragmentManager.popBackStack();
    }

    private void pushPageList(List<Page> pageList) { mPageListStack.push(pageList); }

    private List<Page> popPageList() { return mPageListStack.pop(); }

    public List<Page> getPageList() { return mPageListStack.peek(); }

    public void clear() {
        mPageListStack.clear();
    }

    public void onNextPagePressed() {
        mPagerFragment.goToNextPage();
    }

    public void onPreviousPagePressed() {
        mPagerFragment.goToPreviousPage();
    }
}
