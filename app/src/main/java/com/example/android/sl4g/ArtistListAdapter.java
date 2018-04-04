package com.example.android.sl4g;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ookie on 12/28/2017.
 */

//Needed to pass in ArtistObject to the array Adapter we are extending!!!
public class ArtistListAdapter extends ArrayAdapter<Artist> {

    private Context mContext;
    private ArrayList<Artist> mArtistIds;

    public ArtistListAdapter(Activity context, ArrayList<Artist> artists) {
        super(context, 0, artists);
        mContext = context;
        mArtistIds = artists;
    }

    @Override
    public int getCount() {
        return mArtistIds.size();
    }

//    @Override
//    public Object getItem(int position) {
//        return null;
//    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
            R.layout.list_item, parent, false);
        }

        Artist currentArtist = (Artist) getItem(position);

        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name);

        if (currentArtist != null) {
            artistNameTextView.setText(currentArtist.getArtistName());
        }

        ImageView artistImage = listItemView.findViewById(R.id.artist_image);
        if (currentArtist != null) {
            if (currentArtist.hasImage()) {
                artistImage.setImageResource(currentArtist.getImageResourceID());
                artistImage.setVisibility(View.VISIBLE);
            } else {
                artistImage.setVisibility(View.GONE);
            }
        }


        return listItemView;
    }

}
