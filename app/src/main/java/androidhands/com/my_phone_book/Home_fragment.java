package androidhands.com.my_phone_book;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_fragment extends Fragment implements View.OnClickListener {

    private Button bn_add_contact, bn_delete, bn_view, bn_update;

    OnDbOpListener onDbOpListener;
    public interface OnDbOpListener{
        public void dbOpperformed(int method);
    }

    public Home_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        bn_add_contact = view.findViewById(R.id.btn_add_contact);
        bn_add_contact.setOnClickListener(this);
        bn_update = view.findViewById(R.id.btnupdate);
        bn_delete = view.findViewById(R.id.btn_del_contact);
        bn_view = view.findViewById(R.id.btn_view_contacts);
        bn_view.setOnClickListener(this);
        bn_delete.setOnClickListener(this);
        bn_update.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_contact:
                onDbOpListener.dbOpperformed(0);
                break;

            case R.id.btn_view_contacts:
                onDbOpListener.dbOpperformed(1);
                break;

            case R.id.btn_del_contact:
                onDbOpListener.dbOpperformed(2);
                break;

            case R.id.btnupdate:
                onDbOpListener.dbOpperformed(3);
                break;
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        Activity activity = (Activity) context;

        //fragment can communicate with the activity with this interface
        //to ensure that activity implements the interface
        try {
            onDbOpListener = (OnDbOpListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement interface method");
        }
    }
}
