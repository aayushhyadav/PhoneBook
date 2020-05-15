package androidhands.com.my_phone_book;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//creating the table

public class ContactdbHelper extends SQLiteOpenHelper {

    //sql query
    public static final String CREATE_TABLE = " create table "+ Contact_Contract.ContactEntry.TABLE_NAME+
            "("+ Contact_Contract.ContactEntry.NAME+" text,"+ Contact_Contract.ContactEntry.PHONE+" text,"
            + Contact_Contract.ContactEntry.EMAIL+" text,"+ Contact_Contract.ContactEntry.DOB+" text);";

    //query to drop the table if already exists
    public static final String DROP_TABLE = "drop table if exists " + Contact_Contract.ContactEntry.TABLE_NAME;

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    public ContactdbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    //method to enable the user to enter data into the database
    public void addContact( String phone, String name, String dob, String email, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contact_Contract.ContactEntry.NAME, name);
        contentValues.put(Contact_Contract.ContactEntry.PHONE, phone);
        contentValues.put(Contact_Contract.ContactEntry.DOB, dob);
        contentValues.put(Contact_Contract.ContactEntry.EMAIL, email);

        database.insert(Contact_Contract.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations", "One row created...");

    }

    //method to read the database
    public Cursor readContact(SQLiteDatabase database){
        String[] projections = {Contact_Contract.ContactEntry.NAME, Contact_Contract.ContactEntry.PHONE, Contact_Contract.ContactEntry.DOB, Contact_Contract.ContactEntry.EMAIL};
        Cursor cursor = database.query(Contact_Contract.ContactEntry.TABLE_NAME, projections, null,null,null,null,null);

        //information in the cursor object
        return cursor;
    }

    //method to delete contact from the database
    public void deleteContact(String name, SQLiteDatabase database){
        String selection = Contact_Contract.ContactEntry.NAME+ "=" +"\""+ name +"\"";
        database.delete(Contact_Contract.ContactEntry.TABLE_NAME, selection, null);
    }

    //method to update the database
    public void updateContact(String name, String phone, String dob, String email, SQLiteDatabase database){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contact_Contract.ContactEntry.PHONE, phone);
        contentValues.put(Contact_Contract.ContactEntry.DOB, dob);
        contentValues.put(Contact_Contract.ContactEntry.EMAIL, email);
        String selection = Contact_Contract.ContactEntry.NAME+ "=" + "\""+ name+ "\"";

        database.update(Contact_Contract.ContactEntry.TABLE_NAME, contentValues, selection, null);

    }
}
