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

package com.robotsandpencils.walkthrough.presentation.communication;

import android.support.annotation.NonNull;

import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;

import java.util.ArrayList;
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

    @NonNull
    public List<Page> getLayouts() {
        return mLayouts;
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
