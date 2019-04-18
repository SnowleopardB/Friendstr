package com.example.friendstr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Friend> friends = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] friendsnames = {"Ada", "Arthur", "Curly", "Finn", "Freddie", "Grace", "John", "Micheal", "Polly", "Tommy"};
        String[] friendsbios = {"I am not a bloody Shelby", "Wash it down with a nice drink!", "No hart in motorcars", "I can't do it!", "The revolution is near!", "Now you've seen me", "Fucking waps", "Men and their cocks never cease to amaze me.", "I'm not a fucking kid anymore", "I do what I do to protect my family"};



        for (int i = 0; i < friendsnames.length; i++){
            int photoID = (int) getResources().getIdentifier("drawable", "drawable", friendsnames[i].toLowerCase());
            Friend friend = new Friend(photoID, friendsnames[i], friendsbios[i]);
            friends.add(friend);
            Log.d("allright","Friend: "+ i + friend);
        }
    }

}
