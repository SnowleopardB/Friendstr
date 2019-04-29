package com.example.friendstr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        retrievedFriend = (Friend) ((Intent) intent).getSerializableExtra("clicked_friend");


        ImageView image = (ImageView) findViewById(R.id.imageView2);
        image.setImageResource(retrievedFriend.getDrawableId());

        TextView name = (TextView) findViewById(R.id.textView2);
        name.setText(retrievedFriend.getName());

        TextView bio = (TextView) findViewById(R.id.textView3);
        bio.setText(retrievedFriend.getBio());

        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        rating.setOnRatingBarChangeListener(new Ratingbarchange());
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float stars = prefs.getFloat(retrievedFriend.getName(), 0);
        rating.setRating(stars);

    }
    class Ratingbarchange implements RatingBar.OnRatingBarChangeListener{
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            String name = retrievedFriend.getName();
            editor.putFloat(name, rating);
            editor.commit();
        }
    }

}
