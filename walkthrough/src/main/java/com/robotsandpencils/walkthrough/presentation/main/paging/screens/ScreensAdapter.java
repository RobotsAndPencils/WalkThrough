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
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * farhankhan
 * 2016-08-04
 */

public class ScreensAdapter extends PagerAdapter {

    @NonNull
    private List<Page> mLayouts;

    public ScreensAdapter(@NonNull List<Page> layouts) {
        mLayouts = layouts;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup viewGroup = mLayouts.get(position).getView();
        ViewGroup parent = (ViewGroup) viewGroup.getParent();
        if (parent != null) {
            parent.removeView(viewGroup);
        }
        container.addView(viewGroup);
        return viewGroup;
    }

    @Override
    public int getCount() {
        return mLayouts.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        //noinspection SuspiciousMethodCalls
        if (!mLayouts.contains(object)) {
            return PagerAdapter.POSITION_NONE;
        }
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public boolean removePage(int index) {
        mLayouts.remove(index);
        return true;
    }
}
