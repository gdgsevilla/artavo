package com.artavo;

import com.artavo.app.testUtils.MeetupEventTestBuilder;
import com.artavo.core.presenter.EventsFetcher;
import com.artavo.core.model.meetup.MeetupEvent;
import com.artavo.core.model.meetup.MeetupGroup;
import com.artavo.core.presenter.EventsCreatedPresenter;
import com.artavo.core.presenter.GroupsRepository;
import com.artavo.core.view.EventsCreatedView;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.artavo.app.testUtils.MeetupEventMatcher.hasTheSameEventId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anySetOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class EventsCreatedViewTest {

    @Test
    public void shouldHaveTheSameEventsCountThatRetrieved() throws Exception {

        //given
        final EventsFetcher eventsFetcher = mock(EventsFetcher.class);
        final GroupsRepository groupsRepository = mock(GroupsRepository.class);
        final EventsCreatedPresenter eventsCreatedPresenter = new EventsCreatedPresenter(eventsFetcher, groupsRepository);
        final List<MeetupEvent> meetupEvents = new ArrayList<>();
        final EventsCreatedView eventsCreatedView = new EventsCreatedView(meetupEvents, eventsCreatedPresenter);
        final MeetupEvent expectedEvent = new MeetupEventTestBuilder().id("fantastico").build();

        doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                ((EventsCreatedPresenter) invocation.getArguments()[1]).retrievedCreatedEvents(Collections.singletonList(expectedEvent));
                return null;
            }
        }).when(eventsFetcher).fetchCreatedEventsFor(anySetOf(MeetupGroup.class), eq(eventsCreatedPresenter));

        //when
        eventsCreatedView.onLoadDisplayCreatedEvents(eventsCreatedView);

        //then
        final List<MeetupEvent> events = eventsCreatedView.getEvents();
        assertThat(events.size(), is(1));
        assertThat(events.get(0), hasTheSameEventId(expectedEvent));
    }
}