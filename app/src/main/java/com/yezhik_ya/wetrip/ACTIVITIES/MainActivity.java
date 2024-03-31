package com.yezhik_ya.wetrip.ACTIVITIES;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.yezhik_ya.helper.inputValidators.DateRule;
import com.yezhik_ya.helper.inputValidators.EmailRule;
import com.yezhik_ya.helper.inputValidators.NameRule;
import com.yezhik_ya.helper.inputValidators.PasswordRule;
import com.yezhik_ya.helper.inputValidators.PhoneRule;
import com.yezhik_ya.helper.inputValidators.Rule;
import com.yezhik_ya.helper.inputValidators.RuleOperation;
import com.yezhik_ya.helper.inputValidators.Validator;
import com.yezhik_ya.viewmodel.GenericViewModelFactory;
import com.yezhik_ya.viewmodel.UsersViewModel;
import com.yezhik_ya.wetrip.R;

import java.time.LocalDate;

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
        tvRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(validate())
                {
                    Intent intent = new Intent(getApplicationContext(), TripsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void setValidation()
    {
        Validator.add(new Rule(etEmail, RuleOperation.REQUIRED, "Please enter your email"));

        Validator.add(new EmailRule(etEmail, RuleOperation.TEXT, "Email is wrong"));

        Validator.add(new Rule(etPassword, RuleOperation.REQUIRED, "Please enter your password"));

        Validator.add(new PasswordRule(etPassword, RuleOperation.PASSWORD, "Password is incorrect"));


    }
    @Override
    public boolean validate()
    {
        return Validator.validate();
    }
}