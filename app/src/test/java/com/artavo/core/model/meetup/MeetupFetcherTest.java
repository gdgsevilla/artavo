package com.artavo.core.model.meetup;

import com.artavo.app.testUtils.MeetupEventTestBuilder;
import com.artavo.core.presenter.RetrievedCreatedEventsListener;
import org.junit.Before;
import org.junit.Test;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MeetupFetcherTest {

    private MeetupFetcher meetupFetcher;
    private Set<MeetupGroup> groups;
    private RetrievedCreatedEventsListener listener;
    private MeetupEndpoint meetupEndpoint;


    @Before
    public void setUp() throws Exception {
        meetupEndpoint = mock(MeetupEndpoint.class);
        groups = Collections.singleton(new MeetupGroup("joinmode", 1, "caca", 2, 3, "urlName", 4, "who"));
        listener = mock(RetrievedCreatedEventsListener.class);

        meetupFetcher = new MeetupFetcher(meetupEndpoint);
    }

    @Test
    public void shouldReturnAnEmptyListIfAnythingGoesWrong() throws Exception {
        //given
        when(meetupEndpoint.getEventsFor(anyLong())).thenReturn(new FailureMeetupEventsResponseCall());

        //when
        meetupFetcher.fetchCreatedEventsFor(groups, listener);

        //then
        verify(listener).retrievedCreatedEvents(Collections.<MeetupEvent>emptyList());

    }

    @Test
    public void shouldNotifyOfRetrievedEvents() throws Exception {
        //given
        final List<MeetupEvent> expectedEvents = Collections.singletonList(new MeetupEventTestBuilder().build());

        when(meetupEndpoint.getEventsFor(anyLong())).thenReturn(new SuccessMeetupEventsResponseCall(new MeetupEventsResponse(expectedEvents, null)));

        //when
        meetupFetcher.fetchCreatedEventsFor(groups, listener);

        //then
        verify(listener).retrievedCreatedEvents(expectedEvents);
    }

    private static class FailureMeetupEventsResponseCall implements Call<MeetupEventsResponse> {
        @Override
        public Response<MeetupEventsResponse> execute() throws IOException {
            throw new RuntimeException(" " + " execute " + " IMPLEMENT ME MADAFACKER! ");
        }

        @Override
        public void enqueue(final Callback<MeetupEventsResponse> callback) {
            callback.onFailure(new Exception("la liaste flanagan"));
        }

        @Override
        public void cancel() {
            throw new RuntimeException(" " + " cancel " + " IMPLEMENT ME MADAFACKER! ");
        }

        @SuppressWarnings("CloneDoesntCallSuperClone")
        @Override
        public Call<MeetupEventsResponse> clone() {
            throw new RuntimeException(" " + " clone " + " IMPLEMENT ME MADAFACKER! ");
        }
    }

    private static class SuccessMeetupEventsResponseCall implements Call<MeetupEventsResponse> {
        private final Response<MeetupEventsResponse> meetupEventsResponse;

        public SuccessMeetupEventsResponseCall(final MeetupEventsResponse meetupEventsResponse) {
            this.meetupEventsResponse = Response.success(meetupEventsResponse);
        }

        @Override
        public Response<MeetupEventsResponse> execute() throws IOException {
            throw new RuntimeException(" " + " execute " + " IMPLEMENT ME MADAFACKER! ");
        }

        @Override
        public void enqueue(final Callback<MeetupEventsResponse> callback) {
            callback.onResponse(meetupEventsResponse, null);
        }

        @Override
        public void cancel() {
            throw new RuntimeException(" " + " cancel " + " IMPLEMENT ME MADAFACKER! ");
        }

        @SuppressWarnings("CloneDoesntCallSuperClone")
        @Override
        public Call<MeetupEventsResponse> clone() {
            throw new RuntimeException(" " + " clone " + " IMPLEMENT ME MADAFACKER! ");
        }
    }
}