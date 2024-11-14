package com.hypermedicus.payload.response;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiResponse<T> {
	private int code;
	private String message;
    private T data;

	public static <T> ApiResponse<T> ok(T data) {
		return ApiResponse.<T>builder()
						  .code(HttpStatus.OK.value())
						  .message(HttpStatus.OK.getReasonPhrase())
						  .data(data)
						  .build();
	}
}