package com.example.declan.clubmoy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;

//https://www.youtube.com/watch?v=aJ7BoNG-r2c
//https://www.youtube.com/watch?v=3LiubyYpEUk

public class YoutubeVideo extends YouTubeBaseActivity
{

    YouTubePlayerView youTubePlayerView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_video);
        button = (Button) findViewById(R.id.playVideo);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener()
        {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            youTubePlayer.loadVideo("Oe2QWwCJTYw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
            }
        });



    }
}
