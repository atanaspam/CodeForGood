package com.guhack.alpha.culturebuddy;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.guhack.alpha.culturebuddy.userprofile.UserProfileActivity;


public class StartupActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();

        TextView myTextView = (TextView) findViewById(R.id.title);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "fontmain.ttf");
        myTextView.setTypeface(typeFace);

        /**
         * doesnt verify users yet, but only checks if a username and password have in fact been entered
         * they arent stored anywhere just yet
         * */
        findViewById(R.id.signin_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((EditText) findViewById(R.id.password_entry)).getText().toString().isEmpty() ||
                        ((EditText) findViewById(R.id.username_entry)).getText().toString().isEmpty())
                    Toast.makeText(StartupActivity.this, "Please enter a username and password", Toast.LENGTH_SHORT).show();
                else
                    startActivity(new Intent(StartupActivity.this, UserProfileActivity.class));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_startup, menu);
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
}
