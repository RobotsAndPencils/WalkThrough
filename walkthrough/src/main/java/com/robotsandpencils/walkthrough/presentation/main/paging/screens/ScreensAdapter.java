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
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
