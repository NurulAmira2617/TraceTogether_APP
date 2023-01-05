package com.example.mytrace.Application.Dependent;

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
        //testtttt 123
        // this Listener to get to Dependet Details page
        Add_Depen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Add_Dependent.this, DependentPage.class));
            }
        });
    }
    // this Intent to get to Dependet Details  page
    public void openDependent_Details() {
        Intent intent3 = new Intent(Add_Dependent.this, DependentPage.class);
        startActivity(intent3);
    }

}

