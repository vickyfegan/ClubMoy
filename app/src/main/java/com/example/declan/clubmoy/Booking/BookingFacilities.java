package com.example.declan.clubmoy.Booking;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.declan.clubmoy.R;
import com.example.declan.clubmoy.SaveData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//https://www.youtube.com/watch?v=aCDgP2By1J0

public class BookingFacilities extends AppCompatActivity {

    private EditText fName, fDate, fTime;
    private Spinner facOptions;
    private Button bookFac;
    private ProgressDialog progressDialog;

    DatabaseReference databaseReference;

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
