package com.spartakdebruguers.ofapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.spartakdebruguers.ofapp.activity.BaseActivity;
import com.spartakdebruguers.ofapp.fragments.DropDownMenuFragment;
import com.spartakdebruguers.ofapp.fragments.HomeNewsFragment;
import com.spartakdebruguers.ofapp.utils.ConfigUtils;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);

        HomeNewsFragment newsFragment = new HomeNewsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_home_fragment, newsFragment);
        transaction.commit();
    }
}
