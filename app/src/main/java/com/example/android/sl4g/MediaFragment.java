package com.example.android.sl4g;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MediaFragment extends Fragment {

    public static String instagramUrl = "http://www.instagram.com/switchinlanes4g";
    public static String twitterUrl = "http://www.twitter.com/switchinlanes4g";
    public static String youtubeUrl = "http://www.youtube.com/user/switchinlanes4god";
    public static String sl4gEmail = "switchinlanes4god@gmail.com";
    public static String websiteUrl = "http://www.sl4g.com";
    public static String rhythmOfHeavenUrl = "https://itunes.apple.com/us/album/rhythm-of-heaven/1216497679";
    public static String noBrakesUrl = "https://itunes.apple.com/us/album/no-brakes/1343983901";

    private FragmentActivity myContext;
    private YouTubePlayer yPlayer;

    public static final String API_KEY = "AIzaSyBKzA3jqDvEd6SvrUAR8ECD7_5MgDlhPJc";
    public static final String VIDEO_ID = "0taaCWMbJz0";


    public MediaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        if (context instanceof FragmentActivity) {
            myContext = (FragmentActivity) context;
        }
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView websiteTextView = getView().findViewById(R.id.websiteTextView);
        websiteTextView.setClickable(true);
        websiteTextView.setMovementMethod(LinkMovementMethod.getInstance());
        String websiteText = "<a href='http://www.sl4g.com'> SL4G.COM </a>";
        websiteTextView.setText(Html.fromHtml(websiteText));


        ImageButton twitterButton = getView().findViewById(R.id.twitterButton);
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTwitter(getView());
            }
        });

        ImageButton instagramButton = getView().findViewById(R.id.instagramButton);
        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagram(getView());
            }
        });

        ImageButton youtubeButton = getView().findViewById(R.id.youtubeButton);
        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYoutube(getView());
            }
        });

        ImageButton aRoadLessTraveledButton = getView().findViewById(R.id.aRoadLessTraveledButton);
        aRoadLessTraveledButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite(getView());
            }
        });

        ImageButton waterWalkinButton = getView().findViewById(R.id.waterWalkinButton);
        waterWalkinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite(getView());
            }
        });

        ImageButton noLongerBoundButton = getView().findViewById(R.id.noLongerBoundButton);
        noLongerBoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebsite(getView());
            }
        });

        ImageButton rhythmOfHeavenButton = getView().findViewById(R.id.rhythmOfHeavenButton);
        rhythmOfHeavenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyRhythmOfHeaven(getView());
            }
        });

        ImageButton noBrakesButton = getView().findViewById(R.id.noBrakesButton);
        noBrakesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyNoBrakes(getView());
            }
        });


        YouTubePlayerSupportFragment youtubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment, youtubePlayerFragment).commit();

        youtubePlayerFragment.initialize("DEVELOPER_KEY", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    yPlayer = youTubePlayer;
                    yPlayer.setFullscreen(false);
                    yPlayer.cueVideo(VIDEO_ID);
                    setRetainInstance(true); //Continue to have video play on orientation change
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }


        });


    }

    public void openTwitter(View view) {
        Uri twitterUri = Uri.parse(twitterUrl);
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW, twitterUri);

        //Checks to see if Twiiter app can open intent
        twitterIntent.setPackage("com.twitter.android");

        try {
            startActivity(twitterIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.twitter.com/switchinlanes4g")));
        }
    }

    public void openInstagram(View view) {
        Uri instagramUri = Uri.parse(instagramUrl);
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, instagramUri);

        //Checks to see if Instagram app can open intent
        instagramIntent.setPackage("com.instagram.android");

        try {
            startActivity(instagramIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.instagram.com/switchinlanes4g")));
        }
    }

    public void openYoutube(View view) {
        Uri youtubeUri = Uri.parse(youtubeUrl);
        Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, youtubeUri);

        //Checks to see if Youtube app can open intent
        youtubeIntent.setPackage("com.youtube.android");

        try {
            startActivity(youtubeIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/user/switchinlanes4god")));
        }
    }

    public void openWebsite(View view) {
        Uri websiteUri = Uri.parse(websiteUrl);
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, websiteUri);

        //Checks to see if Youtube app can open intent
        websiteIntent.setPackage("com.android.chrome");

        try {
            startActivity(websiteIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.sl4g.com")));
        }
    }

    public void buyRhythmOfHeaven(View view) {
        Uri rhythmOfHeavenUri = Uri.parse(rhythmOfHeavenUrl);
        Intent rhythmOfHeavenIntent = new Intent(Intent.ACTION_VIEW, rhythmOfHeavenUri);

        try {
            startActivity(rhythmOfHeavenIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://itunes.apple.com/us/album/rhythm-of-heaven/1216497679")));
        }
    }

    public void buyNoBrakes(View view) {
        Uri noBrakesUri = Uri.parse(noBrakesUrl);
        Intent noBrakesIntent = new Intent(Intent.ACTION_VIEW, noBrakesUri);

        try {
            startActivity(noBrakesIntent);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://itunes.apple.com/us/album/no-brakes/1343983901")));
        }
    }

}
