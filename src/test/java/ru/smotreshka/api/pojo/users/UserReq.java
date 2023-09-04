package ru.smotreshka.api.pojo.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserReq {

	private String email, password;
}
