package com.example.sirawich_478;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateContactActivity  extends Activity {
    DBHelper dHelper;

    private TextView dName;
    private TextView dAddress;
    private TextView dTel;
    private TextView dEmail;
    private TextView dDescription;
    private String id = "";

    private Button dButtonEdit,dButtonDelete;
    private ImageButton dButtonBack;
    private Contact dContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dHelper = new DBHelper(this);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            id = bundle.getString(Contact.Column.ID);
        }

        setContentView(R.layout.activity_upd_contact);
        System.out.print("1.UpdateContact");
        dName = (TextView) findViewById(R.id.contactupd_name_editText);
        dAddress = (TextView) findViewById(R.id.contactupd_address_editText);
        dTel = (TextView) findViewById(R.id.contactupd_phone_editText);
        dEmail = (TextView) findViewById(R.id.contactupd_email_editText);
        dDescription = (TextView) findViewById(R.id.contactupd_note_editText);
        dButtonEdit = (Button) findViewById(R.id.contactupd_save_button);
        dButtonDelete = (Button) findViewById(R.id.contactupd_cancel_button);



        System.out.println("1.contactdetail");
        dContact = dHelper.getContact(id);
        System.out.println("2.contactdetail");
        dName.setText(dContact.getName());
        dAddress.setText(dContact.getAddress());
        dTel.setText(dContact.getTel());
        dEmail.setText(dContact.getEmail());
        dDescription.setText(dContact.getDescription());

        dButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateIntent = new Intent(UpdateContactActivity.this,
                        UpdateContactActivity2.class);

                updateIntent.putExtra(Contact.Column.ID, dContact.getId());
                updateIntent.putExtra(Contact.Column.NAME, dContact.getName());
                updateIntent.putExtra(Contact.Column.ADDRESS, dContact.getAddress());
                updateIntent.putExtra(Contact.Column.TEL, dContact.getTel());
                updateIntent.putExtra(Contact.Column.EMAIL, dContact.getEmail());
                updateIntent.putExtra(Contact.Column.DESCRIPTION, dContact.getDescription());
                System.out.print("1.bedit");
                System.out.print(" ID "+ dContact.getId());
                System.out.print(" "+ dContact.getName());
                System.out.print(" "+ dContact.getAddress());
                System.out.print(" "+ dContact.getTel());
                System.out.print(" "+ dContact.getEmail());
                System.out.println(" "+ dContact.getDescription());

                updateIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |  Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(updateIntent);
            }


        });
        //*for update contact

        dButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder =
                        new AlertDialog.Builder(UpdateContactActivity.this);
                builder.setTitle(getString(R.string.delete_contact_title));
                builder.setMessage(getString(R.string.delete_data_message));

                builder.setPositiveButton(getString(android.R.string.ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dHelper.deleteContact(id);

                                Toast.makeText(getApplication(),
                                        "Deleted", Toast.LENGTH_LONG).show();
                                Intent updateIntent = new Intent(UpdateContactActivity.this,
                                        ListContactActivity.class);
                                updateIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |  Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(updateIntent);
                            }
                        });

                builder.setNegativeButton(getString(android.R.string.cancel), null);

                builder.show();
//
            }
        });
    }
}


