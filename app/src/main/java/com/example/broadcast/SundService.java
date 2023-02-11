package com.example.broadcast;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class SundService extends Service {

    MediaPlayer mp;


    public SundService() {


    }

    @Override
    public void onCreate() {
        super.onCreate();

        mp = MediaPlayer.create(this,R.raw.sund);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                stopSelf();
            }
        });
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        if (!mp.isPlaying())
            mp.start();

        Log.d("Ziyad", "Service Started");

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
        Log.d("Ziyad", "Service destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}