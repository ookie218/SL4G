package com.example.android.sl4g;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

    // TODO: 4/6/2018 REFERENCE ALL BUTTONS ANS TEXTBOXES - FURTHER EXTRACT USER RESPONSES FROM THESE VARIABLES

//    EditText nameResponse = getActivity().findViewById(R.id.enterName);
//    EditText feebackResponse = getActivity().findViewById(R.id.enterFeedback);


}
