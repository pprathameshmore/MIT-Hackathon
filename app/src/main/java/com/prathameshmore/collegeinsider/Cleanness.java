package com.prathameshmore.collegeinsider;

import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cleanness extends AppCompatActivity {

    private EditText editTextGetName;
    private EditText editTextGetEmail;
    private EditText getEditTextGetRollNo;
    private EditText editTextGetReport;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleanness);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cleanness");

        editTextGetName = (EditText) findViewById(R.id.editTextGetName);
        editTextGetEmail = (EditText) findViewById(R.id.editTextGetEmail);
        getEditTextGetRollNo = (EditText) findViewById(R.id.editTextGetRollNo);
        editTextGetReport = (EditText) findViewById(R.id.editTextGetReport);

        databaseReference = FirebaseDatabase.getInstance().getReference("path");

        btnSubmit = (Button) findViewById(R.id.btnCleanSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportCleanness();
            }
        });


    }

    private void reportCleanness() {

        String name = editTextGetName.getText().toString();
        String email = editTextGetEmail.getText().toString();
        String roll = getEditTextGetRollNo.getText().toString();
        String report = editTextGetReport.getText().toString();

        if (editTextGetName.length() == 0 && editTextGetEmail.length() == 0 && getEditTextGetRollNo.length() == 0 && editTextGetReport.length() == 0) {

            Toast.makeText(this, "Please fill the all information", Toast.LENGTH_SHORT).show();
        } else {

            String id = databaseReference.push().getKey();

            CleannessClass cleannessClass = new CleannessClass(name, email,roll,report);
            databaseReference.child(id).setValue(cleannessClass);

            Toast.makeText(this, "Submited", Toast.LENGTH_SHORT).show();

            editTextGetName.setText("");
            editTextGetEmail.setText("");
            getEditTextGetRollNo.setText("");
            editTextGetReport.setText("");

        }

    }
}
