package com.robotsandpencils.walkthroughsample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainFragmentActivity extends AppCompatActivity implements Demo1Fragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Fragment fragment  = new Demo1Fragment();
        updateFragment(fragment);
    }

    protected void updateFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(
                R.anim.slide_in_up, R.anim.fragment_slide_left_exit,
                R.anim.fragment_slide_left_enter ,  R.anim.slide_out_down);

        transaction.replace(R.id.fragment_container, fragment).addToBackStack("FragmentTag");
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("dbg", "uri: + "+ uri);
    }
}
