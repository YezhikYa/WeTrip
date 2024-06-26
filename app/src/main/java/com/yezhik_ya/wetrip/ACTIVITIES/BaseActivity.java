package com.yezhik_ya.wetrip.ACTIVITIES;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yezhik_ya.wetrip.R;

public abstract class BaseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
    protected abstract void initializeViews();
    protected abstract void setListeners();
}