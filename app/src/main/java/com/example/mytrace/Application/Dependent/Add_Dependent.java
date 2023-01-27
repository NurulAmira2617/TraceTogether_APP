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

//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Spinner;
//import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mytrace.R;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.ValueEventListener;


public class Add_Dependent extends AppCompatActivity {

    private EditText name, Relation, Gender,CurrAddress, IC, PNumber, State,age;
    Button Add_Depen_button;
    Spinner citizen;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_dependent);


        firebaseDatabase = FirebaseDatabase.getInstance();

        citizen=(Spinner)findViewById(R.id.citizen) ;
        Relation=(EditText) findViewById(R.id.Relation) ;
        name=(EditText) findViewById(R.id.name) ;
        Gender=(EditText) findViewById(R.id.Gender) ;
        CurrAddress=(EditText) findViewById(R.id.CurrAddress) ;
        IC=(EditText) findViewById(R.id.IC) ;
        PNumber=(EditText) findViewById(R.id.PNumber) ;
        State=(EditText) findViewById(R.id.State) ;
        age=(EditText) findViewById(R.id.age) ;
        Add_Depen_button=(Button)findViewById(R.id.Add_Depen_button) ;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Add_dependent_Db");

        Add_Depen_button=(Button)findViewById(R.id.reset_button) ;

        // this Listener to get to Dependent Details page
        Add_Depen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String relation = Relation.getText().toString();
                String gender = Gender.getText().toString();
                String currAdd = CurrAddress.getText().toString();
                String ic = IC.getText().toString();
                String Age = age.getText().toString();
                String num = PNumber.getText().toString();
                String state = State.getText().toString();
                String Name = name.getText().toString();
                String Citizen = citizen.getSelectedItem().toString();
                if (TextUtils.isEmpty(relation) && TextUtils.isEmpty(gender) && TextUtils.isEmpty(Name)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(Add_Dependent.this, "Please Add Some Data", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    builder.setMessage("Do you want to add this dependent ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();
//                                    Toast.makeText(getApplicationContext(),"Dependent has been added",
//                                            Toast.LENGTH_SHORT).show();
                                    addDatatoFirebase(new Add_dependent_Db(Name,gender,relation,Citizen,currAdd,ic,Age, num,state ));
                                    //startActivity(new Intent(Add_Dependent.this, DependentPage.class));
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
//                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Add_Dependent.this);
//                    alertDialogBuilder.setTitle("Confirmation");
//
//                    alertDialogBuilder.setMessage("Are You Sure Want to Add New Dependent")
//                            .setCancelable(false)
//                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//
//
//                                }
//                            }).setNegativeButton("no", new DialogInterface.OnClickListener(){
//
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.cancel();
//                                }
//                            });
                    //startActivity(new Intent(Add_Dependent.this, DependentPage.class));

                }




           }
        });
    }
    private void addDatatoFirebase(Add_dependent_Db addDb) {
        DatabaseReference dependent = databaseReference.child("Dependent").push();
        dependent.setValue(addDb).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(),"Success insert",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Add_Dependent.this, DependentPage.class));
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Failed insert",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    // this Intent to get to Dependent Details  page
    public void openDependent_Details() {
        Intent intent3 = new Intent(Add_Dependent.this, DependentPage.class);
        startActivity(intent3);
    }

}

