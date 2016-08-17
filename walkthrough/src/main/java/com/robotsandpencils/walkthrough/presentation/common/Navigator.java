package com.robotsandpencils.walkthrough.presentation.common;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.robotsandpencils.walkthrough.R;
import com.robotsandpencils.walkthrough.app.common.util.Counter;
import com.robotsandpencils.walkthrough.presentation.main.paging.PagerFragment;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;

import java.util.List;

/**
 * farhankhan
 * 2016-08-04
 */

public class Navigator {

    private static final String TAG_PAGER_FRAGMENT = "tag_pager_fragment";
    private final Counter mCounter = new Counter();

    public void showPagerFragment(FragmentManager fragmentManager, List<Page> pageList) {
        PagerFragment fragment = PagerFragment.newInstance(pageList);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left,
                R.anim.in_from_left, R.anim.out_to_right);
        fragmentTransaction.replace(R.id.fragment_container, fragment, TAG_PAGER_FRAGMENT + mCounter.next());
        fragmentTransaction.addToBackStack(TAG_PAGER_FRAGMENT + mCounter.current());
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void onUpPressed(FragmentManager fragmentManager) {
        fragmentManager.popBackStack();
    }

}
