package com.robotsandpencils.walkthrough.presentation.main;

import com.robotsandpencils.walkthrough.app.common.util.concurrency.threadqueue.UiThreadQueue;

/**
 * farhankhan
 * 2016-08-04
 */

public class WalkThroughPresenter {

    private UiThreadQueue mUiThreadQueue;
    private View mView;

    public interface View {
        void showWalkThrough();
    }

    public WalkThroughPresenter(UiThreadQueue uiThreadQueue) {
        this.mUiThreadQueue = uiThreadQueue;
    }

    void attach(View view) {
        mView = view;
        mUiThreadQueue.setEnabled(true);
        mUiThreadQueue.run(() -> mView.showWalkThrough());
    }

    void detach() {
        mUiThreadQueue.setEnabled(false);
    }
}
