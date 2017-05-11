package edu.uw.materialdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/*
    How to make transition:

    1) Add transition to styles.xml
    2) Add transition name attributes to both elements you are transitioning from and to
    3) Specify ActivityOptions with your intent
 */


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.v(TAG, "A FABulous click");
//                Snackbar.make(v, "A FABulous click", Snackbar.LENGTH_SHORT).show();
//                DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer);
//                drawer.openDrawer(GravityCompat.START);


                // this is the transition we are interested in changing
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);

                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, fab, "fab"); // from where is transition starting, what view is the transition, what is the transition
                startActivity(intent, options.toBundle()); // separate set of options delivered with the letter, not an EXTRA, which is extra information sent to new activity when it's started up
            }
        });

        // in order to specify behavior when a menu item is clicked within the navigation view
        NavigationView navView = (NavigationView) findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                return false;
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_slideshow:
                Log.v(TAG, "Clicked slideshow menu");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
