package ua.com.lits.my.exercise4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * parse items of the first node
 * @author user
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JSONFileMapping {
	private int status;
	private Result result;

	@JsonCreator
	public JSONFileMapping (@JsonProperty("status") int status, @JsonProperty("result") Result result) {
				this.status = status;
				this.result = result;
			}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
