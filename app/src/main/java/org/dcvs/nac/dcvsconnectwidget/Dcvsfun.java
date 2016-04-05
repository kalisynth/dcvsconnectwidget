package org.dcvs.nac.dcvsconnectwidget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dcvsfun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcvsfun);
    }

    public void gamesonclick(View v) {
        startActivity(new Intent(Dcvsfun.this, Dcvsgames.class));
        finish();
    }

    public void internetonClick(View v) { startActivity(new Intent(Dcvsfun.this, DcvsInternet.class)); finish();}
}


