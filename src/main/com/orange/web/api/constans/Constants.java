package com.orange.web.api.constans;

public class Constants {

    private Constants() {
    }

    public static final String WEB_URL = System.getenv("WEB_URL");
    public static final String REGISTER_DATA_KEY = "Register_data_key";
    public static final int WAIT_TIME = 5;
    public static final int WAIT_LONG_SECONDS = 10;
    public static final String SUCCESSFUL_USER_NAME = System.getenv("SUCCESSFUL_USER");
    public static final String SUCCESSFUL_PASSWORD = System.getenv("SUCCESSFUL_PASSWORD");
    public static final String RESPONSE_BODY = "response body api request";
    public static final String TOKEN_API = "token from api request";
    public static final String SESSION_COOKIE = "SESSION COOKIE";

}