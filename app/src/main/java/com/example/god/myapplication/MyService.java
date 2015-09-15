package com.example.god.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        /* We are returning null here since we are not communicating
            with any other outside applications yet. We will for accessing contacts */
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        /* Constant to return from onStartCommand(Intent, int, int):
            if this service's process is killed while it is started
            (after returning from onStartCommand(Intent, int, int)),
            then leave it in the started state but don't retain this delivered intent */
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
    }
}
