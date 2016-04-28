package org.dcvs.nac.dcvsconnectwidget;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.MediaPlayer;

public class dcvsRadio extends AppCompatActivity {

    /*LibVLC mLibVLC = null;
    MediaPlayer mMediaPlayer = null;

    boolean mPlayingRadio = false;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcvs_radio);
    }

    private void launchVLC(String url)
    {
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=org.videolan.vlc");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    private void pausestopVLC(String com)
    {
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setComponent(new ComponentName("org.videolan.vlc", "org.videolan.vlc.gui.video.VideoPlayerActivity"));
            i.setData(Uri.parse(com));
            startActivity(i);
        }
        catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=org.videolan.vlc");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    public void onClickPlay(View v){
        launchVLC("http://janus.cdnstream.com:5189/live");

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory(Intent.CATEGORY_HOME);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(homeIntent);
            }
        },3000);
        /*
        Intent radioIntent = new Intent();
        radioIntent.setAction(Intent.ACTION_VIEW);
        radioIntent.setClassName("org.dcvs.nac.dcvsconnectwidget", "org.dcvs.nac.dcvsconnectwidget.dcvsRadio");
                startActivity(radioIntent);
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(homeIntent);*/
        /*Uri streamUrl = Uri.parse("http://janus.cdnstream.com:5189/live");
        Intent playIntent = new Intent("org.videolan.vlc.gui.tv.audioplayer.AudioPlayerActivity");
        playIntent.setAction(Intent.ACTION_VIEW);
        playIntent.setData(streamUrl);
        startActivity(playIntent);*/
    }

    public void onClickPause(View v){
        pausestopVLC("Pause");
    }

    public void onClickStop(View v){
        pausestopVLC("Stop");
    }
}

