package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    /** List of artists **/
    ArrayList<Artist> mArtists = new ArrayList<>();

    /** Activity's Label **/
    String mLabel = "Artists screen";

    /** Activity's description **/
    String mDescription = "When clicking on the > button, the user is taken to the albums screen.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // set the required texts
        ((TextView)findViewById(R.id.labelText)).setText(mLabel);
        ((TextView)findViewById(R.id.descriptionText)).setText(mDescription);

        MusicPlayer.getInstance().updateNowPlayingStatus(this);

        // Add mock artists to the array list
        LinearLayout list = (LinearLayout) findViewById(R.id.listView);
        mArtists.add(new Artist("One artist"));
        mArtists.add(new Artist("Another artist"));

        // Add items into the linear layout
        for(Artist artist :  mArtists) {
            // inflate view and set texts
            View item = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
            ((TextView) item.findViewById(R.id.titleText)).setText(artist.getName());
            ((TextView) item.findViewById(R.id.subtitleText)).setText(artist.getDescription());

            // add item to layout
            list.addView(item);

            // add click handler
            ImageButton button = (ImageButton) item.findViewById(R.id.actionIcon);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent artistIntent = new Intent(ArtistsActivity.this, AlbumsActivity.class);
                    startActivity(artistIntent);
                }
            });
        }
    }
}
