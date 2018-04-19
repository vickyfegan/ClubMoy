package com.example.declan.clubmoy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookingFacilities extends AppCompatActivity {

    EditText nameFacilities, facilitiesDate, facilitiesTime;
    Spinner facilitiesOptions;
    Button bookFacilities;

    DatabaseReference databaseFacilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_facilities);

        databaseFacilities = FirebaseDatabase.getInstance().getReference("facilities");

        nameFacilities = (EditText) findViewById(R.id.nameFacilities);
        facilitiesDate = (EditText) findViewById(R.id.facilitiesDate);
        facilitiesTime = (EditText) findViewById(R.id.facilitiesTime);
        facilitiesOptions = (Spinner) findViewById(R.id.facilitiesOptions);
        bookFacilities = (Button) findViewById(R.id.bookFacilities);

        bookFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    bookFacility();
            }
        });

    }

    private void bookFacility()
    {
        String name = nameFacilities.getText().toString().trim();
        String facilities = facilitiesOptions.getSelectedItem().toString();
        String date = facilitiesDate.getText().toString().trim();
        String time = facilitiesTime.getText().toString().trim();

        if(!TextUtils.isEmpty(name))
        {
            String id = databaseFacilities.push().getKey();

            Facility facility = new Facility(id, name, facilities, date, time);

            databaseFacilities.child(id).setValue(facility);

            Toast.makeText(this, "Booking Confirmed", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
        }
    }
}
