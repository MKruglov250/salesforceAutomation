package dto;

import com.github.javafaker.Faker;
import utilities.LoginUtils;

public class UserBuilder {

    public static User getValidUser() {
        return new User.UserBuilder()
                .email(LoginUtils.getLogin())
                .password(LoginUtils.getPassword())
                .build();
    }


    public static User getIncorrectUser(){
        Faker faker = new Faker();

        return new User.UserBuilder()
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .build();
    }
}
