package com.example.sirawich_478;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";  // This is the missing part!

    public DBHelper(Context context) {
        super(context, Contact.DATABASE_NAME, null, Contact.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                Contact.TABLE,
                Contact.Column.ID,
                Contact.Column.NAME,
                Contact.Column.ADDRESS,
                Contact.Column.TEL,
                Contact.Column.EMAIL,
                Contact.Column.DESCRIPTION);
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //String DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS friend";
        String DROP_CONTACT_TABLE = "DROP TABLE IF EXISTS " + Contact.TABLE;
        db.execSQL(DROP_CONTACT_TABLE);
        Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);
        onCreate(db);
    }

//    public List<String> getContactList() {
//        List<String> contacts = new ArrayList<>();
//
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//
//        Cursor cursor = sqLiteDatabase.query
//                (Contact.TABLE, null, null, null, null, null, null);
//
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//
//        while (!cursor.isAfterLast()) {
//
//            contacts.add(cursor.getLong(0) + " " +
//                    cursor.getString(1) + " " +
//                    cursor.getString(2));
//
//            cursor.moveToNext();
//        }
//        sqLiteDatabase.close();
//        return contacts;
//    }
public List<String> getContactList() {
    List<String> contacts = new ArrayList<>();

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.query(Contact.TABLE, null, null, null, null, null, null);

    // Make sure the cursor has data
    if (cursor != null && cursor.moveToFirst()) {
        do {
            // 0: ID, 1: NAME, 2: ADDRESS, 3: TEL, 4: EMAIL, 5: DESCRIPTION
            long id         = cursor.getLong(0);
            String name     = cursor.getString(1);
            String address  = cursor.getString(2);
            String tel      = cursor.getString(3);
            String email    = cursor.getString(4);
            // String desc  = cursor.getString(5); // If needed

            // Format the string exactly how you want:
            // Example: "Nhong Sornwit 0927824422 sornwit@gmail.com"
            String line = name + " " + address + " " + tel + " " + email;

            contacts.add(line);
        } while (cursor.moveToNext());
    }

    if (cursor != null) {
        cursor.close();
    }
    db.close();

    return contacts;
}


    public void addContact(Contact contact) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contact.Column.NAME, contact.getName());
        values.put(Contact.Column.ADDRESS, contact.getAddress());
        values.put(Contact.Column.TEL, contact.getTel());
        values.put(Contact.Column.EMAIL, contact.getEmail());
        values.put(Contact.Column.DESCRIPTION, contact.getDescription());

        sqLiteDatabase.insert(Contact.TABLE, null, values);

        sqLiteDatabase.close();
    }

    public Contact getContact(String id) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(Contact.TABLE,
                null,
                Contact.Column.ID + " = ? ",
                new String[]{id},
                null,
                null,
                null,
                null);


        if (cursor != null) {
            cursor.moveToFirst();
        }

        Contact contact = new Contact();

        contact.setId((int) cursor.getLong(0));
        contact.setName(cursor.getString(1));
        contact.setAddress(cursor.getString(2));
        contact.setTel(cursor.getString(3));
        contact.setEmail(cursor.getString(4));
        contact.setDescription(cursor.getString(5));

        return contact;
    }

    public void updateContact(Contact contact) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Contact.Column.NAME, contact.getName());
        values.put(Contact.Column.ADDRESS, contact.getAddress());
        values.put(Contact.Column.TEL, contact.getTel());
        values.put(Contact.Column.EMAIL, contact.getEmail());
        values.put(Contact.Column.DESCRIPTION, contact.getDescription());
        System.out.println("4.bedit-bundle " + contact.getId());
        int row = sqLiteDatabase.update(Contact.TABLE,
                values,
                Contact.Column.ID + " = ? ",
                new String[]{String.valueOf(contact.getId())});

        sqLiteDatabase.close();
    }

    public void deleteContact(String id) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

    /*sqLiteDatabase.delete(Friend.TABLE, Friend.Column.ID + " = ? ",
            new String[] { String.valueOf(friend.getId()) });*/
        sqLiteDatabase.delete(Contact.TABLE, Contact.Column.ID + " = " + id, null);

        sqLiteDatabase.close();
    }
}

