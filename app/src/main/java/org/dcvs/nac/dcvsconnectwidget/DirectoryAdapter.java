package org.dcvs.nac.dcvsconnectwidget;

import android.database.DataSetObserver;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.videolan.libvlc.util.Extensions;

import java.io.File;
import java.util.ArrayList;

/**
 * List adapter used to drive the ListView in the activity.
 */
public class DirectoryAdapter extends BaseAdapter {
    public final static String TAG = "LibVLCAndroidSample/DirectoryAdapter";

    private ArrayList<String> mFiles = new ArrayList<String>();
    private boolean mAudio;

    public DirectoryAdapter() {
        mAudio = true;
    }

    public boolean isAudioMode() {
        return mAudio;
    }

    public void setAudioMode(boolean b) {
        mAudio = b;
    }

    @Override
    public int getCount() {
        return mFiles.size();
    }

    @Override
    public Object getItem(int position) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + '/' + mFiles.get(position);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getItemViewType(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = new TextView(parent.getContext());
        }
        ((TextView) v).setText(mFiles.get(position));

        return v;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() {
        return mFiles.isEmpty();
    }

    @Override
    public void registerDataSetObserver(DataSetObserver arg0) {
        super.registerDataSetObserver(arg0);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver arg0) {
        super.unregisterDataSetObserver(arg0);
    }

    @Override
    public boolean areAllItemsEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled(int arg0) {
        return true;
    }
}
