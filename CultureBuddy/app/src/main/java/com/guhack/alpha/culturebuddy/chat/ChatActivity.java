package com.guhack.alpha.culturebuddy.chat;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.guhack.alpha.culturebuddy.R;

import java.util.ArrayList;

public class ChatActivity extends ActionBarActivity {

    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) actionbar.hide();

        /** mock code */
            ArrayList<ChatMessage> list = new ArrayList<ChatMessage>();
            for (int i = 0; i< 6;i++){
                ChatMessage message = new ChatMessage("Hello, are you there?", false);
                list.add(message);
            }
        /***/

        adapter = new ChatAdapter("Aziz ansari", list, ChatActivity.this);
        ((ListView) findViewById(R.id.chat_list)).setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ((ListView) findViewById(R.id.chat_list)).setSelection(adapter.getCount()-1);

        findViewById(R.id.send_message_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = ((EditText) findViewById(R.id.your_message)).getText().toString();
                adapter.addMessage(new ChatMessage(msg, true));
                ((ListView) findViewById(R.id.chat_list)).setSelection(adapter.getCount()-1);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
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

    protected class ChatAdapter extends BaseAdapter {

        private ArrayList<ChatMessage> messages;
        private LayoutInflater inflater;
        private String buddy;

        public ChatAdapter(String buddy, ArrayList<ChatMessage> messages, Context context){
            this.inflater = LayoutInflater.from(context);
            this.messages = messages;
            this.buddy = buddy;

        }

        @Override
        public int getCount() {
            return messages.size();
        }

        @Override
        public ChatMessage getItem(int position) {
            return messages.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public void addMessage(ChatMessage message) {
            messages.add(message);
            notifyDataSetChanged();
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflateIfRequired(view, position, parent);
            bind(getItem(position), view);
            return view;
        }

        private void bind(ChatMessage message, View view) {
            ViewHolder holder = (ViewHolder) view.getTag();
            holder.message.setText(message.getMessage());
            String name;
            if (message.isSentByYou())
                name = "Me: ";
            else name = buddy+": ";
            holder.nametag.setText(name);
        }

        private View inflateIfRequired(View view, int position, ViewGroup parent) {
            if (view == null) {
                view = inflater.inflate(R.layout.row_chat_message, parent, false);
                view.setTag(new ViewHolder(view));
            }
            return view;
        }

        protected class ViewHolder{

            TextView message;
            TextView nametag;

            ViewHolder(View view){
                message = (TextView) view.findViewById(R.id.chat_message_text);
                nametag = (TextView) view.findViewById(R.id.chat_name_tag);
            }

        }
    }
}
