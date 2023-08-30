package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"placeName","longitude","state","stateAbbreviation","latitude"})

public class Place {

    private static String placeName;
    private static String longitude;
    private static String state;
    private static String stateAbbreviation;
    private static String latitude;

    public Place()
    {
        this.placeName = "Riga";
        this.longitude = "1";
        this.state = "Riga";
        this.stateAbbreviation = "RI";
        this.latitude = "1";
    }

    @JsonProperty("place name")
    public static String getPlaceName() {
        return placeName;
    }

    @JsonProperty("place name")
    public static void setPlaceName(String placeName) {
        Place.placeName = placeName;
    }

    public static String getLongitude() {
        return longitude;
    }

    public static void setLongitude(String longitude) {
        Place.longitude = longitude;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        Place.state = state;
    }

    @JsonProperty("state abbreviation")
    public static String getStateAbbreviation() {
        return stateAbbreviation;
    }

    @JsonProperty("state abbreviation")
    public static void setStateAbbreviation(String stateAbbreviation) {
        Place.stateAbbreviation = stateAbbreviation;
    }

    public static String getLatitude() {
        return latitude;
    }

    public static void setLatitude(String latitude) {
        Place.latitude = latitude;
    }
}
