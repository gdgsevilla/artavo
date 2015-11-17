package com.artavo.core.meetup;

public class MeetupRating {

    private int count;
    private int average;

    public MeetupRating() { }

    public MeetupRating(final int count, final int average) {
        this.count = count;
        this.average = average;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(final int average) {
        this.average = average;
    }

}
