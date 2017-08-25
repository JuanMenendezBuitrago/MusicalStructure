package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

public class SongsActivity extends AppCompatActivity {

    /** List of songs **/
    ArrayList<Song> mSongs = new ArrayList<>();

    /** Activity's label **/
    String mLabel = "Songs screen";

    /** Activity's description **/
    String mDescription = "When the user clicks on the > button, the app shows the song screen " +
            "where there's a description an a play/pause button.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // set required texts
        ((TextView)findViewById(R.id.labelText)).setText(mLabel);
        ((TextView)findViewById(R.id.descriptionText)).setText(mDescription);

        MusicPlayer.getInstance().updateNowPlayingStatus(this);

        // Add mock songs to the array list
        LinearLayout list = (LinearLayout) findViewById(R.id.listView);
        mSongs.add(new Song(1, "One song",160));
        mSongs.add(new Song(2, "Another song", 213));

        // Add items into the linear layout
        for(final Song song :  mSongs) {
            // inflate view and set texts
            View item = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
            ((TextView) item.findViewById(R.id.titleText)).setText(song.getTitle());
            ((TextView) item.findViewById(R.id.subtitleText)).setText(song.getLengthFormatted());

            // add item to layout
            list.addView(item);

            // add click handler
            ImageButton button = (ImageButton) item.findViewById(R.id.actionIcon);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent songIntent = new Intent(SongsActivity.this, SongActivity.class);
                    songIntent.putExtra("song", song);
                    startActivity(songIntent);
                }
            });
        }
    }
}
