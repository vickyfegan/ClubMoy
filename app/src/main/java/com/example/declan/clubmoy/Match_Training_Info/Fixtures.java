package com.example.declan.clubmoy.Match_Training_Info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.declan.clubmoy.Booking.BookingFacilities;
import com.example.declan.clubmoy.Booking.Calendar;
import com.example.declan.clubmoy.Homepage;
import com.example.declan.clubmoy.Logout;
import com.example.declan.clubmoy.Payments.Paypal;
import com.example.declan.clubmoy.R;
import com.example.declan.clubmoy.Sponsors;
import com.example.declan.clubmoy.YoutubePage.YoutubeVideo;

public class Fixtures extends AppCompatActivity {

    ImageView homePage, moneyImage, bookingFacImage, sponsorToolbar, youtubeToolbar, footballToolbar, calendarToolbar, logoutToolbar;
    ImageView trainingTimeFootball;
    ListView matchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        matchListView = (ListView) findViewById(R.id.matchListView);

        homePage = (ImageView) findViewById(R.id.homePage);
        moneyImage = (ImageView) findViewById(R.id.moneyImage);
        bookingFacImage = (ImageView) findViewById(R.id.bookingFacImage);
        sponsorToolbar = (ImageView) findViewById(R.id.sponsorToolbar);
        youtubeToolbar = (ImageView) findViewById(R.id.youtubeToolbar);
        footballToolbar = (ImageView) findViewById(R.id.footballToolbar);
        calendarToolbar = (ImageView) findViewById(R.id.calendarToolbar);
        logoutToolbar = (ImageView) findViewById(R.id.logoutToolbar);
        trainingTimeFootball = (ImageView) findViewById(R.id.matchFixturesFootball);

        trainingTimeFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, Training.class);
                startActivity(i);
            }
        });


        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, Homepage.class);
                startActivity(i);
            }
        });

        moneyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, Paypal.class);
                startActivity(i);
            }
        });
        bookingFacImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, BookingFacilities.class);
                startActivity(i);
            }
        });

        sponsorToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, Sponsors.class);
                startActivity(i);
            }
        });

        youtubeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, YoutubeVideo.class);
                startActivity(i);
            }
        });
        footballToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, Training.class);
                startActivity(i);
            }
        });
        calendarToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, Calendar.class);
                startActivity(i);
            }
        });
        logoutToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Fixtures.this, Logout.class);
                startActivity(i);
            }
        });
    }
}
