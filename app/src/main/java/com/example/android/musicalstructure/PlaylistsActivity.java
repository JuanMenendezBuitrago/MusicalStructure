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

public class PlaylistsActivity extends AppCompatActivity {

    ArrayList<Playlist> mPlaylists = new ArrayList<>();
    String mDescription = "This is the list of playlists";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ((TextView)findViewById(R.id.descriptionText)).setText(mDescription);

        MusicPlayer.getInstance().updateNowPlayingStatus(this);

        // Add mock playlists to the array list
        LinearLayout list = (LinearLayout) findViewById(R.id.listView);
        mPlaylists.add(new Playlist("Playlist's name"));
        mPlaylists.add(new Playlist("Another playlist's name"));

        // Add items into the linear layout
        for(Playlist playlist :  mPlaylists) {
            // inflate view and set texts
            View item = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
            ((TextView) item.findViewById(R.id.titleText)).setText(playlist.getName());

            // add item to layout
            list.addView(item);

            // add click handler
            ImageButton button = (ImageButton) item.findViewById(R.id.actionIcon);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent playlistIntent = new Intent(PlaylistsActivity.this, SongsActivity.class);
                    startActivity(playlistIntent);
                }
            });
        }
    }

}
