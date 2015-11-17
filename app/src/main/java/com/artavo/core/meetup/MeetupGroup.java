package com.artavo.core.meetup;

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

}
