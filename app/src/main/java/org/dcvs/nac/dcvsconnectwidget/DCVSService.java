package org.dcvs.nac.dcvsconnectwidget;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RemoteViews;

/**
 * Created by Kalisynth on 15/04/2016.
 */
public class DCVSService extends Service {
    private RemoteViews dcvsView;

@Override
public IBinder onBind(Intent intent){
    return null;
}

    @Override
    public void onCreate(){
        super.onCreate();
        dcvsView = new RemoteViews(this.getPackageName(), R.layout.dcvsconnect_widget);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                0,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.RIGHT | Gravity.TOP;
        params.setTitle("DCVS");

        )
    }
}