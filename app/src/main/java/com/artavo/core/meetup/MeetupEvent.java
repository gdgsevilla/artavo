package com.artavo.core.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetupEvent {

    @JsonProperty("utc_offset")
    private int utcOffset;
    private MeetupVenue venue;

    @JsonProperty("rsvp_limit")
    private int rsvpLimit;

    @JsonProperty("headcount")
    private int headCount;
    private String visibility;

    @JsonProperty("waitlist_count")
    private int waitListCount;
    private long created;
    private MeetupRating rating;

    @JsonProperty("maybe_rsvp_count")
    private int maybeRsvpCount;
    private String description;

    @JsonProperty("event_url")
    private String eventURL;

    @JsonProperty("yes_rsvp_count")
    private int yesRsvpCount;
    private long duration;
    private boolean announced;
    private String name;
    private String id;
    private long time;
    private long updated;
    private MeetupGroup group;
    private String status;

    public MeetupEvent() { }

    public MeetupEvent(final int utcOffset, final MeetupVenue venue, final int rsvpLimit, final int headCount, final String visibility, final int waitListCount, final long created, final MeetupRating rating,
        final int maybeRsvpCount, final String description, final String eventURL, final int yesRsvpCount, final long duration, final boolean announced, final String name, final String id, final long time, final long updated,
        final MeetupGroup group, final String status) {
        this.utcOffset = utcOffset;
        this.venue = venue;
        this.rsvpLimit = rsvpLimit;
        this.headCount = headCount;
        this.visibility = visibility;
        this.waitListCount = waitListCount;
        this.created = created;
        this.rating = rating;
        this.maybeRsvpCount = maybeRsvpCount;
        this.description = description;
        this.eventURL = eventURL;
        this.yesRsvpCount = yesRsvpCount;
        this.duration = duration;
        this.announced = announced;
        this.name = name;
        this.id = id;
        this.time = time;
        this.updated = updated;
        this.group = group;
        this.status = status;
    }

    public int getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(final int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public MeetupVenue getVenue() {
        return venue;
    }

    public void setVenue(final MeetupVenue venue) {
        this.venue = venue;
    }

    public int getRsvpLimit() {
        return rsvpLimit;
    }

    public void setRsvpLimit(final int rsvpLimit) {
        this.rsvpLimit = rsvpLimit;
    }

    public int getHeadCount() {
        return headCount;
    }

    public void setHeadCount(final int headCount) {
        this.headCount = headCount;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(final String visibility) {
        this.visibility = visibility;
    }

    public int getWaitListCount() {
        return waitListCount;
    }

    public void setWaitListCount(final int waitListCount) {
        this.waitListCount = waitListCount;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(final long created) {
        this.created = created;
    }

    public MeetupRating getRating() {
        return rating;
    }

    public void setRating(final MeetupRating rating) {
        this.rating = rating;
    }

    public int getMaybeRsvpCount() {
        return maybeRsvpCount;
    }

    public void setMaybeRsvpCount(final int maybeRsvpCount) {
        this.maybeRsvpCount = maybeRsvpCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getEventURL() {
        return eventURL;
    }

    public void setEventURL(final String eventURL) {
        this.eventURL = eventURL;
    }

    public int getYesRsvpCount() {
        return yesRsvpCount;
    }

    public void setYesRsvpCount(final int yesRsvpCount) {
        this.yesRsvpCount = yesRsvpCount;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(final long duration) {
        this.duration = duration;
    }

    public boolean isAnnounced() {
        return announced;
    }

    public void setAnnounced(final boolean announced) {
        this.announced = announced;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(final long time) {
        this.time = time;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(final long updated) {
        this.updated = updated;
    }

    public MeetupGroup getGroup() {
        return group;
    }

    public void setGroup(final MeetupGroup group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

}
