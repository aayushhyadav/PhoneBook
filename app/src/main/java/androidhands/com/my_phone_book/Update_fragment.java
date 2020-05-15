package androidhands.com.my_phone_book;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Update_fragment extends Fragment {

    private Button save;
    EditText name, phone, dob, email;
    private TextView n, p, d, e;

    public Update_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_fragment, container, false);
        save = view.findViewById(R.id.btn_savecontact);
        name = view.findViewById(R.id.editname);
        phone = view.findViewById(R.id.editphone);
        dob = view.findViewById(R.id.editdob);
        email = view.findViewById(R.id.editemail);
        n = view.findViewById(R.id.txtname);
        p = view.findViewById(R.id.txtnumber);
        d = view.findViewById(R.id.txtdob);
        e = view.findViewById(R.id.txtemail);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });
        return view;
    }

    public void updateContact(){
        String Name = name.getText().toString();
        String Phone = phone.getText().toString();
        String Dob = dob.getText().toString();
        String Email = email.getText().toString();

        ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
        SQLiteDatabase database = contactdbHelper.getWritableDatabase();

        contactdbHelper.updateContact(Name, Phone, Dob, Email, database);
        contactdbHelper.close();

        Toast.makeText(getActivity(), "Contact Updated", Toast.LENGTH_SHORT).show();

        name.setText("");
        phone.setText("");
        dob.setText("");
        email.setText("");
    }

}
