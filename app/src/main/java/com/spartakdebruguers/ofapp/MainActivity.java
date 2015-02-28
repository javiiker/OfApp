package com.spartakdebruguers.ofapp;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.spartakdebruguers.ofapp.adapters.NewsAdapter;
import com.spartakdebruguers.ofapp.database.DBHelper;
import com.spartakdebruguers.ofapp.model.News;

import java.util.List;

public class MainActivity extends ListActivity {
    // Database Helper
    DBHelper db;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        db = new DBHelper(getApplicationContext());
        List<News> values = db.getAllNews();
        db.closeDB();
        Log.i("TEST",Integer.toString(values.size()));
        NewsAdapter adapter = new NewsAdapter(this, values);
        setListAdapter(adapter);
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.news_layout);

        /*
        db = new DBHelper(getApplicationContext());
        List<News> values = db.getAllNews();
        db.closeDB();

}
*/

/*
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
    */
}
