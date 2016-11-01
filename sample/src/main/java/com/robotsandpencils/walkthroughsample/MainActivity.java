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

package com.robotsandpencils.walkthroughsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.robotsandpencils.walkthrough.presentation.communication.LayoutConfiguration;
import com.robotsandpencils.walkthrough.presentation.communication.LayoutTheme;
import com.robotsandpencils.walkthrough.presentation.communication.WalkThroughManager;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMainFragmentActivity(View v) {
        Intent myIntent = new Intent(MainActivity.this, MainFragmentActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void startWalkthrough(View v) {
        WalkThroughManager mWalkThroughManager = WalkThroughManager.getInstance();
        LayoutConfiguration layoutConfiguration = new LayoutConfiguration.Builder()
                .addLayouts(getScreens())
                .setLayoutTheme(new LayoutTheme.Builder()
                    .setPagerIndicatorFillColor(R.color.colorAccent)
                    .setPagerIndicatorStrokeColor(R.color.colorPrimaryDark)
                    .build())
                .build();
        mWalkThroughManager.start(this, layoutConfiguration, this::onClose);
    }

    private void onClose(String responseTag) {
        Toast.makeText(this, responseTag, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    public List<Page> getScreens() {
        WalkThroughScreenView screen1 = new WalkThroughScreenView(this)
                .setMessage("Join the Frequent Note Taking program")
                .showNextPage(true)
                .showClose(true);

        WalkThroughScreenView screen2 = new WalkThroughScreenView(this)
                .setMessage("Need an efficient way to organize notes?")
                .showClose(true)
                .showPreviousPage(true)
                .showNext(true);

        WalkThroughScreenView screen2a = new WalkThroughScreenView(this)
                .setMessage("Select the Notes tab")
                .showBack(true)
                .showNextPage(true)
                .showClose(true);
        WalkThroughScreenView screen2b = new WalkThroughScreenView(this)
                .setMessage("Click on the Notes Organizer button")
                .showBack(true)
                .showNextPage(true)
                .showPreviousPage(true)
                .showClose(true);
        WalkThroughScreenView screen2c = new WalkThroughScreenView(this)
                .setMessage("and check the Organize Notes checkbox")
                .showBack(true)
                .showPreviousPage(true)
                .showClose(true);

        List<Page> page2List = new ArrayList<>();
        page2List.add(new Page(screen2a, null));
        page2List.add(new Page(screen2b, null));
        page2List.add(new Page(screen2c, null));

        Page page1 = new Page(screen1, null);
        Page page2 = new Page(screen2, page2List);

        List<Page> pages = new ArrayList<>();
        pages.add(page1);
        pages.add(page2);

        return pages;
    }
}
