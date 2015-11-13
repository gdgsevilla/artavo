package com.artavo.app.meetup;

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

    @Override
    public String toString() {
        return "MeetupRating{" +
            "count=" + count +
            ", average=" + average +
            '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof MeetupRating)) return false;

        final MeetupRating that = (MeetupRating) o;

        if (count != that.count) return false;
        return average == that.average;
    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + average;
        return result;
    }
}
