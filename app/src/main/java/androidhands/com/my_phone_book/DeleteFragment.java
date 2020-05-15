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
public class DeleteFragment extends Fragment {

    private Button bn_delete;
    EditText name;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        bn_delete = view.findViewById(R.id.btn_delete);
        name = view.findViewById(R.id.name);
        bn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        return view;
    }

    private void deleteContact(){
        ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
        SQLiteDatabase database = contactdbHelper.getWritableDatabase();

        String Name = name.getText().toString();
        contactdbHelper.deleteContact(Name, database);
        contactdbHelper.close();

        name.setText("");
        Toast.makeText(getActivity(), "Contact deleted", Toast.LENGTH_SHORT).show();
    }

}
