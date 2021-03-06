package com.artavo.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.artavo.app.meetup.MeetupEvent;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements EventsListener, View.OnClickListener {

    @Inject
    EventsFetcher eventsFetcher;

    private RecyclerView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).component().inject(this);

        findViewById(R.id.fetchEvents).setOnClickListener(this);
        eventList = ((RecyclerView) findViewById(R.id.eventList));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        eventList.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(final View view) {
        eventsFetcher.getEventsFrom("18997976", this);
    }

    @Override
    public void onEvents(final List<MeetupEvent> events) {
        eventList.setAdapter(new EventAdapter(events));
    }
}
