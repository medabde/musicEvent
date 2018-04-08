package model;

import java.io.Serializable;

/**
 * Created by Med Abde on 3/22/2018.
 */

public class Event implements Serializable {
    private static final long id = 1L;
    private String title;
    private String artist;
    private String headLiner;
    private String venueLiner;
    private String city;
    private String country;
    private String street;
    private String postalCod;
    private String url;
    private String website;
    private String vanueImage;
    private String bandImage;
    private String startDate;
    private String description;
    private String musicGenre;


    public static long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getHeadLiner() {
        return headLiner;
    }

    public void setHeadLiner(String headLiner) {
        this.headLiner = headLiner;
    }

    public String getVenueLiner() {
        return venueLiner;
    }

    public void setVenueLiner(String venueLiner) {
        this.venueLiner = venueLiner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCod() {
        return postalCod;
    }

    public void setPostalCod(String postalCod) {
        this.postalCod = postalCod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVanueImage() {
        return vanueImage;
    }

    public void setVanueImage(String vanueImage) {
        this.vanueImage = vanueImage;
    }

    public String getBandImage() {
        return bandImage;
    }

    public void setBandImage(String bandImage) {
        this.bandImage = bandImage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }
}
