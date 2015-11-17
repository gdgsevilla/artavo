package com.artavo.core.model.meetup;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetupVenue {

    private String country;
    private String city;

    @JsonProperty("address_1")
    private String address1;
    private String name;
    private double lon;
    private int id;
    private double lat;
    private long longitude;
    private long latitude;
    private boolean repinned;

    public MeetupVenue() { }

    public MeetupVenue(final String country, final String city, final String address, final String name, final double lon, final int id, final double lat, final boolean repinned) {
        this.country = country;
        this.city = city;
        this.address1 = address;
        this.name = name;
        this.lon = lon;
        this.id = id;
        this.lat = lat;
        this.repinned = repinned;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getAddress() {
        return address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(final String address1) {
        this.address1 = address1;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getLon() {
        return lon;
    }

    public int getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(final long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(final long latitude) {
        this.latitude = latitude;
    }

    public boolean isRepinned() {
        return repinned;
    }

    public void setRepinned(final boolean repinned) {
        this.repinned = repinned;
    }

}
