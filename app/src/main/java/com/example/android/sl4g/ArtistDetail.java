package com.example.android.sl4g;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_detail);


        Intent intent = getIntent(); //Grab intent

        //Extract Name
        String artistName = intent.getStringExtra("Artist Name"); //Find Name

        //Extract Bio
        int extraResourceId = getIntent().getIntExtra("Artist Bio", 0); //Find Bio
        String artistBio = getString(extraResourceId); //Convert XML int resource to String

        //Extract Photo
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = new byte[0];
        if (extras != null) {
            byteArray = extras.getByteArray("Artist Pic");
        }

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView artistPhoto = findViewById(R.id.artist_head);

        //Need image passed in
        //ImageView artistPic = String.valueOf(intent.getStringExtra("Artist Pic"));

        TextView artistNamePlacement = findViewById(R.id.artist_tag);
        TextView artistBioPlacement = findViewById(R.id.artist_body);

        artistNamePlacement.setText(artistName);
        artistBioPlacement.setText(artistBio);
        artistPhoto.setImageBitmap(bmp);


    }
}
