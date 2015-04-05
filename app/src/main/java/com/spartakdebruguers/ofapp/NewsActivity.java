package com.spartakdebruguers.ofapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.spartakdebruguers.ofapp.adapters.NewsPageAdapter;
import com.spartakdebruguers.ofapp.fragments.NewsFragment;
import com.viewpagerindicator.CirclePageIndicator;

public class NewsActivity extends ActionBarActivity {
    NewsPageAdapter pageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);

        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache()).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP

        final List<Fragment> fragments = getFragments();
        pageAdapter = new NewsPageAdapter(getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);

        CirclePageIndicator titleIndicator = (CirclePageIndicator)findViewById(R.id.indicator);
        titleIndicator.setViewPager(pager);

        // Attach the page change listener inside the activity
        titleIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                String categoryName;

                switch(position) {
                    case 0: categoryName = getResources().getString(R.string.news_cronicas); break;
                    case 1: categoryName = getResources().getString(R.string.news_noticias); break;
                    default: categoryName = getResources().getString(R.string.news_cronicas); break;
                }

                ((TextView)findViewById(R.id.news_category_text)).setText(categoryName);
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            // Called when the scroll state changes:
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<>();

        fList.add(NewsFragment.newInstance("Crónicas"));
        fList.add(NewsFragment.newInstance("Noticias"));

        return fList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
