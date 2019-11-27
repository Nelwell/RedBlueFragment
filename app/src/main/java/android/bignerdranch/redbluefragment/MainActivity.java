package android.bignerdranch.redbluefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements RedFragment.OnRandomNumberGeneratedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the RedFragment, show on screen
        RedFragment redFragment = RedFragment.newInstance();
        redFragment.setOnRandomNumberGeneratedListener(this);

        BlueFragment blueFragment = BlueFragment.newInstance(0);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.red_fragment_container, redFragment);
        ft.add(R.id.blue_fragment_container, blueFragment);

        ft.commit();

    }

    @Override
    public void onRandomNumber(int number) {
        // Create and show new BlueFragment, providing the number in a bundle
        FragmentManager fm = getSupportFragmentManager();
        BlueFragment blueFragment = (BlueFragment) fm.findFragmentById(R.id.blue_fragment_container);
        blueFragment.setRandomNumber(number);
//        FragmentTransaction ft = fm.beginTransaction();
//        BlueFragment blueFragment = BlueFragment.newInstance(number);
//        ft.replace(R.id.fragment_container, blueFragment);
//        ft.addToBackStack(null);
//        ft.commit();
    }


//        // Show one of the fragments
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add(R.id.fragment_container, mRedFragment);
//        ft.commit();
//
//        // Listener to call opposite fragment to whole screen
//        View mainView = findViewById(android.R.id.content);
//        mainView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                swapFragments();
//            }
//        });
//    }
//
//    private void swapFragments() {
//
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        // If showing the RedFragment,
//        if (fm.findFragmentById(R.id.fragment_container) == mRedFragment) {
//            // Replace with blue fragment
//            ft.replace(R.id.fragment_container, mBlueFragment);
//        } else {
//            // Replace with red fragment
//            ft.replace(R.id.fragment_container, mRedFragment);
//        }
//
//        ft.commit();
//    }
}
