package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    /** Activity's Label **/
    String mLabel = "Main screen";

    /** Activity's description **/
    String mDescription = "This is he main screen with buttons that link to other sections of " +
            "the app.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set required screen
        ((TextView)findViewById(R.id.labelText)).setText(mLabel);
        ((TextView)findViewById(R.id.descriptionText)).setText(mDescription);

        // songs button
        Button songsButton = (Button) findViewById(R.id.songsButton);
        songsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(MainActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

        // artists button
        Button artistsButton = (Button) findViewById(R.id.artistsButton);
        artistsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artistsIntent = new Intent(MainActivity.this, ArtistsActivity.class);
                startActivity(artistsIntent);
            }
        });

        // lists button
        Button listsButton = (Button) findViewById(R.id.playlistsButton);
        listsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistsIntent = new Intent(MainActivity.this, PlaylistsActivity.class);
                startActivity(playlistsIntent);
            }
        });

        // albums button
        Button albumsButton = (Button) findViewById(R.id.albumsButton);
        albumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(MainActivity.this, AlbumsActivity.class);
                startActivity(albumsIntent);
            }
        });

        // payment info button
        Button paymentButton = (Button) findViewById(R.id.paymentButton);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paymentIntent = new Intent(MainActivity.this, PaymentActivity.class);
                startActivity(paymentIntent);
            }
        });
    }
}
