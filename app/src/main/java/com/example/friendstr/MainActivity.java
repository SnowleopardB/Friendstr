package com.example.friendstr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] friendsnames = {"Ada", "Arthur", "Curly", "Finn", "Freddie", "Grace", "John", "Micheal", "Polly", "Tommy"};
        String[] friendsbios = {"I am not a bloody Shelby", "Wash it down with a nice drink!", "No hart in motorcars", "I can't do it!", "The revolution is near!", "Now you've seen me", "Fucking waps", "I'm not a fucking kid anymore", "Men and their cocks never cease to amaze me.", "I do what I do to protect my family"};

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        for (int i = 0; i < friendsnames.length; i++){
            int photoID = (int) getResources().getIdentifier(friendsnames[i].toLowerCase(), "drawable", getPackageName());
            Friend friend = new Friend(photoID, friendsnames[i], friendsbios[i]);
            friends.add(friend);
        }

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView grid_view = findViewById(R.id.gridview);
        grid_view.setAdapter(adapter);
        GridItemClickListener onclick = new GridItemClickListener();
        grid_view.setOnItemClickListener(onclick);
    }


    private class GridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
            // setContentView(R.layout.activity_profile);

            // does not seem to get here, question
            Log.d("allright", "waw" + clickedFriend);
        }



    }



}
