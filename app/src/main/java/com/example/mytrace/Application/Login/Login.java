package com.example.mytrace.Application.Login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.mytrace.Application.Home_Page.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mytrace.Application.Registeration.Registration_1;
import com.example.mytrace.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;


public class Login extends AppCompatActivity {
EditText email , password;
Button btn_login, btn_register;
Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        btn_register =(Button) findViewById(R.id.btn_register);
                email=(EditText) findViewById(R.id.email);
             password=(EditText) findViewById(R.id.password);
            btn_login=(Button) findViewById(R.id.btn_login);
              spinner=(Spinner) findViewById(R.id.spinner);



        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.usertype, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item  );

        spinner.setAdapter(adapter);

        btn_login.setOnClickListener(new View.OnClickListener() {


                        // this is for using spinner for usertype
                        @Override
                        public void onClick(View v) {

                           String item= spinner.getSelectedItem().toString();
                            if(email.getText().toString().equals("1234567")&&password.getText().toString().equals("12345")&&item.equals("admin")){

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

            /*
                // Login button to get to Admin homepage
                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openAdmin_homepage();
                    }
                });
            */
                // Registration button to get to registration page
                btn_register.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Login.this, Registration_1.class));
                    }

                });
            }


            // Registration Intent to get to registration page
            public void openRegistration_1() {

                Intent intent3 = new Intent(Login.this, Registration_1.class);
                startActivity(intent3);
            }
/*
            // Login Intent to get to Admin homepage
            public void openAdmin_homepage() {

                Intent intent4 = new Intent(Login.this, Admin_homepage.class);
                startActivity(intent4);
            }
*/

}


