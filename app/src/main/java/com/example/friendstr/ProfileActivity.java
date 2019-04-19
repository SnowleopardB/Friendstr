package com.example.friendstr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) ((Intent) intent).getSerializableExtra("clicked_friend");

        ImageView image = (ImageView) findViewById(R.id.imageView2);
        image.setImageResource(retrievedFriend.getDrawableId());

        TextView name = (TextView) findViewById(R.id.textView2);
        name.setText(retrievedFriend.getName());

        TextView bio = (TextView) findViewById(R.id.textView3);
        bio.setText(retrievedFriend.getName());

    }

}
