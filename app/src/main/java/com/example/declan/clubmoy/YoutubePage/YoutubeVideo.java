package com.example.declan.clubmoy.YoutubePage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.declan.clubmoy.Booking.BookingFacilities;
import com.example.declan.clubmoy.Booking.Calendar;
import com.example.declan.clubmoy.Homepage;
import com.example.declan.clubmoy.Logout;
import com.example.declan.clubmoy.Payments.Paypal;
import com.example.declan.clubmoy.R;
import com.example.declan.clubmoy.Sponsors;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

//https://www.youtube.com/watch?v=aJ7BoNG-r2c
//https://www.youtube.com/watch?v=3LiubyYpEUk

public class YoutubeVideo extends YouTubeBaseActivity
{

    ImageView homePage, moneyImage, bookingFacImage, sponsorToolbar, youtubeToolbar, footballToolbar, calendarToolbar, logoutToolbar;
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

        homePage = (ImageView) findViewById(R.id.homePage);
        moneyImage = (ImageView) findViewById(R.id.moneyImage);
        bookingFacImage = (ImageView) findViewById(R.id.bookingFacImage);
        sponsorToolbar = (ImageView) findViewById(R.id.sponsorToolbar);
        youtubeToolbar = (ImageView) findViewById(R.id.youtubeToolbar);
        footballToolbar = (ImageView) findViewById(R.id.footballToolbar);
        calendarToolbar = (ImageView) findViewById(R.id.calendarToolbar);
        logoutToolbar = (ImageView) findViewById(R.id.logoutToolbar);

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YoutubeVideo.this, Homepage.class);
                startActivity(i);
            }
        });

        moneyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YoutubeVideo.this, Paypal.class);
                startActivity(i);
            }
        });
        bookingFacImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YoutubeVideo.this, BookingFacilities.class);
                startActivity(i);
            }
        });

        sponsorToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YoutubeVideo.this, Sponsors.class);
                startActivity(i);
            }
        });

        youtubeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YoutubeVideo.this, YoutubeVideo.class);
                startActivity(i);
            }
        });
       /* footballToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Youtube.this, Training.class);
                startActivity(i);
            }
        });*/
        calendarToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YoutubeVideo.this, Calendar.class);
                startActivity(i);
            }
        });
        logoutToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(YoutubeVideo.this, Logout.class);
                startActivity(i);
            }
        });




    }
}
