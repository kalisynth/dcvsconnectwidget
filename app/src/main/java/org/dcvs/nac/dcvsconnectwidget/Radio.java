package org.dcvs.nac.dcvsconnectwidget;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;

public class Radio extends Activity {

    public final static String TAG = "dcvsconnectwidget/Radio";

    DirectoryAdapter mAdapter;
    LibVLC mLibVLC = null;
    MediaPlayer mMediaPlayer = null;

    boolean mPlayingVideo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
    }

    View.OnClickListener mSimpleListener = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {

        }
    };

//TODO: Complete by copying https://www.google.com.au/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&ved=0ahUKEwjLrYeambDMAhWHKJQKHddrDwEQFggeMAA&url=https%3A%2F%2Fbitbucket.org%2Fedwardcw%2Flibvlc-android-sample&usg=AFQjCNGBTkoL2rgRAbkkZ_oReb9o-Ui6Kw&bvm=bv.120853415,d.dGo&cad=rja
}
