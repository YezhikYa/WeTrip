package com.yezhik_ya.wetrip.ACTIVITIES;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yezhik_ya.wetrip.R;

public class TripsActivity extends BaseActivity
{
    private RecyclerView rvTrips;
    private FloatingActionButton fabAddTrip;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);

        initializeViews();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.settings){
            Toast.makeText(this,"You clicked Logout",Toast.LENGTH_LONG).show();
        }
        else if (id == R.id.new_game)
        {
            Toast.makeText(this,"You clicked About",Toast.LENGTH_LONG).show();

        }
        return true;
    }

    @Override
    protected void initializeViews() {

    }

    @Override
    protected void setListeners() {

    }
}