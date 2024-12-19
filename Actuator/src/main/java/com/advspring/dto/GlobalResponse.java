package com.advspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalResponse {
	private String message = "İşlem Başarılı";
	private int returnCode;
}
