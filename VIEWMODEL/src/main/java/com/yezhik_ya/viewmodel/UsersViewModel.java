package com.yezhik_ya.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.yezhik_ya.model.User;
import com.yezhik_ya.repository.UsersRepository;

public class UsersViewModel extends ViewModel
{
    private MutableLiveData<Boolean> successOperation;
    private Context context;
    private UsersRepository repository;

    public UsersViewModel(Context context)
    {
        successOperation = new MutableLiveData<>();
        this.context = context;
        repository = new UsersRepository(context);
    }

    public LiveData<Boolean> getSuccessOperation() { return successOperation; }

    public void add(User user)
    {
        repository.add(user)
                .addOnSuccessListener(aBoolean ->
                {successOperation.setValue(true);})
                .addOnFailureListener(e ->
                {successOperation.setValue(false);});
    }
    public void save(User user)
    {
        if (user.getIdFs() != null) { update(user); }
        else { add(user); }
    }
    public void update(User user)
    {
        repository.update(user)
                .addOnSuccessListener(new OnSuccessListener<Boolean>()
                {
                    @Override
                    public void onSuccess(Boolean aBoolean)
                    {
                        if (aBoolean) { successOperation.setValue(true); }
                        else { successOperation.setValue(false); }
                    }
                })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e) { successOperation.setValue(false); }
                });
    }
    public void delete(User user)
    {
        repository.delete(user)
                .addOnSuccessListener(new OnSuccessListener<Boolean>()
                {
                    @Override
                    public void onSuccess(Boolean aBoolean)
                    {
                        if (aBoolean) { successOperation.setValue(true); }
                        else { successOperation.setValue(false); }
                    }
                })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e) { successOperation.setValue(false); }
                });
    }
}
