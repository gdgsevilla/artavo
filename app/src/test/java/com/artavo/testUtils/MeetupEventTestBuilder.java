package com.artavo.testUtils;

import com.artavo.core.model.meetup.MeetupEvent;
import com.artavo.core.model.meetup.MeetupGroup;
import com.artavo.core.model.meetup.MeetupRating;
import com.artavo.core.model.meetup.MeetupVenue;

public class MeetupEventTestBuilder {


    private String id;
    private MeetupGroup group;
    private MeetupRating rating;
    private MeetupVenue venue;

    public MeetupEventTestBuilder id(final String id) {
        this.id = id;
        return this;
    }

    public MeetupEventTestBuilder group(final MeetupGroup group) {
        this.group = group;
        return this;
    }

    public MeetupEventTestBuilder rating(final MeetupRating rating) {
        this.rating = rating;
        return this;
    }

    public MeetupEventTestBuilder venue(final MeetupVenue venue) {
        this.venue = venue;
        return this;
    }

    public MeetupEvent build() {
        return new MeetupEvent(0, venue, 0, 0, "", 0, 0, rating, 0, "", "", 0, 0, false, "", id, 0, 0, group, "");
    }
}
