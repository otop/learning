package ua.com.lits.my.exercise4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * parsing of all items in 'code' node
 * 
 * @author user
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Codes {
	private String admin_district;
	private String admin_county;
	private String admin_ward;
	private String parish;
	private String ccg;
	private String nuts;

	@JsonCreator
	public Codes(@JsonProperty("admin_district") String admin_district,
			@JsonProperty("admin_county") String admin_county, @JsonProperty("admin_ward") String admin_ward,
			@JsonProperty("parish") String parish, @JsonProperty("ccg") String ccg, @JsonProperty("nuts") String nuts) {
		this.admin_district = admin_district;
		this.admin_county = admin_county;
		this.admin_ward = admin_ward;
		this.parish = parish;
		this.ccg = ccg;
		this.nuts = nuts;
	}

	public String getAdmin_district() {
		return admin_district;
	}

	public void setAdmin_district(String admin_district) {
		this.admin_district = admin_district;
	}

	public String getAdmin_county() {
		return admin_county;
	}

	public void setAdmin_county(String admin_county) {
		this.admin_county = admin_county;
	}

	public String getAdmin_ward() {
		return admin_ward;
	}

	public void setAdmin_ward(String admin_ward) {
		this.admin_ward = admin_ward;
	}

	public String getParish() {
		return parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}

	public String getCcg() {
		return ccg;
	}

	public void setCcg(String ccg) {
		this.ccg = ccg;
	}

	public String getNuts() {
		return nuts;
	}

	public void setNuts(String nuts) {
		this.nuts = nuts;
	}

}
