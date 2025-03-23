package com.example.sirawich_478;

import android.provider.BaseColumns;

public class Contact {
    public static final String DATABASE_NAME = "contacts.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "contact";

    private Integer id;
    private String name;
    private String address;
    private String tel;
    private String email;
    private String description;

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String NAME = "name";
        public static final String ADDRESS = "address";
        public static final String TEL = "tel";
        public static final String EMAIL = "email";
        public static final String DESCRIPTION = "description";
    }
    //Default Constructor
    public Contact() {

    }
    //Constructor
    public Contact(Integer id, String name, String address, String tel,
                   String email, String description) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.description = description;

    }
    //Getter, Setter
    Integer getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    String getAddress(){
        return this.address;
    }
    String getTel(){
        return this.tel;
    }
    String getEmail(){
        return this.email;
    }
    String getDescription(){
        return this.description;
    }
    void setId(Integer Id){
        this.id = Id;
    }
    void setName(String Name){
        this.name = Name;
    }
    void setAddress(String Address){
        this.address = Address;
    }
    void setTel(String tel){
        this.tel = tel;
    }
    void setEmail(String email){
        this.email = email;
    }
    void setDescription(String description){
        this.description = description;
    }
}

