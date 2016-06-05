package com.gdg.aman.umyhacker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.Window;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.PlayerStyle;

public class VideoScreen extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    // YouTube player view
    private YouTubePlayerView youTubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_screen);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        // Initializing video player with developer key
        youTubeView.initialize(Config.DEVELOPER_KEY, this);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored)
    {

      /*  *//** add listeners to YouTubePlayer instance **//*
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);*/
        /*player.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);*/

        if (!wasRestored)
        {

            String path1 = getIntent().getStringExtra("cmd_type");
            String path2 = getIntent().getStringExtra("first_type_networking");
            String path3 = getIntent().getStringExtra("second_type_networking");
            String path4 = getIntent().getStringExtra("third_type_networking");
            String path5 = getIntent().getStringExtra("fourth_type_networking");

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            if (path1 != "")
            {
                player.loadVideo(Config.CMD_TUTORIAL);
                player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
            }
            if (path2 != "")
            {
                player.loadVideo(Config.NETWORKING_TUTORIAL_VPN);
                player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
            }
            if (path3 != "")
            {
                player.loadVideo(Config.NETWORKING_TUTORIAL_BLOCKED_SITES_VPN);
                player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
            }
            if (path4 != "")
            {
                player.loadVideo(Config.NETWORKING_TUTORIAL_BANDWIDTH_NETWORKING);
                player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
            }
            if (path5 != "")
            {
                player.loadVideo(Config.NETWORKING_TUTORIAL_TCP_VS_UDP);
                player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
            }

            // Hiding player controls
            player.setPlayerStyle(YouTubePlayer.PlayerStyle.CHROMELESS);
        }
    }

/*
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST)
        {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.DEVELOPER_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
}
