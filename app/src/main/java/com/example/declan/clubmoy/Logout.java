package com.example.declan.clubmoy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.declan.clubmoy.Authentication.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Logout extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    ImageView logoutLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        mAuth = FirebaseAuth.getInstance();

        logoutLogout = (ImageView) findViewById(R.id.logoutLogout);

        logoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                {
                    Toast.makeText(Logout.this, "Sign In Complete", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(Logout.this, Login.class);
                    startActivity(login);
                }
            }
        });

    }
}
