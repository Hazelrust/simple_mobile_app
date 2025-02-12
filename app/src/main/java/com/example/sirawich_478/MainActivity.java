package com.example.sirawich_478;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editTextText);
        password = (EditText) findViewById(R.id.editTextNumberPassword);
        user = getString(R.string.user);
        pwd = getString(R.string.pwd);
        submit = (Button) findViewById(R.id.button);
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
            search_();
        else if (item.getItemId() == R.id.file)
            file_();
        else if (item.getItemId() == R.id.create)
            create_();
        else if (item.getItemId() == R.id.open)
            open_();
        return true;
    }
    private void song_(){
    }
    private void share_(){
    }
    private void search_(){
    }
    private void file_(){
    }
    private void create_(){
    }
    private void open_(){
    }
}
