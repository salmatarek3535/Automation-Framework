package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"postCode","country","countryAbbreviation","places"})
public class Location {

    private static String postCode;
    private static String country;
    private static String countryAbbreviation;
    private List<Place> places;

    public Location()
    {
        this.postCode = "1050";
        this.country = "Latvia";
        this.countryAbbreviation = "LV";

        Place place = new Place();
        places = new ArrayList<>();
        places.add(place);
    }

    @JsonProperty("post code")
    public static String getPostCode() {
        return postCode;
    }

    @JsonProperty("post code")
    public static void setPostCode(String postCode) {
        Location.postCode = postCode;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Location.country = country;
    }

    @JsonProperty("country abbreviation")
    public static String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    @JsonProperty("country abbreviation")
    public static void setCountryAbbreviation(String countryAbbreviation) {
        Location.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
