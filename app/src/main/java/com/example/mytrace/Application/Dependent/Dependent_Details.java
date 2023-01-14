package com.example.mytrace.Application.Dependent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.R;

public class Dependent_Details extends AppCompatActivity {
     Button save_dependent;

     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.dependent_details);
          save_dependent =(Button) findViewById(R.id.button8);

          AlertDialog.Builder builder = new AlertDialog.Builder(this);

          save_dependent.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                    builder.setMessage("Do you want to save dependent new informations?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                 public void onClick(DialogInterface dialog, int id) {
                                      finish();
                                      Toast.makeText(getApplicationContext(),"Informtion has been saved",
                                              Toast.LENGTH_SHORT).show();
                                      startActivity(new Intent(Dependent_Details.this, DependentPage.class));
                                 }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                 public void onClick(DialogInterface dialog, int id) {
                                      //  Action for 'NO' Button
                                      dialog.cancel();
                                      Toast.makeText(getApplicationContext(),"Cancel",
                                              Toast.LENGTH_SHORT).show();
                                 }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Edit Dependent");
                    alert.show();

               }
          });

     }
}