package com.spartakdebruguers.ofapp.model;

import android.content.Intent;

/**
 * News object
 *
 * @author javier_santiago
 * @version 21.02.2015
 */

public class News {
    // Attributes of the object
    private long id;
    private String imageURL;
    private String title;
    private String header;
    private String createdBy;
    private String createdDate;
    private String content;
    private String category;

    private static final String ITEM_SEP = System.getProperty("line.separator");

    // Tag names for encapsulating the News in an Intent
    public final static String ID = "id";
    public final static String IMG_URL = "img_url";
    public final static String TITLE = "title";
    public final static String HEADER = "header";
    public final static String CREATED_BY = "created_by";
    public final static String CREATED_DATE = "created_date";
    public final static String CONTENT = "content";
    public final static String CATEGORY = "category";

    /**
     * Default constructor
     */
    public News() {

    }

    /**
     * Basic constructor of the object
     *
     * @param id - the id of the news
     * @param imageURL - the image url of the news
     * @param title - the title of the news
     * @param header - the header of the news
     * @param createdBy - who created the news
     * @param createdDate - when the news was created
     * @param content - the content of the news
     * @param category - the category of the news
     */
    public News(int id, String imageURL, String title, String header, String createdBy,
                 String createdDate, String content, String category)
    {
        this.id = id;
        this.imageURL = imageURL;
        this.title = title;
        this.header = header;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.content = content;
        this.category = category;
    }

    /**
     * Constructor that creates a new News from data packaged in an Intent
     *
     * @param intent - intent including all the data
     */
    public News(Intent intent) {
        id = intent.getIntExtra(News.ID, 0);
        imageURL = intent.getStringExtra(News.IMG_URL);
        title = intent.getStringExtra(News.TITLE);
        header = intent.getStringExtra(News.HEADER);
        createdBy = intent.getStringExtra(News.CREATED_BY);
        createdDate = intent.getStringExtra(News.CREATED_DATE);
        content = intent.getStringExtra(News.CONTENT);
        category = intent.getStringExtra(News.CATEGORY);
    }

    /**
     * Get the current value of the applicationId property.
     *
     * @return returns current applicationId
     */
    public long getId() {
        return id;
    }

    /**
     * Set the value of the id property.
     *
     * @param id - id to be added
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Get the current value of the applicationId property.
     *
     * @return returns current applicationId
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Set the value of the imageURL property.
     *
     * @param imageURL - imageURL to be added
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Get the current value of the applicationId property.
     *
     * @return returns current applicationId
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of the title property.
     *
     * @param title - title to be added
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the current value of the header property.
     *
     * @return returns current header
     */
    public String getHeader() {
        return header;
    }

    /**
     * Set the value of the header property.
     *
     * @param header - header to be added
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Get the current value of the createdBy property.
     *
     * @return returns current createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Set the value of the createdBy property.
     *
     * @param createdBy - createdBy to be added
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Get the current value of the createdDate property.
     *
     * @return returns current createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Set the value of the createdDate property.
     *
     * @param createdDate - createdDate to be added
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Get the current value of the content property.
     *
     * @return returns current content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the value of the content property.
     *
     * @param content - content to be added
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get the current value of the category property.
     *
     * @return returns current category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the value of the category property.
     *
     * @param category - category to be added
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Method that transform the news to a String. It will be used in the ArrayAdaptaer in the
     * ListView
     *
     * @return the string representation of the News object
     */
    public String toString() {
        return title + ITEM_SEP + header + ITEM_SEP + createdBy + ITEM_SEP + createdDate;
    }

    /**
     * Method that transform the news to a String for logging purposes.
     *
     * @return the string representation of the News object for logging purposes
     */
    public String toLog() {
        return "Title: " + title + ITEM_SEP + "Header: " + header + ITEM_SEP + "Created By: "
                + createdBy + ITEM_SEP + "Created Date: " + createdDate;
    }
}