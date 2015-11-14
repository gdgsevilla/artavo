package com.artavo.app;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

class EventViewHolder extends RecyclerView.ViewHolder {

    public TextView eventName;

    public EventViewHolder(final TextView view) {
        super(view);
        eventName = view;
    }
}
