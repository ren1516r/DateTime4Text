package com.example.renjitha.datetime4text;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by renjitha on 01-03-2017.
 */
public class AlarmRecBroadcast extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Recccccccd00",Toast.LENGTH_LONG).show();
        Intent i_service=new Intent(context,notification_service.class);
        context.startService(i_service);
    }
}
