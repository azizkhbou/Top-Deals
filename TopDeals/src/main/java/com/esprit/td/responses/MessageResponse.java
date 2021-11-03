package com.esprit.td.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor //constructeur surcharger
public class MessageResponse {
	private boolean success ;
	private String message ;
	private String detail ;

}
