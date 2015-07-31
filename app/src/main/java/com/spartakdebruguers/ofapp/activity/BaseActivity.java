package com.spartakdebruguers.ofapp.activity;

import android.app.Activity;
import android.app.ActivityOptions;



import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.transition.AutoTransition;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.spartakdebruguers.ofapp.R;
import com.spartakdebruguers.ofapp.SpartakApplication;
import com.spartakdebruguers.ofapp.fragments.DropDownMenuFragment;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android.support.v7.app.ActionBar menu = getSupportActionBar(); // get the bar
        menu.setDisplayShowCustomEnabled(true);
        menu.setDisplayShowHomeEnabled(true); // show back button if any
        menu.setDisplayUseLogoEnabled(true); // show the logo
        menu.setDisplayShowTitleEnabled(false); // hide the tittle
        menu.setShowHideAnimationEnabled(false);

        // change the colour of the back arrow
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.home_arrow), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                // Mark the menu as opened
                ((SpartakApplication) this.getApplication()).setIsShowingMenu(false);
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            case R.id.action_menu:
                if(!isCreated()) {
                    DropDownMenuFragment menuFragment = new DropDownMenuFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    //transaction.setCustomAnimations(R.animator.push_down_in, R.animator.push_down_out, R.animator.push_down_out, R.animator.push_down_in);
                    transaction.add(R.id.main_home_fragment, menuFragment, "menu_tag");
                    //transaction.addToBackStack("menu_tag");
                    transaction.commit();
                } else if(!isVisible()) {
                    DropDownMenuFragment test = (DropDownMenuFragment) getSupportFragmentManager().findFragmentByTag("menu_tag");

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    //transaction.setCustomAnimations(R.animator.push_down_in, R.animator.push_down_out, R.animator.push_down_out, R.animator.push_down_in);
                    transaction.show(test);
                    transaction.commit();
                    getSupportFragmentManager().executePendingTransactions();
                } else {
                    DropDownMenuFragment test = (DropDownMenuFragment) getSupportFragmentManager().findFragmentByTag("menu_tag");

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    //transaction.setCustomAnimations(R.animator.push_down_in, R.animator.push_down_out, R.animator.push_down_out, R.animator.push_down_in);
                    transaction.hide(test);
                    transaction.commit();
                    getSupportFragmentManager().executePendingTransactions();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ((SpartakApplication) this.getApplication()).setIsShowingMenu(false);
    }
    */

    private boolean isCreated() {
        DropDownMenuFragment test = (DropDownMenuFragment) getSupportFragmentManager().findFragmentByTag("menu_tag");
        return test!=null;
    }

    private boolean isVisible(){
        DropDownMenuFragment test = (DropDownMenuFragment) getSupportFragmentManager().findFragmentByTag("menu_tag");
        return test!=null && test.isVisible();
    }
}
