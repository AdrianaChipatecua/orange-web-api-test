package com.orange.web.api.constans;

public class Constants {

    private Constants() {
    }

    public static final String WEB_URL = System.getenv("WEB_URL");
    public static final String REGISTER_DATA_KEY = "Register_data_key";
    public static final int WAIT_TIME = 5;
    public static final int WAIT_LONG_SECONDS = 10;
    public static final String SUCCESSFUL_USER_NAME = System.getenv("SUCCESSFUL_USER_NAME");
    public static final String SUCCESSFUL_PASSWORD = System.getenv("SUCCESSFUL_PASSWORD");
    public static final String USER_NAME_API = "user name from api request";
    public static final String TOKEN_API = "token from api request";
    public static final String USER_TOKEN = System.getenv("USER_TOKEN");
    public static final String JOB_DESCRIPTION = "job description";
}
