package com.example.mytrace.Application.Registeration;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.Application.Login.Forget_password;
import com.example.mytrace.Application.Login.Login;
import com.example.mytrace.Application.Login.Users;
import com.example.mytrace.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration_3 extends AppCompatActivity implements View.OnClickListener {
    Button   Register_btn;
    EditText Email_rg,Passport_rg,FullName_rg,Age_rg,Password_rg,State_rg;
    TextView NvToLogin;
    private ProgressBar progressBar;


    private FirebaseAuth firebaseAuth;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_3);


        firebaseAuth = FirebaseAuth.getInstance();

        Email_rg = findViewById(R.id.Email_rg);
        Passport_rg  = findViewById(R.id.Passport_rg);
        FullName_rg  = findViewById(R.id.email_reset);
        Age_rg  = findViewById(R.id.Age_rg);
        Password_rg  = findViewById(R.id.Password_rg);
        State_rg  = findViewById(R.id.State_rg);

        NvToLogin  = findViewById(R.id.NvToLogin);
        NvToLogin.setOnClickListener(this);

        Register_btn= findViewById(R.id.Register_btn);
        Register_btn.setOnClickListener(this);

        progressBar =findViewById(R.id.progressBar);


    }
    // Registration Intent to get to registration page
/*
    public void openRegistration_4() {
        Intent intent = new Intent(Registration_3.this, Registration_4.class);
        startActivity(intent);
    }
*/

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.NvToLogin:
                startActivity(new Intent(this,Login.class));
                break;
            case R.id.Register_btn:
                Register_btn();
                break;

        }
    }

    private void Register_btn() {

        String email = Email_rg.getText().toString();
        String password = Password_rg.getText().toString();
        String passport = Passport_rg.getText().toString();
        String fullName = FullName_rg.getText().toString();
        String age =Age_rg.getText().toString();
        String state =State_rg.getText().toString();



        if(fullName.isEmpty()){
            FullName_rg.setError("Full Name  is required ! ");
            FullName_rg.requestFocus();
            return;
        }
        if(passport.isEmpty()){
            Passport_rg.setError("Passport id  is required ! ");
            Passport_rg.requestFocus();
            return;
        }
        if(age.isEmpty()){
            Age_rg.setError("Age is required ! ");
            Age_rg.requestFocus();
            return;
        }
        if(state.isEmpty()){
            State_rg.setError("State is required ! ");
            State_rg.requestFocus();
            return;
        }
        if(email.isEmpty()){
            Email_rg.setError("Email is required ! ");
            Email_rg.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            Email_rg.setError("Please provide valid email!");
            Email_rg.requestFocus();
            return;
        }

        if(password.isEmpty()){
            Password_rg.setError("Password  is required ! ");
            Password_rg.requestFocus();
            return;
        }

        if(password.length()<6){
            Password_rg.setError("Min Password length should be 6 characters ");
            Password_rg.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Users user = new Users(fullName, age, email);

                                 FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if (task.isSuccessful()) {
                                                Toast.makeText(Registration_3.this, "User has been registered successfully! ", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                                Intent intent4 = new Intent(Registration_3.this, Login.class);
                                                startActivity(intent4);

                                            } else {
                                                Toast.makeText(Registration_3.this, "Failed to register ! try again", Toast.LENGTH_SHORT).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        }else{

                            Toast.makeText(Registration_3.this, "Failed to register !try again", Toast.LENGTH_SHORT).show();
                           progressBar.setVisibility(View.GONE);

                        }

                    }
                });
    }
}
