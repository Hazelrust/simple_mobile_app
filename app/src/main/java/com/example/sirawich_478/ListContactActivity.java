package com.example.sirawich_478;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListContactActivity extends AppCompatActivity {

    DBHelper mHelper;
    ImageButton buttonBack;
    ListView listVw;
    List<String> contacts;

//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcontact);
        buttonBack = (ImageButton) findViewById(R.id.contact_list_button_back);
        listVw = (ListView) findViewById(R.id.contact_listview);
        mHelper = new DBHelper(this);
        contacts = mHelper.getContactList();
        //listView = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        //setListAdapter(adapter);
        listVw.setAdapter(adapter);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ActivityCompat.finishAffinity(Activity activity);
                Intent i = new Intent(ListContactActivity.this, MainActivity.class);
// set the new task and clear flags
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });


        /*listVw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent detail = new Intent(getApplicationContext(), FriendDetailActivity.class);
                String listName = friends.get(position);
                int index = listName.indexOf(" ");
                String columnId = listName.substring(0, index);
                System.out.println("1.friendactivity");
                detail.putExtra(Contact.Column.ID, columnId);
                System.out.println("2.friendactivity");
                startActivity(detail);
                //overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


            }

        });*/

    }
}

