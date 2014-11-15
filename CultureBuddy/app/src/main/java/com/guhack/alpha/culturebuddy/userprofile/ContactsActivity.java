package com.guhack.alpha.culturebuddy.userprofile;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.guhack.alpha.culturebuddy.R;
import com.guhack.alpha.culturebuddy.chat.ChatMessage;

import java.util.ArrayList;

public class ContactsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();

        ((ListView) findViewById(R.id.contacts_list)).setAdapter(new ContactAdapter(("Noor Anam,Mahnoor Mishael," +
                "Javeria Sarah,Mariam Faiza").split(","), ContactsActivity.this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts, menu);
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

    protected class ContactAdapter extends BaseAdapter {

        private String[] names;
        private LayoutInflater inflater;

        public ContactAdapter(String[] names, Context context){
            this.inflater = LayoutInflater.from(context);
            this.names = names;

        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public String getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflateIfRequired(view, position, parent);
            ViewHolder holder = (ViewHolder) view.getTag();
            holder.name.setText(getItem(position));
            return view;
        }

        private View inflateIfRequired(View view, int position, ViewGroup parent) {
            if (view == null) {
                view = inflater.inflate(R.layout.row_contact, parent, false);
                view.setTag(new ViewHolder(view));
            }
            return view;
        }

        protected class ViewHolder{

            TextView name;

            ViewHolder(View view){
                name = (TextView) view.findViewById(R.id.contact_name);
            }

        }
    }
}
