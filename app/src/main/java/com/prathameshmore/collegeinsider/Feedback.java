package com.prathameshmore.collegeinsider;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    private EditText editTextSubject;
    private EditText editTextFeedback;
    private Button sendFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Feedback");

        editTextSubject = (EditText) findViewById(R.id.edittextSubject);
        editTextFeedback = (EditText) findViewById(R.id.edittextSubject);

        sendFeedback = (Button) findViewById(R.id.button_send);

        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextFeedback.length() == 0 && editTextSubject.length() == 0) {


                    Toast.makeText(Feedback.this, "Please fill all the information", Toast.LENGTH_SHORT).show();

                } else {
                    String sub = editTextSubject.getText().toString().trim();
                    String feedback = editTextSubject.getText().toString().trim();

                    Intent emailIntent = new Intent();
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"vijapuresantosh@gmail.com"});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, feedback);

                    //need this to prompts email client only
                    emailIntent.setType("message/rfc822");

                    startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));
                }


            }
        });


    }
}
