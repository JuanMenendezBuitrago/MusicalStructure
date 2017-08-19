package com.example.android.musicalstructure;

/**
 * Created by juan on 8/08/17.
 */

public class Artist {

    /** Artist's name **/
    private String name;

    /** Artist's description **/
    private String description = "";

    /**
     * Constructor.
     * @param name
     */
    public Artist(String name) {
        this.name = name;
    }

    /**
     * @return the artist's name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the artist's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the artist's description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
