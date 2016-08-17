package com.robotsandpencils.walkthrough.presentation.communication;

import android.support.annotation.NonNull;

import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * farhankhan
 * 2016-08-04
 */

public class LayoutConfiguration {
    private List<Page> mLayouts;

    private LayoutConfiguration(@NonNull ArrayList<Page> layouts) {
        mLayouts = layouts;
    }

    public List<Page> getLayouts() {
        return Collections.unmodifiableList(mLayouts);
    }

    public static class Builder {
        private ArrayList<Page> mLayouts = new ArrayList<>();

        public Builder addLayout(@NonNull Page layout) {
            mLayouts.add(layout);
            return this;
        }

        public Builder addLayouts(@NonNull List<Page> layouts) {
            for (Page page : layouts) {
                mLayouts.add(page);
            }
            return this;
        }

        public LayoutConfiguration build() {
            if (mLayouts.size() <= 0) {
                throw new IllegalArgumentException("Please specify atleast one layout for building LayoutConfiguration");
            }
            return new LayoutConfiguration(mLayouts);
        }
    }

}
