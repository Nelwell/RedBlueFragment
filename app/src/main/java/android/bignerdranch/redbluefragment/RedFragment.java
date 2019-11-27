package android.bignerdranch.redbluefragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RedFragment extends Fragment {

    public interface OnRandomNumberGeneratedListener {
        void onRandomNumber(int number);
    }

    OnRandomNumberGeneratedListener mListener;
    Random mRandom;

    public RedFragment() {
        mRandom = new Random();
    }

    public static RedFragment newInstance() {
        return new RedFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_red, container, false);
        Button mRandomButton = view.findViewById(R.id.random_number_button);
        mRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = mRandom.nextInt(100);
                mListener.onRandomNumber(number);
            }
        });

        return view;
    }

    public void setOnRandomNumberGeneratedListener(OnRandomNumberGeneratedListener listener) {
        this.mListener = listener;
    }

}
