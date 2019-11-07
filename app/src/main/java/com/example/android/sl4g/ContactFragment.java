package com.example.android.sl4g;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    EditText nameResponse, feedbackResponse;
    public static String[] sl4gEmail = {"switchinlanes4god@gmail.com"};

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_booking, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Reference the Views
        nameResponse = getView().findViewById(R.id.enterName);
        feedbackResponse = getView().findViewById(R.id.enterFeedback);
        Button prayerButton = getView().findViewById(R.id.prayerButton);

        prayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the values AFTER user clicks button with GETTEXT()!!!
                String name = nameResponse.getText().toString();
                String text = feedbackResponse.getText().toString();
                composeEmail(sl4gEmail, name, text);
            }
        });
    }


    public void composeEmail(String[] addresses, String subject, String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);

        //set package:
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

        startActivity(intent);
    }


}
