package androidhands.com.my_phone_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Home_fragment.OnDbOpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding the home fragment to the main activity
        //checking if the fragment already exists
        if(findViewById(R.id.fragment_container) !=  null){
            if(savedInstanceState != null){
                return;
            }
        }

        Home_fragment home_fragment = new Home_fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, home_fragment).commit();
    }

    @Override
    public void dbOpperformed(int method){
        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Add_contact()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Read_fragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DeleteFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Update_fragment()).addToBackStack(null).commit();
                break;
        }
    }
}
