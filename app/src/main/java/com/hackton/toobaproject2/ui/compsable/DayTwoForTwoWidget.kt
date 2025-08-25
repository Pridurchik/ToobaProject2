package com.hackton.toobaproject2.ui.compsable

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.hackton.toobaproject2.R

/**
 * Implementation of App Widget functionality.
 */
class DayTwoForTwoWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.day_two_for_two_widget)
            views.setTextViewText(R.id.title, "")
            views.setTextViewText(R.id.needed, "")
            views.setTextViewText(R.id.collected, "")
            views.setTextViewText(R.id.needed_sum, "")
            views.setTextViewText(R.id.collected_sum, "")

        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}
