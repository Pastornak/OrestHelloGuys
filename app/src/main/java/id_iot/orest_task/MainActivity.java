package id_iot.orest_task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment;
   // private Switch changeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
        showFragment(new GridViewFragment());
        //changeListView = (Switch) findViewById(R.id.change_list);
        //changeListView.setChecked(false);
        //if (changeListView.isChecked()) {
        //    showFragment(new GridViewFragment());
       // }
    }

    public void showFragment(Fragment fragment) {
        currentFragment = fragment;

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

