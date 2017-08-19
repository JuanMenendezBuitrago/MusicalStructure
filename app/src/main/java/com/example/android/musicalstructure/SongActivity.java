package com.example.android.musicalstructure;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    /** The music player singleton **/
    MusicPlayer musicPlayer = MusicPlayer.getInstance();

    /** The activity's description **/
    String mDescription = "This is the details for the chosen song ";

    /** song object **/
    private Song mSong;

    /** the image button for playing and pausing the song **/
    private ImageButton mPlayPauseButton;

    /**
     * onCreate event handler.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        showDescription();
        insertPlayPauseButton();
        musicPlayer.updateNowPlayingStatus(this);
    }

    /**
     * Show the description with the song title and length.
     */
    private void showDescription() {
        // compose and set description text.
        mSong = (Song) getIntent().getSerializableExtra("song");
        String songTitle = mSong.getTitle();
        mDescription += "\nTitle: " + songTitle;
        String songLength = mSong.getLengthFormatted();
        mDescription += "\nLength: " + songLength;
        ((TextView)findViewById(R.id.descriptionText)).setText(mDescription);
    }

    /**
     * Inserts the play/pause ImageButton and attach the click event handler.
     */
    private void insertPlayPauseButton() {
        // create ImageButton element
        mPlayPauseButton = new ImageButton(this);
        mPlayPauseButton.setBackgroundColor(Color.TRANSPARENT);
        mPlayPauseButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        mPlayPauseButton.setAdjustViewBounds(true);
        mPlayPauseButton.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        getPixels(100))
        );

        // set click handler
        mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("SongActivity","clicked");
                updateMusicPlayerStatus();
                musicPlayer.updateNowPlayingStatus(SongActivity.this);
            }
        });

        LinearLayout list = (LinearLayout) findViewById(R.id.listView);
        renderPlayButton();
        list.addView(mPlayPauseButton);
    }

    /**
     * Update the status of the music player, set the current song and updates the play/pause button.
     */
    private void updateMusicPlayerStatus() {
        if(musicPlayer.getCurrentSong() == null || !musicPlayer.getCurrentSong().equals(mSong))
            musicPlayer.setStatus(MusicPlayer.STATUS_PLAYING);
        else
            musicPlayer.toggleStatus();

        musicPlayer.setCurrentSong(mSong);
        renderPlayButton();
    }

    /**
     * Renders the play/pause button depending on  the data in the music player.
     */
    private void renderPlayButton(){
        if(musicPlayer.getCurrentSong() == null || !musicPlayer.getCurrentSong().equals(mSong))
            mPlayPauseButton.setImageResource(R.drawable.ic_play_circle_outline);
        else if(musicPlayer.isPlaying())
            mPlayPauseButton.setImageResource(R.drawable.ic_pause_circle_outline);
        else {
            mPlayPauseButton.setImageResource(R.drawable.ic_play_circle_outline);
        }
    }

    /**
     * Turn dp to px (used by setLayoutParams).
     * @param dipValue
     * @return
     */
    private int getPixels(int dipValue) {
        Resources r = getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dipValue,
                r.getDisplayMetrics());
    }
}
