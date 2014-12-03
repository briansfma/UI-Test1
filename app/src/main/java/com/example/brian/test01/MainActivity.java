package com.example.brian.test01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview1 = (ListView) findViewById(R.id.listView1);
        final ListView listview2 = (ListView) findViewById(R.id.listView2);

        String[] values1 = new String[] { "Android", "iOS", "Windows Mobile",
                "Chrome OS", "Linux", "MS-DOS", "Red Hat", "Ubuntu" };

        final ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i < values1.length; ++i) {
            list1.add(values1[i]);
        }
        final ArrayList<String> list2 = new ArrayList<String>();

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list1);
        listview1.setAdapter(adapter1);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list2);
        listview2.setAdapter(adapter2);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                adapter1.remove(item);
                adapter1.notifyDataSetChanged();
                adapter2.add(item);
                adapter2.notifyDataSetChanged();
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
