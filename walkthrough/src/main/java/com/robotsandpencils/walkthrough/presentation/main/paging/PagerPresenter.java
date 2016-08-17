package com.robotsandpencils.walkthrough.presentation.main.paging;

import com.robotsandpencils.walkthrough.app.common.util.concurrency.threadqueue.UiThreadQueue;
import com.robotsandpencils.walkthrough.presentation.communication.WalkThroughManager;

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
