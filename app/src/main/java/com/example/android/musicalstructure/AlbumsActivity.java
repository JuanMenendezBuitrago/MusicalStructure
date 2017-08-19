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

public class AlbumsActivity extends AppCompatActivity {

    ArrayList<Album> mAlbums = new ArrayList<>();
    String mDescription = "This is the list of albums";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ((TextView)findViewById(R.id.descriptionText)).setText(mDescription);

        MusicPlayer.getInstance().updateNowPlayingStatus(this);

        LinearLayout list = (LinearLayout) findViewById(R.id.listView);

        // Add mock albums to the array list
        mAlbums.add(new Album("Album's title", "Album's author"));
        mAlbums.add(new Album("Another album's title", "Another album's author"));

        // Add items into the linear layout
        for(Album album :  mAlbums) {
            // inflate view and set texts
            View item = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
            ((TextView) item.findViewById(R.id.titleText)).setText(album.getTitle());
            ((TextView) item.findViewById(R.id.subtitleText)).setText(album.getAuthor());

            // add item to layout
            list.addView(item);

            // add click handler
            ImageButton button = item.findViewById(R.id.actionIcon);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent albumIntent = new Intent(AlbumsActivity.this, SongsActivity.class);
                    startActivity(albumIntent);
                }
            });
        }
    }
}
