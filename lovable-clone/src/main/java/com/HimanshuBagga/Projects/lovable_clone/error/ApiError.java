package com.HimanshuBagga.Projects.lovable_clone.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public record ApiError(
        HttpStatus status,
        String message,
        Instant timeStamp,
        @JsonInclude(JsonInclude.Include.NON_NULL) // when errors are null don't include them
        List<ApiFieldError> errors
) {
    public ApiError(HttpStatus status , String message){
        this(status, message, Instant.now() , null);
    }

    public ApiError(HttpStatus status , String message , List<ApiFieldError> errors){
        this(status, message, Instant.now() , errors);
    }
}

record ApiFieldError(String field , String message){}
