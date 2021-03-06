package com.spartakdebruguers.ofapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.spartakdebruguers.ofapp.R;
import com.spartakdebruguers.ofapp.activity.NewsDetailsActivity;
import com.spartakdebruguers.ofapp.database.DBHelper;
import com.spartakdebruguers.ofapp.model.News;
import java.util.List;

/**
 * Class representing the adapter of the News ListView
 * Created by javier_santiago on 28/02/2015.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private static final String LOG = NewsAdapter.class.getName(); // Logcat cat
    private final Context context;
    private final List<News> values;

    static class ViewHolder {
        TextView titleView;
        TextView subtitleView;
        ImageView thumb_image;
        ImageLoader imageLoader;
    }

    public NewsAdapter(Context context, List<News> values) {
        super(context, R.layout.news_row_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;

        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (position == 0)
                convertView = inflater.inflate(R.layout.news_first_row_layout, parent, false);
            else
                convertView = inflater.inflate(R.layout.news_row_layout, parent, false);

            // well set up the ViewHolder
            mViewHolder = new ViewHolder();
            mViewHolder.thumb_image  = (ImageView) convertView.findViewById(R.id.news_image); // thumb image
            mViewHolder.titleView  = (TextView) convertView.findViewById(R.id.news_title); // title
            mViewHolder.subtitleView = (TextView) convertView.findViewById(R.id.news_subtitle); // subtitle
            mViewHolder.imageLoader = ImageLoader.getInstance(); // image loader plug-in

            // store the holder with the view
            convertView.setTag(mViewHolder);
        } else {
            // just use the viewHolder
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        // if the list of values is not null
        if (values != null) {
            // object item based on the position
            final News newsObject = values.get(position);

            // assign the values if the object is not null
            if (newsObject != null) {
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // create an intent stating which Activity you would like to start
                        Intent newsDetailIntent = new Intent(v.getContext(), NewsDetailsActivity.class);

                        // add the activity data of the intent
                        //newsDetailIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        newsDetailIntent.putExtra(DBHelper.COLUMN_NEWS_IMG_URL, "http://spartakdebruguers.com/images/stories/news/repartiendo_estopa.jpg");
                        newsDetailIntent.putExtra(DBHelper.COLUMN_NEWS_TITLE, "Entre penalti y doble penaltis");
                        newsDetailIntent.putExtra(DBHelper.COLUMN_NEWS_HEADER, "Gavasella 4 - Spartak 2");
                        newsDetailIntent.putExtra(DBHelper.COLUMN_NEWS_CONTENT, "");

                        v.getContext().startActivity(newsDetailIntent);
                    }
                });

                String url = "http://spartakdebruguers.com/images/stories/news/repartiendo_estopa.jpg";
                mViewHolder.imageLoader.displayImage(url,mViewHolder.thumb_image);

                mViewHolder.titleView.setText("Entre penalti y doble penaltis");
                mViewHolder.subtitleView.setText("Gavasella 4 - Spartak 2");

                //mViewHolder.titleView.setText(newsObject.getTitle());
                //mViewHolder.titleView.setText(newsObject.getTitle());
            }
        }

        return convertView;
    }
}
