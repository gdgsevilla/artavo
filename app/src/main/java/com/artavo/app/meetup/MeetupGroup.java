package com.artavo.app.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetupGroup {

    @JsonProperty("join_mode")
    private String joinMode;
    private long created;
    private String name;

    @JsonProperty("group_lon")
    private double groupLongitude;

    @JsonProperty("group_lat")
    private double groupLatitude;
    private int id;

    @JsonProperty("urlname")
    private String urlName;
    private String who;

    public MeetupGroup() { }

    public MeetupGroup(final String joinMode, final long created, final String name, final double groupLongitude, final int id, final String urlName, final double groupLatitude, final String who) {
        this.joinMode = joinMode;
        this.created = created;
        this.name = name;
        this.groupLongitude = groupLongitude;
        this.groupLatitude = groupLatitude;
        this.id = id;
        this.urlName = urlName;
        this.who = who;
    }

    public String getJoinMode() {
        return joinMode;
    }

    public void setJoinMode(final String joinMode) {
        this.joinMode = joinMode;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(final long created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getGroupLongitude() {
        return groupLongitude;
    }

    public void setGroupLongitude(final double groupLongitude) {
        this.groupLongitude = groupLongitude;
    }

    public double getGroupLatitude() {
        return groupLatitude;
    }

    public void setGroupLatitude(final double groupLatitude) {
        this.groupLatitude = groupLatitude;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(final String urlName) {
        this.urlName = urlName;
    }

    public String getWho() {
        return who;
    }

    public void setWho(final String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "MeetupGroup{" +
            "joinMode='" + joinMode + '\'' +
            ", created=" + created +
            ", name='" + name + '\'' +
            ", groupLongitude=" + groupLongitude +
            ", groupLatitude=" + groupLatitude +
            ", id=" + id +
            ", urlName='" + urlName + '\'' +
            ", who='" + who + '\'' +
            '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final MeetupGroup that = (MeetupGroup) o;

        if (created != that.created) return false;
        if (Double.compare(that.groupLongitude, groupLongitude) != 0) return false;
        if (Double.compare(that.groupLatitude, groupLatitude) != 0) return false;
        if (id != that.id) return false;
        if (joinMode != null ? !joinMode.equals(that.joinMode) : that.joinMode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (urlName != null ? !urlName.equals(that.urlName) : that.urlName != null) return false;
        return !(who != null ? !who.equals(that.who) : that.who != null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = joinMode != null ? joinMode.hashCode() : 0;
        result = 31 * result + (int) (created ^ (created >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(groupLongitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(groupLatitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id;
        result = 31 * result + (urlName != null ? urlName.hashCode() : 0);
        result = 31 * result + (who != null ? who.hashCode() : 0);
        return result;
    }
}
