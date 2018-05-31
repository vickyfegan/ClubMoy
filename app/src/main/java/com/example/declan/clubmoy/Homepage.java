package com.example.declan.clubmoy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.declan.clubmoy.Authentication.Logout;
import com.example.declan.clubmoy.Booking.BookingFacilities;
import com.example.declan.clubmoy.Booking.Calendar;
import com.example.declan.clubmoy.Match_Training_Info.Training;
import com.example.declan.clubmoy.Payments.Paypal;
import com.example.declan.clubmoy.YoutubePage.YoutubeVideo;

public class Homepage extends AppCompatActivity {

    ViewFlipper v_flipper;
    ImageView bookingImage, moneyImage, calendarImage, football, logoutHp, youtubeImage, sponsorImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        bookingImage = (ImageView)findViewById(R.id.bookingImage);
        moneyImage = (ImageView)findViewById(R.id.moneyImage);
        calendarImage = (ImageView)findViewById(R.id.calendarImage);
        football = (ImageView)findViewById(R.id.football);
        logoutHp = (ImageView)findViewById(R.id.logoutHp);
        youtubeImage = (ImageView)findViewById(R.id.youtubeImage);
        sponsorImage = (ImageView)findViewById(R.id.sponsorImage);

        bookingImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, BookingFacilities.class);
                startActivity(i);
            }
        });

        moneyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, Paypal.class);
                startActivity(i);
            }
        });

        calendarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, Calendar.class);
                startActivity(i);
            }
        });


        youtubeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, YoutubeVideo.class);
                startActivity(i);
            }
        });
        sponsorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, Sponsors.class);
                startActivity(i);
            }
        });

       football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, Training.class);
                startActivity(i);
            }
        });

        logoutHp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Homepage.this, Logout.class);
                startActivity(i);
            }
        });


        int images[] = {R.drawable.carrickmore, R.drawable.parhall, R.drawable.crokepark, R.drawable.gaeltacht, R.drawable.semifinal, R.drawable.tyrone};

        v_flipper = findViewById(R.id.v_flipper);

        for(int image: images)
        {
            flipperImages(image);
        }
    }

    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000); //4Seconds
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }



}
