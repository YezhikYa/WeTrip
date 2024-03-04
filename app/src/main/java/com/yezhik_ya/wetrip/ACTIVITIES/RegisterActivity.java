package com.yezhik_ya.wetrip.ACTIVITIES;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.yezhik_ya.helper.DateUtil;
import com.yezhik_ya.helper.inputValidators.DateRule;
import com.yezhik_ya.helper.inputValidators.EmailRule;
import com.yezhik_ya.helper.inputValidators.EntryValidation;
import com.yezhik_ya.helper.inputValidators.NameRule;
import com.yezhik_ya.helper.inputValidators.PasswordRule;
import com.yezhik_ya.helper.inputValidators.PhoneRule;
import com.yezhik_ya.helper.inputValidators.Rule;
import com.yezhik_ya.helper.inputValidators.RuleOperation;
import com.yezhik_ya.helper.inputValidators.Validator;
import com.yezhik_ya.model.User;
import com.yezhik_ya.viewmodel.GenericViewModelFactory;
import com.yezhik_ya.viewmodel.UsersViewModel;
import com.yezhik_ya.wetrip.R;

import java.time.LocalDate;

public class RegisterActivity extends BaseActivity implements EntryValidation
{
    private EditText etName, etLastName, etBirth, etPhone, etEmail, etPassword, etRetype;
    private Button btnRegister, btnCancel;
    private UsersViewModel usersViewModel;
    private User oldUser;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeViews();
        setObservers();
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
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(validate())
                {
                    User user = new User();

                    user.setName(etName.getText().toString());
                    user.setLastName(etLastName.getText().toString());
                    user.setBorn(DateUtil.stringDateToLong(etBirth.getText().toString()));
                    //picture
                    user.setEmail(oldUser.getEmail().toString());
                    user.setPassword(oldUser.getPassword().toString());
                    user.setRetype(oldUser.getReType().toString());

                    if (oldUser != null)
                    {
                        user.setIdFs(oldUser.getIdFs());
                        usersViewModel.update(user);
                    }

                    else { usersViewModel.add(user); }

                    Intent intent = new Intent();
                    intent.putExtra("USER", user);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
    @Override
    public void setValidation()
    {
        Validator.add(new Rule(etName, RuleOperation.REQUIRED, "Please enter your name"));

        Validator.add(new NameRule(etName, RuleOperation.NAME, "Name is wrong"));

        Validator.add(new Rule(etLastName, RuleOperation.REQUIRED, "Please enter your name"));

        Validator.add(new NameRule(etLastName, RuleOperation.NAME, "Name is wrong"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            Validator.add(new DateRule(etBirth, RuleOperation.DATE, "Wrong date", LocalDate.now().minusYears(100), LocalDate.now()));

        Validator.add(new Rule(etPhone, RuleOperation.REQUIRED, "Please enter phone number"));

        Validator.add(new PhoneRule(etPhone, RuleOperation.NUMBER, "Wrong phone number"));

        Validator.add(new Rule(etEmail, RuleOperation.REQUIRED, "Please enter email"));

        Validator.add(new EmailRule(etEmail, RuleOperation.TEXT, "Wrong email"));

        Validator.add(new Rule(etPassword, RuleOperation.REQUIRED, "please enter password"));

        Validator.add(new PasswordRule(etPassword, RuleOperation.PASSWORD, "assword"));

        Validator.add(new Rule(etRetype, RuleOperation.REQUIRED, "please enter password"));

        Validator.add(new PasswordRule(etRetype, RuleOperation.PASSWORD, "please retype password"));

        //Validator.add(new CompareRule(etRetype, etPassword, RuleOperation.COMPARE, etPassword.getText().toString())); //??
    }
    @Override
    public boolean validate()
    {
        return Validator.validate();
    }
    private void setObservers()
    {
        GenericViewModelFactory<UsersViewModel> factory = new GenericViewModelFactory<>(getApplication(), UsersViewModel::new);
        usersViewModel = new ViewModelProvider(this, factory).get(UsersViewModel.class);

        usersViewModel.getSuccessOperation().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Toast.makeText(RegisterActivity.this, "Saved successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Error!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void getExtra()
    {
        if (getIntent().getExtras() != null)
        {
            if (getIntent().hasExtra("USER"))
            {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
                {
                    oldUser = getIntent().getSerializableExtra("USER", User.class);
                    if (oldUser != null) { setData(); }
                }
            }
        }
    }

    private void setData()
    {
        etName.setText(oldUser.getName());
        etLastName.setText(oldUser.getLastName());
        etPhone.setText(oldUser.getPhone());
        etBirth.setText(DateUtil.longDateToString(oldUser.getBorn()));
        //picture
        etEmail.setText(oldUser.getEmail());
        etPassword.setText(oldUser.getPassword());
        etRetype.setText(oldUser.getReType());
    }
}