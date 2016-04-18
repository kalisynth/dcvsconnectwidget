package org.dcvs.nac.dcvsconnectwidget;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Dcvshelp extends AppCompatActivity {

    public boolean isSkypeClientInstalled(Context skypeCall) {
        PackageManager myPackageMgr = skypeCall.getPackageManager();
        try {
            myPackageMgr.getPackageInfo("com.skype.raider", PackageManager.GET_ACTIVITIES);
        }
        catch (PackageManager.NameNotFoundException e) {
            return (false);
        }
        return (true);
    }

    public void goToMarket(Context skypeinstalled) {
        Uri marketUri = Uri.parse("market://details?id=com.skype.raider");
        Intent myIntent = new Intent(Intent.ACTION_VIEW, marketUri);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        skypeinstalled.startActivity(myIntent);
    }

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

    public void skypedcvs1call(String mySkypeDCVSv1){
        if (!isSkypeClientInstalled(this)) {
            goToMarket(this);
            return;
        }

        Uri skypeURI = Uri.parse(mySkypeDCVSv1);
        Intent skypedcvs1Intent = new Intent(Intent.ACTION_VIEW, skypeURI);

        skypedcvs1Intent.setComponent(new ComponentName("com.skype.raider", "com.skype.raider.Main"));
        skypedcvs1Intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        this.startActivity(skypedcvs1Intent);

    }


    public void skypehelpdeskonclick(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to call DCVS Help Desk");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        skypedcvs1call("skype:helpdeskdcvs?call&video=true");
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert1 = builder1.create();
        alert1.show();
    }

}


//com.teamviewer.quicksupport.market