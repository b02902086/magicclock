package com.example.mac.magiclock;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;
public class MyClock extends Activity {
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_clock);
        Button btnPrefs = (Button) findViewById(R.id.btnPrefs);
        //Button btnGetPrefs = (Button) findViewById(R.id.btnGetPreferences);
        textView = (TextView) findViewById(R.id.txtPrefs);
        textView = (TextView) findViewById(R.id.fmtext);
        displaySharedPreferences();
    View.OnClickListener listener = new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                case R.id.btnPrefs:
                    Intent intent = new Intent(MyClock.this,PrefsActivity.class);
                    startActivity(intent);
                    break;
//              case R.id.btnGetPreferences:
//                  displaySharedPreferences();
//                  break;
                default:
                    break;
            }
        }
    };

    btnPrefs.setOnClickListener(listener);
    //btnGetPrefs.setOnClickListener(listener);
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_clock, menu);
        return true;
    }

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
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my_clock, container, false);
            return rootView;
        }
    }
    private void displaySharedPreferences() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MyClock.this);

        String username = prefs.getString("your name", "Default NickName");
        String group = prefs.getString("Group name", "Default name");
        //String passw = prefs.getString("password", "Default Password");
        //boolean checkBox = prefs.getBoolean("checkBox", false);
        //String listPrefs = prefs.getString("listpref", "Default list prefs");
        StringBuilder builder = new StringBuilder();
        StringBuilder build = new StringBuilder();
        builder.append("Username:" + "\n" + username + "\n");
        build.append(group);
        //builder.append("Password: " + passw + "\n");
        //builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        //builder.append("List preference: " + listPrefs);
        //TextView textView;
        textView.setText(builder.toString());
        textView.setText(build.toString());
    }
}
