package org.dcvs.nac.dcvsconnectwidget;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Dcvschat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcvschat);
    }

    public void skypeonclick(View v){
        Intent skypeIntent = new Intent();
        PackageManager skypeManager = getPackageManager();
        skypeIntent = skypeManager.getLaunchIntentForPackage("com.skype.raider");
        skypeIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(skypeIntent);
        finish();
    }

    public void googleonclick(View v){
        Intent googleIntent = new Intent();
        PackageManager googleManager = getPackageManager();
        googleIntent = googleManager.getLaunchIntentForPackage("com.google.android.talk");
        googleIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(googleIntent);
        finish();
    }
}
