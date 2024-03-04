package com.yezhik_ya.wetrip.ACTIVITIES;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.yezhik_ya.wetrip.R;

public class RegisterActivity extends BaseActivity
{
    private EditText etName, etLastName, etBirth, etPhone, etEmail, etPassword, etRetype;
    private Button btnRegister, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeViews();
    }

    @Override
    protected void initializeViews()
    {
        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etBirth = findViewById(R.id.etBirth);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRetype = findViewById(R.id.etRetype);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);

        setListeners();
    }

    @Override
    protected void setListeners()
    {

    }
}