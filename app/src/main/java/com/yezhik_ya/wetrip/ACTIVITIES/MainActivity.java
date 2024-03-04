package com.yezhik_ya.wetrip.ACTIVITIES;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yezhik_ya.wetrip.R;

public class MainActivity extends BaseActivity
{
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegister;
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
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);

        setListeners();
    }
    @Override
    protected void setListeners()
    {

    }
}