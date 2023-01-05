package com.example.mytrace.Application.Dependent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.R;

public class Add_Dependent extends AppCompatActivity {

Button Add_Depen_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dependent);
        Add_Depen_button=(Button)findViewById(R.id.Add_Depen_button) ;
        //testtttt 12345
        // this Listener to get to Dependet Details page
        Add_Depen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Add_Dependent.this);
                alertDialogBuilder.setTitle("Confirmation");

                alertDialogBuilder.setMessage("Are you sure want to delete")
                                .setCancelable(false)
                                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                startActivity(new Intent(Add_Dependent.this, DependentPage.class));
                                            }
                                        }).setNegativeButton("no", new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                //startActivity(new Intent(Add_Dependent.this, DependentPage.class));

            }
        });
    }
    // this Intent to get to Dependet Details  page
    public void openDependent_Details() {
        Intent intent3 = new Intent(Add_Dependent.this, DependentPage.class);
        startActivity(intent3);
    }

}

