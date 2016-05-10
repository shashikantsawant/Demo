package com.spoton.friendforever;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

public class BirthdayReceiver extends BroadcastReceiver {
    int value = 0, key = 0, i = 0;
    public static NotificationManager nm = null;
    Notification notification = null;
    public static MediaPlayer mp = null;
    PendingIntent pIntent;
    PendingIntent pendingIntent;
    int count=0;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(final Context context, Intent intent) {



        nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        mp = MediaPlayer.create(context, R.raw.ringtone);

        value = intent.getIntExtra("value", 0);
        key = intent.getIntExtra("key", 0);


            if (value == 1) // NOTIFICATION......
            {
                mp.start();
                nm.cancel(1);
                nm.cancel(0);

                Intent in = new Intent();
                in.setClassName("com.spoton.friendforever", "com.spoton.friendforever.Birthday");
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
            }

            if (key == 1) //CLOSE BUTTON...
            {
                if (mp != null) {
                    mp.stop();
                }
                nm.cancel(0);
                nm.cancel(1);
            }

            Intent intent2 = new Intent(context, BirthdayReceiver.class);
            intent2.putExtra("key", 1);
            intent2.putExtra("value", 0);
            pIntent = PendingIntent.getBroadcast(context, 0, intent2, Intent.FILL_IN_DATA);

            Intent intent1 = new Intent(context, BirthdayReceiver.class);
            intent1.putExtra("key", 0);
            intent1.putExtra("value", 1);
            pendingIntent = PendingIntent.getBroadcast(context, 1, intent1, Intent.FILL_IN_DATA);


        notification = new Notification.Builder(context).setContentTitle("Happy Birthday.").setContentText("Wishing You...")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .addAction(0, "  Close  ", pIntent)
                .setAutoCancel(true)
                .build();

        notification.flags = Notification.FLAG_ONGOING_EVENT;
        if (i == 0) {
            nm.notify(1, notification);
        }
       }

}
