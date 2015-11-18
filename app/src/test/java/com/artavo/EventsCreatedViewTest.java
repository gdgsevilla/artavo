package com.artavo;

import com.artavo.app.testUtils.MeetupEventTestBuilder;
import com.artavo.core.model.meetup.MeetupEvent;
import com.artavo.core.model.meetup.MeetupGroup;
import com.artavo.core.presenter.EventsCreatedPresenter;
import com.artavo.core.presenter.EventsFetcher;
import com.artavo.core.presenter.GroupsRepository;
import com.artavo.core.view.EventsCreatedView;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EventsCreatedViewTest {

    @Test
    public void shouldDisplayCreatedEventsWhenLoadingTheView() throws Exception {

        //given
        final EventsFetcher eventsFetcher = mock(EventsFetcher.class);
        final GroupsRepository groupsRepository = mock(GroupsRepository.class);
        final EventsCreatedPresenter eventsCreatedPresenter = new EventsCreatedPresenter(eventsFetcher, groupsRepository);

        final UINotifier uiNotifier = mock(UINotifier.class);
        final EventsCreatedView eventsCreatedView = new EventsCreatedView(eventsCreatedPresenter, uiNotifier);

        final List<MeetupEvent> expectedEvents = Collections.singletonList(new MeetupEventTestBuilder().id("fantastico").build());
        final Set<MeetupGroup> meetupGroups = Collections.singleton(new MeetupGroup("", 1, "name", 2, 3, "urlName", 4, "who"));

        when(groupsRepository.getGroups()).thenReturn(meetupGroups);

        doAnswer(new Answer() {
            @Override
            public Object answer(final InvocationOnMock invocation) throws Throwable {
                ((EventsCreatedPresenter) invocation.getArguments()[1]).retrievedCreatedEvents(expectedEvents);
                return null;
            }
        }).when(eventsFetcher).fetchCreatedEventsFor(meetupGroups, eventsCreatedPresenter);

        //when
        eventsCreatedView.onLoadDisplayCreatedEvents(eventsCreatedView);

        //then
        verify(uiNotifier).retrievedCreatedEvents(expectedEvents);
    }
}