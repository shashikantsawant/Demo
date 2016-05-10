package com.spoton.friendforever;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by shashi on 16/3/16.
 */
public class Birthday extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView birthDay=(ImageView)  findViewById(R.id.imageView);
             birthDay.setImageResource(R.drawable.b2);
      }
}