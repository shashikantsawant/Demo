package com.spoton.friendforever;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by shashi on 22/3/16.
 */
public class MyAlert extends Activity {

    int i=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide activity title

    }
    public int Alart()
       {
        AlertDialog.Builder Builder = new AlertDialog.Builder(MyAlert.this)
                .setMessage("Do You Want Start?")
                .setTitle("Happy Birthday")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        BirthdayReceiver.nm.cancel(0);
                        BirthdayReceiver.nm.cancel(1);
                        i=0;

                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        i = 1;
                    }
                });
           if(i==0)return i;
           if(i==1)return i;
        AlertDialog alertDialog = Builder.create();
        alertDialog.show();


           return 0;
       }

}