package com.yezhik_ya.repository;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseInstance {
    private static volatile FirebaseInstance _instance = null;
    public static FirebaseApp app;

    private FirebaseInstance(Context context) {
        FirebaseOptions options = new
                FirebaseOptions.Builder()
                .setProjectId("wetrip-n090806")		// ApplicationId
                .setApplicationId("1:28383855363:android:f37e3b74285d78d8ca5f36")		// ProjectId
                .setApiKey("AIzaSyD2YzGrJZm01Al-22_nag63vPFhFLDFZP4")
                .setStorageBucket("wetrip-n090806.appspot.com")
                .build();

        app = FirebaseApp.initializeApp(context, options);
    }

    public static FirebaseInstance instance(Context context)
    {
        if (_instance == null)
        {  // 1st check
            synchronized (FirebaseInstance.class)
            {
                if (_instance == null)
                { // 2nd check
                    _instance = new FirebaseInstance(context);
                }
            }
        }

        return _instance; }
}

