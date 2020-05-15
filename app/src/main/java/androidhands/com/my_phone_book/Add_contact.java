package androidhands.com.my_phone_book;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Add_contact extends Fragment {

    EditText name, dob, phone, email;
    private Button bn_save;
    public Add_contact() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        name = view.findViewById(R.id.edit_name);
        phone = view.findViewById(R.id.edit_phone_del);
        dob = view.findViewById(R.id.edit_dob);
        email = view.findViewById(R.id.edit_email);
        bn_save = view.findViewById(R.id.btn_save_contact);

        bn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Phone = phone.getText().toString();
                String Dob = dob.getText().toString();
                String Email = email.getText().toString();
                ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());

                //requesting for a writable database
                //for creating real life apps create the database in the background thread
                //to prevent your app from pauses
                SQLiteDatabase database = contactdbHelper.getWritableDatabase();
                contactdbHelper.addContact(Phone, Name, Dob, Email, database);
                contactdbHelper.close();
                phone.setText("");
                name.setText("");
                dob.setText("");
                email.setText("");
                Toast.makeText(getActivity(), "Contact Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
