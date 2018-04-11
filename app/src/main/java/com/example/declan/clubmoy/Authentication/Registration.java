package com.example.declan.clubmoy.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.declan.clubmoy.Homepage;
import com.example.declan.clubmoy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity implements View.OnClickListener{

    private Button register;
    private EditText registerEmail;
    private EditText registerPassword;
    private TextView signIn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        register = (Button) findViewById(R.id.register);
        registerEmail = (EditText) findViewById(R.id.registerEmail);
        registerPassword = (EditText) findViewById(R.id.registerPassword);
        signIn = (TextView) findViewById(R.id.signIn);

        register.setOnClickListener(this);
        signIn.setOnClickListener(this);

    }

    private void registerUser()
    {
        String email = registerEmail.getText().toString().trim();
        String password = registerPassword.getText().toString().trim();


        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Email field is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Password field is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful())
                        {
                            Toast.makeText(Registration.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                            Intent homepage = new Intent(Registration.this, Homepage.class);
                            startActivity(homepage);
                        }
                        else
                        {
                            Toast.makeText(Registration.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if(view == register)
        {
            registerUser();
        }

        if(view == signIn)
        {
            //move to other page
            Intent signInPage = new Intent(Registration.this, Login.class);
            startActivity(signInPage);
        }
    }
}
