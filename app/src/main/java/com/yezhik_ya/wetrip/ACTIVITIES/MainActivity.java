package com.yezhik_ya.wetrip.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yezhik_ya.wetrip.R;

public class MainActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
    }
    @Override
    protected void initializeViews()
    {
        setListeners();
    }
    @Override
    protected void setListeners()
    {

    }
}