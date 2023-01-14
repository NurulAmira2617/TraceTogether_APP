package com.example.mytrace.Application.Dependent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.Application.Profile.Change_Password;
import com.example.mytrace.Application.Profile.UserProfile;
import com.example.mytrace.Application.Profile.User_Details;
import com.example.mytrace.R;

public class DependentPage extends AppCompatActivity {

    ImageView edit_depen;
    ImageView imageView2;
    Button Add_new_Depen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dependent_page);

        edit_depen =(ImageView) findViewById(R.id.edit_depen);
        imageView2 =(ImageView) findViewById(R.id.imageView2);
        Add_new_Depen =(Button) findViewById(R.id.Add_new_Depen);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // this Listener to get to Dependet Details page
        edit_depen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DependentPage.this, Dependent_Details.class));
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Do you want to delete this dependent ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Toast.makeText(getApplicationContext(),"Dependent has been deleted",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DependentPage.this, DependentPage.class));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"Deleted Cancel",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Delete Dependent");
                alert.show();

            }
        });

        // this listener to get to Add dependent page
        Add_new_Depen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DependentPage.this, Add_Dependent.class));
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DependentPage.this);
                alertDialogBuilder.setTitle("Confirmation");

                alertDialogBuilder.setMessage("Are you sure want to delete")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //startActivity(new Intent(Add_Dependent.this, DependentPage.class));
                            }
                        }).setNegativeButton("no", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
            }
        });
    }


    // this Intent to get to Dependet Details  page
    public void openDependent_Details() {
        Intent intent3 = new Intent(DependentPage.this, Dependent_Details.class);
        startActivity(intent3);
    }

    // this Intent to get to Add_Dependent  page
    public void openAdd_Dependent() {
        Intent intent3 = new Intent(DependentPage.this, Add_Dependent.class);
        startActivity(intent3);
    }
}

