package com.example.declan.clubmoy.Payments;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.declan.clubmoy.Booking.BookingFacilities;
import com.example.declan.clubmoy.Booking.Calendar;
import com.example.declan.clubmoy.Homepage;
import com.example.declan.clubmoy.Logout;
import com.example.declan.clubmoy.R;
import com.example.declan.clubmoy.Sponsors;
import com.example.declan.clubmoy.Match_Training_Info.Training;
import com.example.declan.clubmoy.YoutubePage.YoutubeVideo;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class Paypal extends AppCompatActivity {

    ImageView homePage, moneyImage, bookingFacImage, sponsorToolbar, youtubeToolbar, footballToolbar, calendarToolbar, logoutToolbar;

    public static final int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration config = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX) //Test accounts
            .clientId(Config.PAYPAL_CLIENT_ID);

    Button btnPayNow;
    EditText edtAmount;

    String amount="";

    @Override
    protected void onDestroy()
    {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);

        //Start Paypal Service
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);


        btnPayNow = (Button)findViewById(R.id.btnPayNow);
        edtAmount = (EditText)findViewById(R.id.edtAmount);
        homePage = (ImageView) findViewById(R.id.homePage);
        moneyImage = (ImageView) findViewById(R.id.moneyImage);
        bookingFacImage = (ImageView) findViewById(R.id.bookingFacImage);
        sponsorToolbar = (ImageView) findViewById(R.id.sponsorToolbar);
        youtubeToolbar = (ImageView) findViewById(R.id.youtubeToolbar);
        footballToolbar = (ImageView) findViewById(R.id.footballToolbar);
        calendarToolbar = (ImageView) findViewById(R.id.calendarToolbar);
        logoutToolbar = (ImageView) findViewById(R.id.logoutToolbar);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, Homepage.class);
                startActivity(i);
            }
        });

        moneyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, Paypal.class);
                startActivity(i);
            }
        });
        bookingFacImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, BookingFacilities.class);
                startActivity(i);
            }
        });

        sponsorToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, Sponsors.class);
                startActivity(i);
            }
        });

        youtubeToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, YoutubeVideo.class);
                startActivity(i);
            }
        });
       footballToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, Training.class);
                startActivity(i);
            }
        });
        calendarToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, Calendar.class);
                startActivity(i);
            }
        });
        logoutToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Paypal.this, Logout.class);
                startActivity(i);
            }
        });

    }

    private void processPayment() {

        amount = edtAmount.getText().toString();
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)), "GBP",
                "Pay Club Membership for 2018", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PAYPAL_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if(confirmation != null)
                {
                    try{
                        String PaymentDetails = confirmation.toJSONObject().toString(4);

                        startActivity(new Intent(this, PaymentDetails.class)
                                .putExtra("PaymentDetails",PaymentDetails)
                                .putExtra("PaymentAmount",amount)
                        );

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        }
        else if(resultCode == PaymentActivity.RESULT_EXTRAS_INVALID);
        Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
    }
}
