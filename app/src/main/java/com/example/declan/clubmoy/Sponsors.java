package com.example.declan.clubmoy;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.declan.clubmoy.Booking.BookingFacilities;
import com.example.declan.clubmoy.Booking.Calendar;
import com.example.declan.clubmoy.Payments.Paypal;
import com.example.declan.clubmoy.YoutubePage.YoutubeVideo;

public class Sponsors extends AppCompatActivity {

    ImageView macavoySponsor, seanSponsor, moymSponsor, moyaSponsor, lynasSponsor, westlandSponsor;
    ImageView homePage, moneyImage, bookingFacImage, sponsorToolbar, youtubeToolbar, footballToolbar, calendarToolbar, logoutToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);

        macavoySponsor = (ImageView)findViewById(R.id.macavoySponsor);
        seanSponsor = (ImageView)findViewById(R.id.seanSponsor);
        moymSponsor = (ImageView)findViewById(R.id.moymSponsor);
        moyaSponsor = (ImageView)findViewById(R.id.moyaSponsor);
        lynasSponsor = (ImageView)findViewById(R.id.lynasSponsor);
        westlandSponsor = (ImageView)findViewById(R.id.westlandSponsor);

        macavoySponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.mcavoygroup.com"));
                startActivity(intent);
            }
        });

        seanSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://seancavanaghandco.com"));
                startActivity(intent);
            }
        });

        moymSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.moywaymotors.co.uk"));
                startActivity(intent);
            }
        });

        moyaSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.moyautoservices.com"));
                startActivity(intent);
            }
        });

        lynasSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://lynasfoodservice.com"));
                startActivity(intent);
            }
        });

        westlandSponsor.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.gardenhealth.com"));
                startActivity(intent);
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
                Intent i = new Intent(Sponsors.this, Homepage.class);
                startActivity(i);
            }
        });

        moneyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sponsors.this, Paypal.class);
                startActivity(i);
            }
        });
        bookingFacImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sponsors.this, BookingFacilities.class);
                startActivity(i);
            }
        });

        sponsorToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sponsors.this, Sponsors.class);
                startActivity(i);
            }
        });

        youtubeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sponsors.this, YoutubeVideo.class);
                startActivity(i);
            }
        });
       /* footballToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sponsors.this, Training.class);
                startActivity(i);
            }
        });*/
        calendarToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sponsors.this, Calendar.class);
                startActivity(i);
            }
        });
       /* logoutToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Sponsors.this, Logout.class);
                startActivity(i);
            }
        });*/


    }
}

