package com.example.renjitha.datetime4text;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.logging.Logger;

/**
 * Created by renjitha on 01-03-2017.
 */
public class notification_service extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        /*
        When the user taps the notification we have to show the Home Screen of our App,      this job can be done with the help of the following Intent.
                              */
        Intent intent1 = new Intent(this.getApplicationContext(),
                MainActivity.class);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(
                this.getApplicationContext(), 0, intent1,0);
     //  Notification notification = new Notification(R.drawable.lightbulb,"See My App something for you", System.currentTimeMillis());

        Notification n  = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            n = new Notification.Builder(this)
                    .setContentTitle("New mail from " + "test@gmail.com")
                    .setContentText("Subject")
                    .setSmallIcon(R.drawable.lightbulb)
                    .setContentIntent(pendingNotificationIntent)
                    .setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .build();
        }


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);



    }

    @Override
    public void onDestroy() {

        Log.e("Alam Services Destroyed", String.valueOf(getBaseContext()));
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
