package org.dcvs.nac.dcvsconnectwidget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Dcvschat extends AppCompatActivity {

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
        setContentView(R.layout.activity_dcvschat);
    }

    public void skypeonclick(View v){
        Intent skypeIntent;
        PackageManager skypeManager = getPackageManager();
        skypeIntent = skypeManager.getLaunchIntentForPackage("com.skype.raider");
        skypeIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(skypeIntent);
        finish();
    }

    public void googleonclick(View v){
        Intent googleIntent;
        PackageManager googleManager = getPackageManager();
        googleIntent = googleManager.getLaunchIntentForPackage("com.google.android.talk");
        googleIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(googleIntent);
        finish();
    }

    public void skypedcvs1call(Context skypeCalldcvsv1, String mySkypeDCVSv1){
        if (!isSkypeClientInstalled(skypeCalldcvsv1)) {
            goToMarket(skypeCalldcvsv1);
            return;
        }

        Uri skypeURI = Uri.parse(mySkypeDCVSv1);
        Intent skypedcvs1Intent = new Intent(Intent.ACTION_VIEW, skypeURI);

        skypedcvs1Intent.setComponent(new ComponentName("com.skype.raider", "com.skype.raider.Main"));
        skypedcvs1Intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        skypeCalldcvsv1.startActivity(skypedcvs1Intent);

    }

    public void skypev1onclick(View v){
        skypedcvs1call(this, "skype:volunteer1dcvs?call&video=true");
    }

    public void skypev2onclick(View v){
        skypedcvs1call(this, "skype:volunteer2dcvs?call&video=true");
    }

    public void skypeofficeonclick(View v){
        skypedcvs1call(this, "skype:dcvsoffice?call&video=true");
    }

    public void skypehelpdeskonclick(View v){
        skypedcvs1call(this, "skype:helpdeskdcvs?call&video=true");
    }




}
