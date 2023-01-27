package com.example.mytrace.Application.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytrace.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_password extends AppCompatActivity {


    private EditText emailEditText;
    private Button restPasswordButton;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        emailEditText = findViewById(R.id.email_reset);
        restPasswordButton=findViewById(R.id.reset_button);

        auth=FirebaseAuth.getInstance();


        restPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

    }

    private void resetPassword(){
        String email=emailEditText.getText().toString().trim();

        if (email.isEmpty()){

            emailEditText.setError("email is required");
            emailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            emailEditText.setError("Please provide a valid email ");
            emailEditText.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Forget_password.this,"check your email to reset your password ",Toast.LENGTH_LONG).show();
                    Intent intent4 = new Intent(Forget_password.this, Login.class);
                    startActivity(intent4);
                    
                }else {
                    Toast.makeText(Forget_password.this, "Try again ! somthing wrong happened ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
