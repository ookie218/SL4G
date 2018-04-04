package com.example.android.sl4g;

/**
 * Created by ookie on 12/26/2017.
 */

public class Artist {

    private String mArtist;
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    //Set to -1, so it cannot be possible to reference another image
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceID;
    private int mBio; //Int because it will be an XML reference

    //If only Artist name is available
    public Artist(String artist) {
        mArtist = artist;
    }

    //If only artist name and pic reference are available
     public Artist(String artist, int imageResourceID) {
        mArtist = artist;
        mImageResourceID = imageResourceID;
    }

    //If only artist name, pic, and bio references are available
    public Artist(String artist, int imageResourceID, int bio) {
        mArtist = artist;
        mImageResourceID = imageResourceID;
        mBio = bio;
    }


    //If all components are available
    public Artist(String artist, int imageResourceID, int audioResourceID, int bio) {
        mArtist = artist;
        mImageResourceID = imageResourceID;
        mAudioResourceID = audioResourceID;
        mBio = bio;
    }

    public String getArtistName() {
        return mArtist;
    }

     int getImageResourceID() {
        return mImageResourceID;
    }

    public int getAudioResourceID() {
        return mAudioResourceID;
    }

    public int getBio() {
        return mBio;
    }


     boolean hasImage() {
        //If pic has ID, image will return, if not will default to -1
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

}
