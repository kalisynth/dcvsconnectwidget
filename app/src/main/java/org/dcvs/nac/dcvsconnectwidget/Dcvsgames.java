package org.dcvs.nac.dcvsconnectwidget;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dcvsgames extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcvsgames);
    }

    public void euchreonclick(View v){
        Intent euchreIntent = new Intent();
        PackageManager euchreManager = getPackageManager();
        euchreIntent = euchreManager.getLaunchIntentForPackage("uk.co.aifactory.euchre");
        euchreIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(euchreIntent);
        finish();
    }

    public void solitareonclick(View v) {
        Intent solitareIntent = new Intent();
        PackageManager solitareManager = getPackageManager();
        solitareIntent = solitareManager.getLaunchIntentForPackage("uk.co.aifactory.solitare");
        solitareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(solitareIntent);
        finish();
    }
}
