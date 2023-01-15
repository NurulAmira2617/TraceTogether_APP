package com.example.mytrace.Application.Dependent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.R;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.ValueEventListener;


public class Add_Dependent extends AppCompatActivity {

    private EditText name, Relation, Gender;
    Button Add_Depen_button;
    Spinner citizen;
    //FirebaseFirestore firestore;
    //FirebaseDatabase database = FirebaseDatabase.getInstance();
   // DatabaseReference myRef = database.getReference("message");
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Add_dependent_Db addDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dependent);


        firebaseDatabase = FirebaseDatabase.getInstance();

        //databaseReference = firebaseDatabase.getReference("Add_dependent_Db");



        citizen=(Spinner)findViewById(R.id.citizen) ;
        Relation=(EditText) findViewById(R.id.Relation) ;
        name=(EditText) findViewById(R.id.name) ;
        Gender=(EditText) findViewById(R.id.Gender) ;
        Add_Depen_button=(Button)findViewById(R.id.Add_Depen_button) ;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Add_dependent_Db");
         addDb = new Add_dependent_Db();
        // this Listener to get to Dependent Details page
        Add_Depen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String relation = Relation.getText().toString();
                String gender = Gender.getText().toString();
                String Name = name.getText().toString();

                if (TextUtils.isEmpty(relation) && TextUtils.isEmpty(gender) && TextUtils.isEmpty(Name)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(Add_Dependent.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(Name, gender, relation);
                }


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
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Add_Dependent.this);
                alertDialogBuilder.setTitle("Confirmation");

                alertDialogBuilder.setMessage("Are You Sure Want to Add New Dependent")
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
    private void addDatatoFirebase(String name, String gender, String relation) {
        // below 3 lines of code is used to set
        // data in our object class.
        addDb.setName(name);
        addDb.setGender(gender);
        addDb.setRelation(relation);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(addDb);

                // after adding this data we are showing toast message.
                Toast.makeText(Add_Dependent.this, "data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(Add_Dependent.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    // this Intent to get to Dependent Details  page
    public void openDependent_Details() {
        Intent intent3 = new Intent(Add_Dependent.this, DependentPage.class);
        startActivity(intent3);
    }

}

