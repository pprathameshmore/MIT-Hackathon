package com.prathameshmore.collegeinsider;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.menu_home:
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_orders:
                        Intent startCanteenOrdersActivity = new Intent(MainActivity.this, CanteenOrders.class);
                        startActivity(startCanteenOrdersActivity);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_lostandfound:
                        Intent startLostAndFoundActivity = new Intent(MainActivity.this, LostAndFound.class);
                        startActivity(startLostAndFoundActivity);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_clean:
                        Intent startCleannessActivity = new Intent(MainActivity.this, Cleanness.class);
                        startActivity(startCleannessActivity);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_feedback:
                        Intent startFeedbackActivity = new Intent(MainActivity.this,Feedback.class);
                        startActivity(startFeedbackActivity);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_events:
                        Intent startEventsActivity = new Intent(MainActivity.this,EventNotification.class);
                        startActivity(startEventsActivity);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.menu_share:
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "Download College Insider Android app : https://github.com/pprathameshmore/MIT-Hackathon");
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);
                        drawerLayout.closeDrawers();
                }
                return false;
            }
        });


    }


    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))

            return true;

        return super.onOptionsItemSelected(item);

    }
}

