package com.artavo.app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.artavo.app.meetup.MeetupEvent;
import java.util.List;

class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<MeetupEvent> events;

    public EventAdapter(final List<MeetupEvent> events) {
        this.events = events;
    }

    @Override
    public EventViewHolder onCreateViewHolder(final ViewGroup viewGroup, final int i) {
        TextView v = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_row, viewGroup, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final EventViewHolder holder, final int position) {
        holder.eventName.setText(events.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
