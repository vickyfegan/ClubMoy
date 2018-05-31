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

public class Login extends AppCompatActivity implements View.OnClickListener{

   // https://www.youtube.com/watch?v=0NFwF7L-YA8

    private Button login;
    private EditText signInEmail;
    private EditText signInPassword;
    private TextView signUpPage;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        signInEmail = (EditText) findViewById(R.id.signInEmail);
        signInPassword = (EditText) findViewById(R.id.signInPassword);
        login = (Button) findViewById(R.id.login);
        signUpPage = (TextView) findViewById(R.id.signUpPage);

        login.setOnClickListener(this);
        signUpPage.setOnClickListener(this);

    }

    private void userLogin()
    {
        String email = signInEmail.getText().toString().trim();
        String password = signInPassword.getText().toString().trim();

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
        progressDialog.setMessage("Signing In");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Sign In Complete", Toast.LENGTH_SHORT).show();
                            Intent homepage = new Intent(Login.this, Homepage.class);
                            startActivity(homepage);
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Sign In Unsuccessful", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


    @Override
    public void onClick(View v) {

        if(v == login)
        {
            userLogin();
        }

        if (v == signUpPage)
        {
           finish();
           startActivity(new Intent(this, Registration.class));
        }

    }
}
