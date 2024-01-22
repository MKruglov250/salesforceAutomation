package dto;

import com.github.javafaker.Faker;
import utilities.PropertyReader;

import java.io.FileNotFoundException;

public class UserBuilder {

    public static User getValidUser() throws FileNotFoundException {
        return new User.UserBuilder()
                .email(PropertyReader.getLogin())
                .password(PropertyReader.getPassword())
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
