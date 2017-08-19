package com.example.android.musicalstructure;

/**
 * Created by juan on 8/08/17.
 */

public class Album {

    /** The album mTitle **/
    private String mTitle;

    /** The album mAuthor **/
    private String mAuthor;

    /**
     * Album constructor.
     * @param title
     * @param author
     */
    public Album(String title, String author) {
        this.mTitle = title;
        this.mAuthor = author;
    }

    /**
     * @return The album title.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * @return The album author.
     */
    public String getAuthor() {
        return mAuthor;
    }

}
