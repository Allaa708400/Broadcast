package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class HeadsetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {

            int state = intent.getIntExtra("state", -1);
            switch (state) {
                case 0:
                    context.stopService(new Intent(context, SundService.class));
                    Toast.makeText(context, "Un plugged", Toast.LENGTH_SHORT).show();

                    Log.d("Ziyad", "Un plugged");
                    break;
                case 1:
                    context.startService(new Intent(context, SundService.class));
                    Toast.makeText(context, "plugged", Toast.LENGTH_SHORT).show();
                    Log.d("Ziyad", "plugged");
                    break;
                default:
                    Toast.makeText(context, "I don't know", Toast.LENGTH_SHORT).show();
                    Log.d("Ziyad", "I don't know");
                    break;
            }
        }
    }
}