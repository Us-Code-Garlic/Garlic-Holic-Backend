package com.garlicholic.backend.api.support;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private ResultType resultType;
    private String error;
    private T success;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResultType.SUCCESS, null, data);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(ResultType.ERROR, message, null);
    }

}
