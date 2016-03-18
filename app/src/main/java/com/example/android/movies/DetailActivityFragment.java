package com.example.android.movies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        // The detail Activity called via intent.  Inspect the intent for forecast data.
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);

            // Split the String
            String[] splitFor = forecastStr.split(" -- ");

            // Load the title string
            ((TextView) rootView.findViewById(R.id.title_textview))
                    .setText(splitFor[0]);

            // Load the ImageView
            final String BASE_URL = "http://image.tmdb.org/t/p/";
            final String SIZE = "w185";
            Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                    .appendPath(SIZE)
                    .appendPath(splitFor[1].substring(1, splitFor[1].length()))
                    .build();

            ImageView imageView = (ImageView) rootView.findViewById(R.id.poster_imageview);
            Glide.with(imageView.getContext()).load(builtUri).into(imageView);

            // Load the overview text
            ((TextView) rootView.findViewById(R.id.overview_textview))
                    .setText(splitFor[2]);

            // Load release text
            ((TextView) rootView.findViewById(R.id.release_textview))
                    .setText(splitFor[3]);

            //Load vote text
            ((TextView) rootView.findViewById(R.id.vote_textview))
                    .setText(splitFor[4] + " / 10");
        }

        return rootView;
    }
}
