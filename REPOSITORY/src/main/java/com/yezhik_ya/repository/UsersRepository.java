package com.yezhik_ya.repository;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yezhik_ya.model.User;
public class UsersRepository
{
    private FirebaseFirestore db;
    private CollectionReference collection;

    public UsersRepository(Context context)
    {
        try
        {
            db = FirebaseFirestore.getInstance();
        }
        catch (Exception e)
        {
            FirebaseInstance instance = FirebaseInstance.instance(context);
            db = FirebaseFirestore.getInstance(FirebaseInstance.app);
        }

        collection = db.collection("Users");
    }
    public Task<Boolean> add (User user)
    {
        TaskCompletionSource<Boolean> taskCompletion = new TaskCompletionSource<Boolean>();
        DocumentReference document = collection.document();
        user.setIdFs(document.getId());
        document.set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>()
                {
                    @Override
                    public void onSuccess(Void unused) { taskCompletion.setResult(true); }
                })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e) { taskCompletion.setResult(false); }
                });
        return taskCompletion.getTask();
    }
    public Task<Boolean> update (User user)
    {
        TaskCompletionSource<Boolean> completionSource = new TaskCompletionSource<>();

        DocumentReference document = collection.document(user.getIdFs());
        document.set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>()
                {
                    @Override
                    public void onSuccess(Void unused) { completionSource.setResult(true); }
                })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        completionSource.setResult(false);
                        completionSource.setException(e);
                    }
                });

        return completionSource.getTask();
    }

    public Task<Boolean> delete(User user)
    {
        TaskCompletionSource<Boolean> completionSource = new TaskCompletionSource<>();

        DocumentReference document = collection.document(user.getIdFs());
        document.delete()
                .addOnSuccessListener(new OnSuccessListener<Void>()
                {
                    @Override
                    public void onSuccess(Void unused) { completionSource.setResult(true); }
                })
                .addOnFailureListener(new OnFailureListener()
                {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {
                        completionSource.setResult(false);
                        completionSource.setException(e);
                    }
                });
        return completionSource.getTask();
    }
}
