package com.prathameshmore.collegeinsider;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LostAskHere extends AppCompatActivity {

    private EditText postName;
    private EditText postItem;
    private EditText postContact;
    private Button btnSubmitPost;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_ask_here);

        postName = (EditText) findViewById(R.id.editText_postName);
        postItem = (EditText) findViewById(R.id.editText_postItem);
        postContact = (EditText) findViewById(R.id.editText_postContact);

        btnSubmitPost = (Button) findViewById(R.id.submitPostBtn);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Lost_Items");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Ask for Lost Item");

        btnSubmitPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPosting();
            }
        });


    }

    private void startPosting() {

        String name = postName.getText().toString();
        String item = postItem.getText().toString();
        String contact = postContact.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(item) && !TextUtils.isEmpty(contact)) {

            DatabaseReference reference = databaseReference.push();
            reference.child("Name").setValue(name);
            reference.child("Details").setValue(item);
            reference.child("Contact").setValue(contact);

        }

    }
}
