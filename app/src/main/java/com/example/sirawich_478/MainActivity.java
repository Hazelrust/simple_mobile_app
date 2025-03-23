package com.example.sirawich_478;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name, password;
    Button submit;
    String s_name, s_password, userinfo, user, pwd, welcomeMsg;
    ImageButton end_app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextNumberPassword);
        user = getString(R.string.user);
        pwd = getString(R.string.pwd);
        submit = findViewById(R.id.button);
        submit.setOnClickListener(v -> {
            if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Enter the Data", Toast.LENGTH_SHORT).show();
                return;
            } else {
                if ((!name.getText().toString().equals(user)) || (!password.getText().toString().equals(pwd))) {
                    Toast.makeText(getApplicationContext(), "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            s_name = name.getText().toString();
            s_password = password.getText().toString();
            Toast.makeText(getApplicationContext(), "Name -  " + s_name + " \n"
                    + "Password -  " + s_password, Toast.LENGTH_SHORT).show();
            Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);

        });
        end_app = (ImageButton) findViewById(R.id.button_power);
        end_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAndRemoveTask();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.song)
            song_();
        else if (item.getItemId() == R.id.photo)
            share_();
        else if (item.getItemId()== R.id.search)
            location_();
        else if (item.getItemId() == R.id.create)
        {
            create_(); return true;
        }
        else if (item.getItemId() == R.id.open)
        { open_();    return true;}

//        else if (item.getItemId() == R.id.contact)
//
/*
       else if (item.getItemId() == R.id.file)
            file_();
        else if (item.getItemId() == R.id.open)
            open_();
*/
        return true;
    }
    private void song_(){
        Intent intent = new Intent(MainActivity.this, SongActivity.class);
        startActivity(intent);
    }
    private void share_(){
    }
    private void location_(){
    }
    private void create_(){
        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
        startActivity(intent);
    }
    private void open_(){
        Intent intent = new Intent(MainActivity.this, ListContactActivity.class);
        startActivity(intent);
    }
    /*    private void contact_() {
        Intent intent = new Intent(MainActivity.this, ContactsActivity.class);
        startActivity(intent);
    }

    private void open_(){
    }
    private void file_(){
    }
*/

}
