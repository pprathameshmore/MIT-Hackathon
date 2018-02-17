package com.prathameshmore.collegeinsider;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EventNotification extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private TextView notification_view_1;

    private TextView notification_view_2;

    private TextView notification_view_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_notification);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Event Notifications");

        notification_view_1 = (TextView) findViewById(R.id.edittext_message1);

        notification_view_2 = (TextView) findViewById(R.id.edittext_message2);

        notification_view_3 = (TextView) findViewById(R.id.edittext_message3);

        firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference notifications_1 = firebaseDatabase.getReference("Notifications_1");

        final DatabaseReference notifications_2 = firebaseDatabase.getReference("Notifications_2");

        DatabaseReference notifications_3 = firebaseDatabase.getReference("Notifications_3");


        notifications_1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String notification1 = dataSnapshot.getValue(String.class);
                notification_view_1.setText(notification1);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        notifications_2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String notification2 = dataSnapshot.getValue(String.class);
                notification_view_2.setText(notification2);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        notifications_3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String notification3 = dataSnapshot.getValue(String.class);
                notification_view_3.setText(notification3);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
