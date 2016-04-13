package org.dcvs.nac.dcvsconnectwidget;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Dcvshelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcvshelp);
    }

    public void helpguideonclick(View v){
    Intent helpguideIntent;
        PackageManager helpguideManager = getPackageManager();
        helpguideIntent = helpguideManager.getLaunchIntentForPackage("appinventor.ai_tim.DCVSHelpGuide");
        helpguideIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(helpguideIntent);
        finish();
    }

    public void quicksupportclick(View v){
        Intent quicksupportIntent;
        PackageManager quicksupportmanager = getPackageManager();
        quicksupportIntent = quicksupportmanager.getLaunchIntentForPackage("com.teamviewer.quicksupport.samsung");
        quicksupportIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(quicksupportIntent);
        finish();
    }
}


//com.teamviewer.quicksupport.market