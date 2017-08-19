package com.example.android.musicalstructure;

import android.text.format.DateUtils;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by juan on 8/08/17.
 */

public class Song implements Serializable {

    /** unique id **/
    private int id;

    /** song title **/
    private String mTitle;

    /** song length in seconds **/
    private int mLength;

    /**
     * Constructor.
     * @param title
     * @param length
     */
    public Song(int id, String title, int length) {
        this.id = id;
        this.mTitle = title;
        this.mLength = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Song))
            return false;

        Song song = (Song) obj;
        return getId()== song.getId();
    }

    /**
     * @return the song id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the song title.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * @return the song length in seconds.
     */
    public int getLength() {

        return mLength;
    }

    /**
     * @return the song length in HH:MM:SS format.
     */
    public String getLengthFormatted() {
        return DateUtils.formatElapsedTime(getLength());
    }
}
