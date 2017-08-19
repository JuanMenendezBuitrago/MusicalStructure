package com.example.android.musicalstructure;

/**
 * Created by juan on 8/08/17.
 */

public class Playlist {

    /** The playlist name **/
    private String mName;

    /**
     * Constructor
     * @param name
     */
    public Playlist(String name) {
        this.mName = name;
    }

    /**
     * @return the playlist name.
     */
    public String getName() {
        return mName;
    }

}
