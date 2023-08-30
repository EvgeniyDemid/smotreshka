package ru.smotreshka.api.pojo.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRes {
	private String id;
	private String email;
	private String name;
	private int age_rating;
	private String username;
	private String session;
	private IVI IVI;

	@AllArgsConstructor
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class IVI {
		private int id;
		private int expiration;
		private String verimatrix_id;
		private String session;
		private int set_at;
	}
}
