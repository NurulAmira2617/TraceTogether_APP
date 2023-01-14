package com.example.mytrace.Application.Dependent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.R;

public class Add_Dependent extends AppCompatActivity {

Button Add_Depen_button;
Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dependent);
        Add_Depen_button=(Button)findViewById(R.id.Add_Depen_button) ;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        spinner=(Spinner) findViewById(R.id.spinner2);



        // this Listener to get to Dependent Details page
        Add_Depen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                builder.setMessage("Do you want to add this dependent ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Dependent has been added",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Add_Dependent.this, DependentPage.class));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Add New Dependent Cancel",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Add Dependent");
                alert.show();
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Add_Dependent.this);
//                alertDialogBuilder.setTitle("Confirmation");
//
//                alertDialogBuilder.setMessage("Are You Sure Want to Add New Dependent")
//                                .setCancelable(false)
//                                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialog, int which) {
//                                                startActivity(new Intent(Add_Dependent.this, DependentPage.class));
//                                            }
//                                        }).setNegativeButton("no", new DialogInterface.OnClickListener(){
//
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.cancel();
//                            }
//                        });
                //startActivity(new Intent(Add_Dependent.this, DependentPage.class));

            }
        });
    }
    // this Intent to get to Dependent Details  page
    public void openDependent_Details() {
        Intent intent3 = new Intent(Add_Dependent.this, DependentPage.class);
        startActivity(intent3);
    }

}

