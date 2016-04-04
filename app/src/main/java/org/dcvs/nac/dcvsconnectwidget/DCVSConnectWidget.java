package org.dcvs.nac.dcvsconnectwidget;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class DCVSConnectWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dcvsconnect_widget);

        //Home goes home
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent homePendingIntent = PendingIntent.getActivity(context, appWidgetId, homeIntent, 0);
        views.setOnClickPendingIntent(R.id.homebtn, homePendingIntent);

        //Chat Button opens Chat Activity
        Intent chatIntent = new Intent();
        chatIntent.setAction(Intent.ACTION_VIEW);
        chatIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        chatIntent.setClassName("org.dcvs.nac.dcvsconnectwidget", "org.dcvs.nac.dcvsconnectwidget.Dcvschat");
        PendingIntent chatPendingIntent = PendingIntent.getActivity(context, appWidgetId, chatIntent, 0);
        views.setOnClickPendingIntent(R.id.chatbtn, chatPendingIntent);

        //Fun Button opens DCVS Fun Activity
        Intent funIntent = new Intent();
        funIntent.setAction(Intent.ACTION_VIEW);
        funIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        funIntent.setClassName("org.dcvs.nac.dcvsconnectwidget", "org.dcvs.nac.dcvsconnectwidget.Dcvsfun");
        PendingIntent funPendingIntent = PendingIntent.getActivity(context, appWidgetId, funIntent, 0);
        views.setOnClickPendingIntent(R.id.funbtn, funPendingIntent);

        //Help button opens DCVS help activity
        Intent helpIntent = new Intent();
        helpIntent.setAction(Intent.ACTION_VIEW);
        helpIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        helpIntent.setClassName("org.dcvs.nac.dcvsconnectwidget", "org.dcvs.nac.dcvsconnectwidget.Dcvshelp");
        PendingIntent helpPendingIntent = PendingIntent.getActivity(context, appWidgetId, helpIntent, 0);
        views.setOnClickPendingIntent(R.id.helpbtn, helpPendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

