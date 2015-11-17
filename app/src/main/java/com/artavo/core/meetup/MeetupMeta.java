package com.artavo.core.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetupMeta {

    private String next;
    private String method;

    @JsonProperty("total_count")
    private int totalCount;
    private String link;
    private int count;
    private String description;
    private String lon;
    private String title;
    private String url;

    @JsonProperty("signed_url")
    private String signedUrl;
    private String id;
    private long updated;
    private String lat;

    public MeetupMeta() { }

    public MeetupMeta(final String next, final String method, final int totalCount, final String link, final int count, final String description, final String lon, final String title, final String url,
        final String signedUrl, final String id, final long updated, final String lat) {
        this.next = next;
        this.method = method;
        this.totalCount = totalCount;
        this.link = link;
        this.count = count;
        this.description = description;
        this.lon = lon;
        this.title = title;
        this.url = url;
        this.signedUrl = signedUrl;
        this.id = id;
        this.updated = updated;
        this.lat = lat;
    }

    public String getNext() {
        return next;
    }

    public void setNext(final String next) {
        this.next = next;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(final String method) {
        this.method = method;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
    }

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(final String lon) {
        this.lon = lon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getSignedUrl() {
        return signedUrl;
    }

    public void setSignedUrl(final String signedUrl) {
        this.signedUrl = signedUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(final long updated) {
        this.updated = updated;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(final String lat) {
        this.lat = lat;
    }
}
