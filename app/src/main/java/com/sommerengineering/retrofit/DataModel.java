package com.sommerengineering.retrofit;

/**
 * Simple POJO that Retrofit automatically creates from the API response.
 */
public class DataModel {

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
