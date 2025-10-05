package com.orange.web.api.exceptions;

public class NotFoundWebdriver extends RuntimeException {
    public NotFoundWebdriver() {
        super("Webdriver is not Chrome");
    }
}
