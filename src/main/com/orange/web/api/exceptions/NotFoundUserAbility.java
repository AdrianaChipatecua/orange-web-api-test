package com.orange.web.api.exceptions;

public class NotFoundUserAbility extends RuntimeException {

    public NotFoundUserAbility() {
        super("The Actor doesn't have this ability");
    }
}
