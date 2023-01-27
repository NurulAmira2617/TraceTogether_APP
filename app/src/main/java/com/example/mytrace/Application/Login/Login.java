package com.example.mytrace.Application.Login;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mytrace.Application.Home_Page.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mytrace.Application.Registeration.Registration_1;
import com.example.mytrace.Application.Registeration.Registration_3;
import com.example.mytrace.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity implements View.OnClickListener{
EditText email , password;
TextView ForgotPassowrdBt;
Button btn_login, btn_register;
Spinner spinner;
FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        mAuth = FirebaseAuth.getInstance();



        btn_register =(Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);

        btn_login=(Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        ForgotPassowrdBt=findViewById(R.id.ForgotPassowrdBt);
        ForgotPassowrdBt.setOnClickListener(this);

        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        spinner=(Spinner) findViewById(R.id.spinner);

           /*
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.usertype, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item  );
        spinner.setAdapter(adapter);

        btn_login.setOnClickListener(new View.OnClickListener() {


                        // this is for using spinner for usertype
                        @Override
                        public void onClick(View v) {

                            FirebaseUser user = mAuth.getCurrentUser(); // Added this new line for the firebase auth

                           String item= spinner.getSelectedItem().toString();

                            if(email.getText().toString().equals("1234")&&password.getText().toString().equals("1234")&&item.equals("Admin")){

                                 Intent intent1=new Intent(Login.this,Admin_homepage.class);
                                 startActivity(intent1);

                            }else if(email.getText().toString().equals("1234")&&password.getText().toString().equals("1234")&&item.equals("user")){

                                Intent intent2=new Intent(Login.this,User_homepage.class);
                                startActivity(intent2);

                            }else if(email.getText().toString().equals("1234")&&password.getText().toString().equals("MOH")&&item.equals("MOH-User")){

                                Intent intent3=new Intent(Login.this,MOH_homepage.class);
                                startActivity(intent3);

                            }
                            else{
                                Toast.makeText(getApplicationContext(),"(Please select userType)",Toast.LENGTH_LONG).show();
                            }

                        }
                    });


                // Login button to get to Admin homepage
                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openAdmin_homepage();
                    }
                });

                // Registration button to get to registration page
        ForgotPassowrdBt.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Login.this, Registration_3.class));
                    }

                });
*/

            }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_register:
                startActivity(new Intent(Login.this,Registration_3.class));
                break;
            case R.id.ForgotPassowrdBt:
               startActivity(new Intent(this,Forget_password.class));
                break;
            case R.id.btn_login:
                UserLogin();
                break;
        }

    }

    private void UserLogin() {

        String Email= email.getText().toString().trim();
        String Password=password.getText().toString().trim();

        if(Email.isEmpty()){
            email.setError("email is required !");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("Please enter a valid email!");
            email.requestFocus();
            return;
        }
        if(Password.isEmpty()){
            password.setError("Password is required !");
            password.requestFocus();
            return;
        }
        if(Password.length()<6){
            password.setError("Min password length is 6 characters !");
            password.requestFocus();
            return;
        }

       mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {

               if(task.isSuccessful()){
                   startActivity(new Intent(Login.this,User_homepage.class));

               }else{
                   Toast.makeText(Login.this,"Failed to login !Please check your credentials ", Toast.LENGTH_LONG).show();
               }
           }
       });

    }

            // Login Intent to get to Registration page
            public void openRegistration3() {

                Intent intent4 = new Intent(Login.this, Forget_password.class);
                startActivity(intent4);
            }


}


