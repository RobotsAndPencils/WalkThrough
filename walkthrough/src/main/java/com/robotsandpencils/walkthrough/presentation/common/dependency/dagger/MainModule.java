package com.robotsandpencils.walkthrough.presentation.common.dependency.dagger;

import com.robotsandpencils.walkthrough.app.common.util.concurrency.threadqueue.UiThreadQueue;
import com.robotsandpencils.walkthrough.presentation.common.Navigator;
import com.robotsandpencils.walkthrough.presentation.communication.WalkThroughManager;
import com.robotsandpencils.walkthrough.presentation.main.WalkThroughActivity;
import com.robotsandpencils.walkthrough.presentation.main.WalkThroughPresenter;
import com.robotsandpencils.walkthrough.presentation.main.paging.PagerFragment;
import com.robotsandpencils.walkthrough.presentation.main.paging.PagerPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * farhankhan
 * 2016-08-04
 */
@Module(
        injects = {
                WalkThroughActivity.class,
                WalkThroughPresenter.class,
                PagerFragment.class
        }
)
class MainModule {

    @Provides
    @Singleton
    UiThreadQueue provideUIThread() {
        return new UiThreadQueue();
    }

    @Provides
    @Singleton
    WalkThroughManager provideWalkThroughManager() {
        return WalkThroughManager.getInstance();
    }

    @Provides
    WalkThroughPresenter provideWalkThroughPresenter(
            UiThreadQueue uiThreadQueue) {
        return new WalkThroughPresenter(uiThreadQueue);
    }

    @Provides
    PagerPresenter providePagerPresenter(UiThreadQueue uiThreadQueue) {
        return new PagerPresenter(uiThreadQueue);
    }

    @Provides
    @Singleton
    Navigator provideNavigationClient() {
        return new Navigator();
    }
}
