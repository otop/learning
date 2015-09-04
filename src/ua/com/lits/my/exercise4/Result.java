package ua.com.lits.my.exercise4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * parsing of items in 'result' node
 * @author user
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	private String postcode;
	private int quality;
	private int eastings;
	private int northings;
	private String country;
	private String nhs_ha;
	private long longitude;
	private long latitude;
	private Codes codes;
	
	@JsonCreator
	public Result (@JsonProperty("postcode") String postcode, @JsonProperty("quality") int quality, @JsonProperty("eastings") int eastings,
			@JsonProperty("northings") int northings, @JsonProperty("country") String country, @JsonProperty("nhs_ha") String nhs_ha,
			@JsonProperty("longitude") long longitude, @JsonProperty("latitude") long latitude, @JsonProperty("code") Codes code){
		this.postcode = postcode;
		this.quality = quality;
		this.eastings = eastings;
		this.northings = northings;
		this.country = country;
		this.nhs_ha = nhs_ha;
		this.longitude = longitude;
		this.latitude = latitude;
		this.codes = code;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getEastings() {
		return eastings;
	}

	public void setEastings(int eastings) {
		this.eastings = eastings;
	}

	public int getNorthings() {
		return northings;
	}

	public void setNorthings(int northings) {
		this.northings = northings;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNhs_ha() {
		return nhs_ha;
	}

	public void setNhs_ha(String nhs_ha) {
		this.nhs_ha = nhs_ha;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public Codes getCodes() {
		return codes;
	}

	public void setCodes(Codes codes) {
		this.codes = codes;
	}
	
}
