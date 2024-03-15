package com.backend.utill;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse {
    private HttpStatus status;
    private String message;

    // Constructors, getters, and setters
    public CustomErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and setters
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
