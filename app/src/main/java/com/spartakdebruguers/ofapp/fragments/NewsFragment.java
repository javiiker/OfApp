package com.spartakdebruguers.ofapp.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spartakdebruguers.ofapp.R;
import com.spartakdebruguers.ofapp.adapters.NewsAdapter;
import com.spartakdebruguers.ofapp.database.DBHelper;
import com.spartakdebruguers.ofapp.model.News;

import java.util.List;

/**
 *
 * Created by javier_santiago on 01/03/2015.
 */
public class NewsFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_layout, container);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get the context
        Context context = getActivity();

        // get the information from the database
        DBHelper db = new DBHelper(context);
        List<News> values = db.getAllNews();
        db.closeDB();

        // assign the adapter
        NewsAdapter adapter = new NewsAdapter(context, values);
        setListAdapter(adapter);
    }
}
