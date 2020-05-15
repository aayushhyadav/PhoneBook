package androidhands.com.my_phone_book;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Read_fragment extends Fragment {

    private TextView display;
    public Read_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_fragment, container, false);
        display = view.findViewById(R.id.txt_display);
        readContacts();
        return view;
    }

    public void readContacts(){
        ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
        SQLiteDatabase database = contactdbHelper.getReadableDatabase();

        Cursor cursor = contactdbHelper.readContact(database);
        String info = "";
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(Contact_Contract.ContactEntry.NAME));
            String phone = cursor.getString(cursor.getColumnIndex(Contact_Contract.ContactEntry.PHONE));
            String dob = cursor.getString(cursor.getColumnIndex(Contact_Contract.ContactEntry.DOB));
            String email = cursor.getString(cursor.getColumnIndex(Contact_Contract.ContactEntry.EMAIL));

            info = info + "\n\n" + "NAME    : " + name + "\nPHONE : " + phone + "\nDOB      : " + dob +
                        "\nEMAIL : " + email + "\n\n"+ "-------------------------------------------------------------------------";
        }

        display.setText(info);
        contactdbHelper.close();
    }
}
