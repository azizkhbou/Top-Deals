package com.esprit.td.requests;

import lombok.Data;

@Data
public class PasswordRequest {
	private String username;
	private String oldPassword;
	private String NewPassword;
	

}
