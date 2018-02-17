package com.prathameshmore.collegeinsider;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LostAndFound extends AppCompatActivity {

    private Button buttonPostLost;
    private RecyclerView lostItemList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_and_found);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Lost");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Lost And Found");

        buttonPostLost = (Button) findViewById(R.id.button_ask_lost);

        lostItemList = (RecyclerView) findViewById(R.id.item_list);
        lostItemList.setHasFixedSize(true);
        lostItemList.setLayoutManager(new LinearLayoutManager(this));

        buttonPostLost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startPostActivity = new Intent(LostAndFound.this, LostAskHere.class);
                startActivity(startPostActivity);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<LostItem, LostitemViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<LostItem, LostitemViewHolder>(
                LostItem.class,
                R.layout.lost_row,
                LostitemViewHolder.class,
                databaseReference) {
            @Override
            protected void populateViewHolder(LostitemViewHolder viewHolder, LostItem model, int position) {

                viewHolder.setName(model.getName());
                viewHolder.setItem(model.getItem());
                viewHolder.setContact(model.getContact());

            }
        };

        lostItemList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class LostitemViewHolder extends RecyclerView.ViewHolder {

        View view;


        public LostitemViewHolder(View itemView) {
            super(itemView);

            view = itemView;

        }

        public void setName(String name) {

            TextView post_title = (TextView) view.findViewById(R.id.post_name);
            post_title.setText(name);

        }

        public void setItem(String item) {

            TextView post_item = (TextView) view.findViewById(R.id.post_item);
            post_item.setText(item);

        }

        public void setContact(String contact) {

            TextView post_contact = (TextView) view.findViewById(R.id.post_contact);
            post_contact.setText(contact);

        }
    }

}
