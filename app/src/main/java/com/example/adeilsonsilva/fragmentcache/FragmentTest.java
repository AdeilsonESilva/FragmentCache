package com.example.adeilsonsilva.fragmentcache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentTest extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        int position = getArguments().getInt("Position");
        String timestamp = getArguments().getString("Timestamp");

        Button button = (Button) view.findViewById(R.id.button);
        button.setText("See my name: position: " + position + " time: " + timestamp);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        switch (position){
            case 0:
                textView.setText("I always change: " + timestamp + ", go to fragment three and come back.");
                break;
            case 1:
                textView.setText("I'm never changed: " + timestamp + ", see my time.");
                break;
            case 2:
                textView.setText("I always change: " + timestamp + ", go to fragment one and come back.");
                break;
        }

        //Toast.makeText(getActivity(), "My name was changed: position: " + position + ", time: " + timestamp, Toast.LENGTH_LONG).show();

        return view;
    }

    public static FragmentTest newInstance(int position, String timestamp) {


        FragmentTest f = new FragmentTest();
        Bundle args = new Bundle();
        args.putInt("Position", position);
        args.putString("Timestamp", timestamp);
        f.setArguments(args);
        return f;
    }
}
