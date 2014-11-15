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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.guhack.alpha.culturebuddy.R;

import java.net.URLEncoder;
import java.util.ArrayList;

public class ChatActivity extends ActionBarActivity {

    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        android.support.v7.app.ActionBar actionbar = getSupportActionBar();
        actionbar.setIcon(R.drawable.ic_aziz);
        actionbar.setTitle("Aziz Ansari");

        /** mock code */
            ArrayList<ChatMessage> list = new ArrayList<ChatMessage>();
            for (String temp : ("Hi!,How are you doing?, Today was a very " +
                    "long day here in Pakistan so I will write a very long message to show how " +
                    "line breaks work here, I know you are not responding only because I am not " +
                    "real so I will not hold it against you.,Are you still there?").split(",")){
                ChatMessage message = new ChatMessage(temp, false);
                list.add(message);
            }
        /***/

        adapter = new ChatAdapter("Aziz Ansari", list, ChatActivity.this);
        ((ListView) findViewById(R.id.chat_list)).setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ((ListView) findViewById(R.id.chat_list)).setSelection(adapter.getCount() - 1);

        findViewById(R.id.send_message_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = ((EditText) findViewById(R.id.your_message)).getText().toString();
                if (msg.isEmpty()) return;
                adapter.addMessage(new ChatMessage(msg, true));
                send(msg);
                ((ListView) findViewById(R.id.chat_list)).setSelection(adapter.getCount() - 1);
                ((EditText) findViewById(R.id.your_message)).setText("");
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

    private void send(String msg){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String fromuser = "vlad";
        String touser = "martin";
        String url = String.format("http://ec2-54-228-159-65.eu-west-1.compute.amazonaws.com:8080/CodeForGood17" +
                "/sendsms?from=%s&to=%s&text=%s", fromuser, touser, URLEncoder.encode(msg));

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}
