package com.example.yash.ownonclick;

import android.content.Intent;
import android.graphics.Color;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main,null);
        setContentView(ll);
       Sample s = new Sample(this,10);
       s.setBackgroundColor(Color.BLUE);
        s.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        s.setCustomInterface(new CustomInterface() {
            @Override
            public void ownOnClick() {
                Log.i("MainAct","Arrived");
                Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_SHORT).show();
            }
        });





         s.setVisibility(View.VISIBLE);
         ll.addView(s);

        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setVisibility(View.VISIBLE);
        textView.setText("Hellllllo");
        ll.addView(textView);

        setContentView(ll);


    }


    public static class SettingsCustomPrefrence extends PreferenceFragment{

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.id_settings)
            startActivity(new Intent(getApplicationContext(),Settings.class));
        return super.onOptionsItemSelected(item);
    }
}
