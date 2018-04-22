package com.example.declan.clubmoy.Payments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.declan.clubmoy.Booking.BookingFacilities;
import com.example.declan.clubmoy.Booking.Calendar;
import com.example.declan.clubmoy.Homepage;
import com.example.declan.clubmoy.Logout;
import com.example.declan.clubmoy.R;
import com.example.declan.clubmoy.Sponsors;
import com.example.declan.clubmoy.YoutubePage.YoutubeVideo;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class PaymentDetails extends AppCompatActivity {

    TextView txtId, txtAmount, txtStatus;

    ImageView homePage, moneyImage, bookingFacImage, sponsorToolbar, youtubeToolbar, footballToolbar, calendarToolbar, logoutToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
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
                Intent i = new Intent(PaymentDetails.this, Homepage.class);
                startActivity(i);
            }
        });

        moneyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentDetails.this, Paypal.class);
                startActivity(i);
            }
        });
        bookingFacImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentDetails.this, BookingFacilities.class);
                startActivity(i);
            }
        });

        sponsorToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentDetails.this, Sponsors.class);
                startActivity(i);
            }
        });

        youtubeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentDetails.this, YoutubeVideo.class);
                startActivity(i);
            }
        });
       /* footballToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentDetails.this, Training.class);
                startActivity(i);
            }
        });*/
        calendarToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentDetails.this, Calendar.class);
                startActivity(i);
            }
        });
        logoutToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentDetails.this, Logout.class);
                startActivity(i);
            }
        });


        txtId = (TextView)findViewById(R.id.txtId);
        txtAmount = (TextView)findViewById(R.id.txtAmount);
        txtStatus = (TextView)findViewById(R.id.txtStatus);

        //Get intent
        Intent intent = getIntent();

        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("Payment Details"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void showDetails(JSONObject response, String paymentAmount) {

        try {
            txtId.setText(response.getString("id"));
            txtAmount.setText("£"+paymentAmount);
            txtStatus.setText(response.getString("state"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
