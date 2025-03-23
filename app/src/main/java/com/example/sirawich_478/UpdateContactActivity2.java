package com.example.sirawich_478;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateContactActivity2 extends Activity {

    private static final String TAG = "UpdateContactActivity2";

    private EditText updName;
    private EditText updAddress;
    private EditText updTel;
    private EditText updEmail;
    private EditText updDescription;
    private Button updButtonOK, updButtonCC;

    private int ID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_upd_contact2);
        updName = (EditText) findViewById(R.id.contactupd2_name_editText);
        updAddress = (EditText) findViewById(R.id.contactupd2_address_editText);
        updTel = (EditText) findViewById(R.id.contactupd2_phone_editText);
        updEmail = (EditText) findViewById(R.id.contactupd2_email_editText);
        updDescription = (EditText) findViewById(R.id.contactupd2_note_editText);
        updButtonOK = (Button) findViewById(R.id.contactupd2_save_button);
        updButtonCC = (Button) findViewById(R.id.contactupd2_cancel_button);

        DBHelper mHelper = new DBHelper(this);
        System.out.println("in Updatecontact2");
        //for update friend
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            System.out.println("2.bedit-bundle");
            ID = bundle.getInt(Contact.Column.ID);
            String name = bundle.getString(Contact.Column.NAME);
            String address = bundle.getString(Contact.Column.ADDRESS);
            String tel = bundle.getString(Contact.Column.TEL);
            String email = bundle.getString(Contact.Column.EMAIL);
            String description = bundle.getString(Contact.Column.DESCRIPTION);
            System.out.println("3.bedit-bundle "+ID);
            updName.setText(name);
            updAddress.setText(address);
            updTel.setText(tel);
            updEmail.setText(email);
            updDescription.setText(description);
        }
        //*for update friend





        updButtonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(UpdateContactActivity2.this);
                builder.setTitle(getString(R.string.update_contact_title));
                builder.setMessage(getString(R.string.add_contact_message));

                builder.setPositiveButton(getString(android.R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Contact contact = new Contact();
                                contact.setName(updName.getText().toString());
                                contact.setAddress(updAddress.getText().toString());
                                contact.setTel(updTel.getText().toString());
                                contact.setEmail(updEmail.getText().toString());
                                contact.setDescription(updDescription.getText().toString());
                                Log.i(TAG,"UPDATE contact");
                                contact.setId(ID);
                                mHelper.updateContact(contact);
                                finish();
                                Intent i = new Intent(UpdateContactActivity2.this, ListContactActivity.class);
// set the new task and clear flags
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |  Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(i);
                            }
                        });

                builder.setNegativeButton(getString(android.R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });


                builder.show();
            }
        });
        updButtonCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}

