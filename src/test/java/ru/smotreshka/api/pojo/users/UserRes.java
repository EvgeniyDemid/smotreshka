package ru.smotreshka.api.pojo.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRes {

	private String id;
	private String email;
	private String name;
	@JsonProperty("age_rating")
	private int ageRating;
	private String username;
	private String session;
	private IVI IVI;

	@AllArgsConstructor
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class IVI {
		private int id;
		private int expiration;
		@JsonProperty("verimatrix_id")
		private String verimatrixId;
		private String session;
		private int set_at;
	}
}
