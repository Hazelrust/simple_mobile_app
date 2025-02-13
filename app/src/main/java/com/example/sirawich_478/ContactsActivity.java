package com.example.sirawich_478;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class ContactsActivity extends Activity {

    private EditText contact_name, contact_address, contact_phone, contact_email, contact_note;
    private Button contact_save, contact_cancel;
    private int ID = -1;
//    private static final String TAG = "ContactsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        // Initialize views
        contact_name = findViewById(R.id.contact_name_editText);
        contact_address = findViewById(R.id.contact_address_editText);
        contact_phone = findViewById(R.id.contact_phone_editText);
        contact_email = findViewById(R.id.contact_email_editText);
        contact_note = findViewById(R.id.contact_note_editText);
        contact_save = findViewById(R.id.contact_save_button);
        contact_cancel = findViewById(R.id.contact_cancel_button);

        DBHelper mHelper = new DBHelper(this);

        contact_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "CLICK SAVE");

                AlertDialog.Builder builder = new AlertDialog.Builder(ContactsActivity.this);
                builder.setTitle(getString(R.string.add_contact_title));
                builder.setMessage(getString(R.string.add_contact_message));
                //AlertDialog alert = builder.create();
                //alert.show();

                builder.setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "ADD CONTACT");

                        Contact contact = new Contact();
                        contact.setName(contact_name.getText().toString());
                        contact.setAddress(contact_address.getText().toString());
                        contact.setTel(contact_phone.getText().toString());
                        contact.setEmail(contact_email.getText().toString());
                        contact.setDescription(contact_note.getText().toString());

                        if (ID == -1) {  // Add new contact
                            Log.i(TAG, "AddContact");
                            mHelper.addContact(contact);
                            clearFields();
                        } else {  // Update existing contact
                            contact.setId(ID);
                            mHelper.updateContact(contact);
                        }
                    }
                });

                builder.show();
            }
        });
    }

    // Helper method to clear input fields
    private void clearFields() {
        contact_name.setText("");
        contact_address.setText("");
        contact_phone.setText("");
        contact_email.setText("");
        contact_note.setText("");
    }
}
