package com.example.android.musicalstructure;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by juan on 14/08/17.
 */

public class MusicPlayer {

    /** The song currently being played **/
    private Song mCurrentSong;

    /** The estatus of the music payer (stopped, paused, playing) **/
    private int mStatus;

    public static final int STATUS_PAUSED = 2;

    public static final int STATUS_PLAYING = 1;

    public static final int STATUS_STOPPED = 0;

    /** Single instance of the music player **/
    private static final MusicPlayer ourInstance = new MusicPlayer();

    /**
     * @return singleton instance of the music player.
     */
    public static MusicPlayer getInstance() {
        return ourInstance;
    }

    /**
     * Private constructor.
     */
    private MusicPlayer() {
        mCurrentSong = null;
    }

    /**
     * @return song currently being played.
     */
    public Song getCurrentSong() {
        return mCurrentSong;
    }

    /**
     * Set the song currently being played.
     * @param song
     */
    public void setCurrentSong(Song song) {
        this.mCurrentSong = song;
    }

    /**
     * @return the title of the song currently being played.
     */
    public String getCurrentTitle() {
        if(mCurrentSong == null)
            return null;

        return mCurrentSong.getTitle();
    }

    /**
     * @return the status of the music player.
     */
    public int getStatus() {
        return mStatus;
    }

    /**
     * Set the status of the music player.
     * @param status
     */
    public void setStatus(int status) {
        this.mStatus = status;
    }

    /**
     * @return whether or not the music player is playing a song.
     */
    public boolean isPlaying() {
        return getStatus() == STATUS_PLAYING;
    }

    /**
     * @return whether or not the music player is paused.
     */
    public boolean isPaused() {
        return getStatus() == STATUS_PAUSED;
    }

    /**
     * @return whether or not the music player is stopped.
     */
    public boolean isStopped() {
        return getStatus() == STATUS_STOPPED;
    }

    public void toggleStatus() {
        if (isPlaying()) {
            mStatus = STATUS_PAUSED;
            return;
        }
        mStatus = STATUS_PLAYING;
    }

    /**
     * Updates the "Now Playing" view.
     */
    public void updateNowPlayingStatus(Activity context) {

        if(getCurrentSong() != null) {
            // set the title
            TextView nowPlayingText = context.findViewById(R.id.nowPlayingTitle);
            nowPlayingText.setText(getCurrentTitle());


            // set the icon depending on the status
            ImageView nowPlayingStatus = context.findViewById(R.id.nowPlayingStatus);
            if(isPlaying())
                nowPlayingStatus.setImageResource(R.drawable.ic_pause_circle_outline);
            else if(isPaused())
                nowPlayingStatus.setImageResource(R.drawable.ic_play_circle_outline);

            // show the view if there's a song paused/playing
            setNowPlayingVisibility(View.VISIBLE, context);
        }else{
            // remove the view if there's no song paused/playing
            setNowPlayingVisibility(View.GONE, context);
        }
    }

    private void setNowPlayingVisibility(int visibility, Activity context) {
        LinearLayout nowPlayingLayout = context.findViewById(R.id.nowPlayingView);
        nowPlayingLayout.setVisibility(visibility);
    }

}
