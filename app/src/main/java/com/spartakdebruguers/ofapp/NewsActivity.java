package com.spartakdebruguers.ofapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.spartakdebruguers.ofapp.activity.BaseActivity;
import com.spartakdebruguers.ofapp.adapters.NewsPageAdapter;
import com.spartakdebruguers.ofapp.fragments.NewsFragment;
import com.spartakdebruguers.ofapp.utils.ConfigUtils;
import com.viewpagerindicator.CirclePageIndicator;

public class NewsActivity extends Fragment {
    private FragmentActivity myContext;
    private NewsPageAdapter pageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_news, container, false);

        final List<Fragment> fragments = getFragments();
        pageAdapter = new NewsPageAdapter(myContext.getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager)myContext.findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);

        CirclePageIndicator titleIndicator = (CirclePageIndicator)myContext.findViewById(R.id.indicator);
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

                ((TextView)myContext.findViewById(R.id.news_category_text)).setText(categoryName);
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

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    private List<Fragment> getFragments(){
        List<Fragment> fList = new ArrayList<>();

        fList.add(NewsFragment.newInstance("Crónicas"));
        fList.add(NewsFragment.newInstance("Noticias"));

        return fList;
    }
}
