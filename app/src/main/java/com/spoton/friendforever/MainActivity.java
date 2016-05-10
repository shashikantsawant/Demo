package com.spoton.friendforever;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    String eventTime[];
    String yyyy="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateFormat year = new SimpleDateFormat("yyyy");
        yyyy =year.format(Calendar.getInstance().getTime());
        eventTime=new String[]{"Mar 22 14:00:00 GMT+05:30 "+yyyy,"Mar 22 13:47:20 GMT+05:30 "+yyyy,"Mar 22 13:47:40 GMT+05:30 "+yyyy};//00.01am, 10.00am,11.59pm

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd HH:mm:ss z yyyy");
        try {
            for (int j=0;j<1;j++)
            {
            Date mDate = sdf.parse(eventTime[j]);
            eventTime[j]= String.valueOf(mDate.getTime());
                Intent intent = new Intent(this, BirthdayReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),j, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, Long.parseLong(eventTime[j]), pendingIntent);
                        finish();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}