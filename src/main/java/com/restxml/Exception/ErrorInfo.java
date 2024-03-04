package com.restxml.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorInfo {
	private String code;
	private String errormsg;
	private LocalDateTime when;
}
