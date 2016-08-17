package com.robotsandpencils.walkthroughsample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.robotsandpencils.walkthrough.presentation.communication.LayoutConfiguration;
import com.robotsandpencils.walkthrough.presentation.communication.WalkThroughManager;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.Page;
import com.robotsandpencils.walkthrough.presentation.main.paging.screens.WalkThroughView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startWalkthrough(View v) {
        WalkThroughManager mWalkThroughManager = WalkThroughManager.getInstance();
        LayoutConfiguration layoutConfiguration = new LayoutConfiguration.Builder()
                .addLayouts(getScreens())
                .build();
        mWalkThroughManager.start(this, layoutConfiguration, responseTag -> onClose(responseTag));
    }

    private void onClose(String responseTag) {
    }

    @NonNull
    public List<Page> getScreens() {
        WalkThroughScreenView screen1 = new WalkThroughScreenView(this).setMessage("Card wallet feature")
                .showClose(true);

        WalkThroughScreenView screen2 = new WalkThroughScreenView(this).setMessage("Low on data each month?")
                .showClose(true)
                .showNext(true);

        WalkThroughScreenView screen2a = new WalkThroughScreenView(this).setMessage("Select the allowances tab")
                .showBack(true)
                .showClose(true);
        WalkThroughScreenView screen2b = new WalkThroughScreenView(this).setMessage("Click on the tariff title")
                .showBack(true)
                .showClose(true);
        WalkThroughScreenView screen2c = new WalkThroughScreenView(this).setMessage("and change your tariff")
                .showBack(true)
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
