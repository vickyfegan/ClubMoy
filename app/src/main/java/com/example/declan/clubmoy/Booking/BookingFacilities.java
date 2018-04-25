package com.example.declan.clubmoy.Booking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.declan.clubmoy.Homepage;
import com.example.declan.clubmoy.Logout;
import com.example.declan.clubmoy.Payments.Paypal;
import com.example.declan.clubmoy.R;
import com.example.declan.clubmoy.Sponsors;
import com.example.declan.clubmoy.Match_Training_Info.Training;
import com.example.declan.clubmoy.YoutubePage.YoutubeVideo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//https://www.youtube.com/watch?v=aCDgP2By1J0

public class BookingFacilities extends AppCompatActivity {

    private EditText fName, fDate, fTime;
    private Spinner facOptions;
    private Button bookFac;
    private ProgressDialog progressDialog;

    DatabaseReference databaseReference;

    ImageView homePage, moneyImage, bookingFacImage, sponsorToolbar, youtubeToolbar, footballToolbar, calendarToolbar, logoutToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_facilities);

        fName = (EditText) findViewById(R.id.fName);
        fDate = (EditText) findViewById(R.id.fDate);
        fTime = (EditText) findViewById(R.id.fTime);
        facOptions = (Spinner) findViewById(R.id.facOptions);
        bookFac = (Button) findViewById(R.id.bookFac);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving your Booking...");

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Facilities");

        bookFac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddData();

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
                Intent i = new Intent(BookingFacilities.this, Homepage.class);
                startActivity(i);
            }
        });

        moneyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingFacilities.this, Paypal.class);
                startActivity(i);
            }
        });
        bookingFacImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingFacilities.this, BookingFacilities.class);
                startActivity(i);
            }
        });

        sponsorToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingFacilities.this, Sponsors.class);
                startActivity(i);
            }
        });

        youtubeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingFacilities.this, YoutubeVideo.class);
                startActivity(i);
            }
        });
       footballToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingFacilities.this, Training.class);
                startActivity(i);
            }
        });
        calendarToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingFacilities.this, Calendar.class);
                startActivity(i);
            }
        });
        logoutToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingFacilities.this, Logout.class);
                startActivity(i);
            }
        });


    }

    public void AddData()
    {
        String Name = fName.getText().toString().trim();
        String Date = fDate.getText().toString().trim();
        String Time = fTime.getText().toString().trim();
        String Options = facOptions.getSelectedItem().toString();

        progressDialog.show();

        SaveData saveData = new SaveData(Name, Date, Time, Options);


        databaseReference.push().setValue(saveData);
        progressDialog.dismiss();
        Toast.makeText(getApplication(), "Booking Confirmed", Toast.LENGTH_LONG).show();
    }


}
