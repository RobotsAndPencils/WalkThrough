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
