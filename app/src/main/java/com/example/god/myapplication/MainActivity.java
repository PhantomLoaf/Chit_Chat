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

    /**
     * This is this activity's 'constructor' as they should say in Java
     * @param savedInstanceState - saved state of the application. Non-persistent, dynamic data that
     * is passed to onCreate() so that you may recreate the activity if it is destroyed
     * in such situations such as a screen orientation change.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Here we do our activity construction
        /* Obviously.... lol
         */
        setContentView(R.layout.activity_main);
    }

    /**
     * In this method, you can inflate your menu resource (defined in XML) into the Menu provided in the callback
     * @param menu - menu to be inflated
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * When the user selects an item from the options menu (including action items in the action bar),
     * the system calls your activity's onOptionsItemSelected() method. This method passes the MenuItem selected
     * @param item - MenuItem selected
     * @return item selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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
