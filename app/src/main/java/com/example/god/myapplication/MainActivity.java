package com.example.god.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String msg = "Android : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(msg, "The onCreate() event");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        Log.d(msg, "The onCreateOptionsMenu() event");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Log.d(msg, "The onOptionsItemSelected() event");

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Start MyService service
     * @param view
     */
    public void startService(View view) {

        /* A service must be given an intent to start */
        startService(new Intent(getBaseContext(), MyService.class));
    }

    /**
     * Stop MyService service
     * @param view
     */
    public void stopService(View view) {

        /* Same here for stopping the service
        * The reason why we are giving it a new intent is simply by choice
        * It is the same intent as the first, just dynamically
        * created when needed to save resources */
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    /**
     * Send a custom intent broadcast to MyReceiver class
     * @param view
     */
    public void broadcastIntent(View view) {

        /* We must create a new intent and give it an action
        * specified by the <intent-filter> in the AndroidManifest.xml*/
        Intent intent = new Intent();
        intent.setAction("com.example.god.myapplication.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}
