package com.orange.web.api.utils;

import lombok.Getter;
import net.serenitybdd.screenplay.actors.OnStage;

import com.orange.web.api.constans.Constants;
import com.orange.web.api.models.UserRegistrationData;
import java.util.Arrays;

public class DataManager {

    @Getter
    enum Users {
        Lizeth("Lizeth", "Admin user") {
            @Override
            public UserRegistrationData registrationData() {
                return new UserRegistrationData(Constants.SUCCESSFUL_USER_NAME,
                        Constants.SUCCESSFUL_PASSWORD, "email");
            }
        },
        Janet("Janet", "Get api user") {
            @Override
            public UserRegistrationData registrationData() {
                return new UserRegistrationData("api",
                        "user", "email");
            }
        };

        public final String actorName;
        public final String description;

        private Users(String actorName, String description) {
            this.actorName = actorName;
            this.description = description;
        }

        public abstract UserRegistrationData registrationData();

        public static Users fromUserName(String actorName) {
            return Arrays.stream(values())
                    .filter(users -> users.actorName.equals(actorName))
                    .findFirst()
                    .orElse(Lizeth);
        }
    }

    public static void initActorWithName(String actorName) {
        Users user = Users.fromUserName(actorName);
        OnStage.theActorCalled(actorName)
                .describedAs(user.description)
                .remember(Constants.REGISTER_DATA_KEY, user.registrationData());
    }
}


