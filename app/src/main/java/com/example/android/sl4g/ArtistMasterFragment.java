package com.example.android.sl4g;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistMasterFragment extends Fragment {


    public ArtistMasterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_artist_master, container, false);

        final ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Deane Walden", R.drawable.deaneprofilepic, R.string.deane_bio));
        artists.add(new Artist("Ron Rhythm", R.drawable.ronprofilepic, R.string.ron_bio));
        artists.add(new Artist("Ookie Ebron", R.drawable.ookieprofilepic, R.string.ookie_bio));
        artists.add(new Artist("SHEESH", R.drawable.samprofilepic, R.string.sam_bio));
        artists.add(new Artist("JuJu", R.drawable.jujuprofilepic, R.string.juju_bio));
        artists.add(new Artist("JMask", R.drawable.jmaskprofilepic, R.string.jmask_bio));

        ListView artistListView = rootview.findViewById(R.id.artist_list);

        ArtistListAdapter artistListAdapter = new ArtistListAdapter(getActivity(), artists);

        artistListView.setAdapter(artistListAdapter);

        artistListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist currentArtist = artists.get(position); //Reference specific artist

                //Get references to details of current item
                String artistName = currentArtist.getArtistName();

                //int artistPic = currentArtist.getImageResourceID();
                //Get artist photo
                //Convert to Bitmap - then to Byte Array
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), currentArtist.getImageResourceID());
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();


                int artistBio = currentArtist.getBio(); //Pass in (int) since its an XML file

                //Create intent and pass in items to go with it
                Intent artistDetailIntent = new Intent(getContext(), ArtistDetail.class);
                artistDetailIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                artistDetailIntent.putExtra("Artist Name", artistName);
                artistDetailIntent.putExtra("Artist Pic", byteArray);
                artistDetailIntent.putExtra("Artist Bio", artistBio);
                startActivity(artistDetailIntent); //Start activity with new Intent
            }
        });

        //Return inflated view of custom layout
        return rootview;

    }

}
