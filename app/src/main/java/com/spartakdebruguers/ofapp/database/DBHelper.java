package com.spartakdebruguers.ofapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.spartakdebruguers.ofapp.model.News;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = DBHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "spartak";

    // Table Names
    private static final String TABLE_NEWS = "news";

    // Common column names
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_CREATED_BY = "created_by";
    private static final String COLUMN_CREATED_DATE = "created_date";

    // NEWS Table - column names
    private static final String COLUMN_NEWS_IMG_URL = "img_url";
    private static final String COLUMN_NEWS_TITLE = "title";
    private static final String COLUMN_NEWS_HEADER = "header";
    private static final String COLUMN_NEWS_CONTENT = "content";

    // Table Create Statements
    private static final String CREATE_TABLE_NEWS = "CREATE TABLE "
            + TABLE_NEWS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NEWS_IMG_URL
            + " TEXT," + COLUMN_NEWS_TITLE + " TEXT," + COLUMN_NEWS_HEADER + " TEXT, "
            + COLUMN_NEWS_CONTENT + " TEXT, " + COLUMN_CREATED_DATE + " TEXT, "
            + COLUMN_CREATED_DATE + " DATETIME" + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_NEWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(LOG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);

        // create new tables
        onCreate(db);
    }

    /**
     *
     * @param newObject
     * @return
     */
    public long createNews(News newObject) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, newObject.getId());
        values.put(COLUMN_NEWS_IMG_URL, newObject.getImageURL());
        values.put(COLUMN_NEWS_TITLE, newObject.getTitle());
        values.put(COLUMN_NEWS_HEADER, newObject.getHeader());
        values.put(COLUMN_NEWS_CONTENT, newObject.getContent());
        values.put(COLUMN_CREATED_BY, newObject.getCreatedBy());
        values.put(COLUMN_CREATED_DATE, newObject.getCreatedDate());

        // insert row
        long todo_id = db.insert(TABLE_NEWS, null, values);

        return todo_id;
    }

    /**
     *
     * @return
     */
    public List<News> getAllNews() {
        List<News> news = new ArrayList<News>();
        String selectQuery = "SELECT  * FROM " + TABLE_NEWS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                News newObject = new News();
                newObject.setId(c.getInt((c.getColumnIndex(COLUMN_ID))));
                newObject.setImageURL((c.getString(c.getColumnIndex(COLUMN_NEWS_IMG_URL))));
                newObject.setTitle((c.getString(c.getColumnIndex(COLUMN_NEWS_TITLE))));
                newObject.setHeader((c.getString(c.getColumnIndex(COLUMN_NEWS_HEADER))));
                newObject.setContent((c.getString(c.getColumnIndex(COLUMN_NEWS_CONTENT))));
                newObject.setCreatedBy((c.getString(c.getColumnIndex(COLUMN_CREATED_BY))));
                newObject.setCreatedDate((c.getString(c.getColumnIndex(COLUMN_CREATED_DATE))));

                // adding to news list
                news.add(newObject);
            } while (c.moveToNext());
        }

        return news;
    }



    /**
     * Method that close the readable database
     */
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}

