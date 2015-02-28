package com.spartakdebruguers.ofapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.spartakdebruguers.ofapp.R;
import com.spartakdebruguers.ofapp.model.News;
import java.util.List;

/**
 * Created by javier_santiago on 28/02/2015.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private final Context context;
    private final List<News> values;

    static class ViewHolder {
        TextView titleView;
        TextView subtitleView;
        ImageView thumb_image;
    }

    public NewsAdapter(Context context, List<News> values) {
        super(context, R.layout.news_row_layout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = null;

        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.news_row_layout, parent, false);

            // well set up the ViewHolder
            mViewHolder = new ViewHolder();
            mViewHolder.thumb_image  = (ImageView) convertView.findViewById(R.id.news_image); // thumb image
            mViewHolder.titleView  = (TextView) convertView.findViewById(R.id.news_title); // title
            mViewHolder.subtitleView = (TextView) convertView.findViewById(R.id.news_subtitle); // subtitle

            // store the holder with the view
            convertView.setTag(mViewHolder);
        } else {
            // just avoid calling findViewById()
            // just use the viewHolder
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        // if the list of values is not null
        if (values != null) {
            // object item based on the position
            News newsObject = values.get(position);

            // assign the values if the object is not null
            if (newsObject != null) {
                mViewHolder.titleView.setText(newsObject.getTitle());
                mViewHolder.titleView.setText(newsObject.getTitle());
            }
        }

        return convertView;
    }
}
