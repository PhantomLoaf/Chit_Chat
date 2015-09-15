package com.example.god.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    /**
     * Constructor
     */
    public MyReceiver() {
    }

    /**
     * Used to broadcast a message to the system or user
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        Toast.makeText(context, "Intent Detected", Toast.LENGTH_LONG).show();
    }
}
