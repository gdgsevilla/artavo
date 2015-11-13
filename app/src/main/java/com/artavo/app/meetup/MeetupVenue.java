package com.artavo.app.meetup;

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

    @Override
    public String toString() {
        return "MeetupVenue{" +
            "country='" + country + '\'' +
            ", city='" + city + '\'' +
            ", address1='" + address1 + '\'' +
            ", name='" + name + '\'' +
            ", lon=" + lon +
            ", id=" + id +
            ", lat=" + lat +
            ", longitude=" + longitude +
            ", latitude=" + latitude +
            ", repinned=" + repinned +
            '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final MeetupVenue that = (MeetupVenue) o;

        if (Double.compare(that.lon, lon) != 0) return false;
        if (id != that.id) return false;
        if (Double.compare(that.lat, lat) != 0) return false;
        if (longitude != that.longitude) return false;
        if (latitude != that.latitude) return false;
        if (repinned != that.repinned) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = country != null ? country.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(lon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id;
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (longitude ^ (longitude >>> 32));
        result = 31 * result + (int) (latitude ^ (latitude >>> 32));
        result = 31 * result + (repinned ? 1 : 0);
        return result;
    }
}
