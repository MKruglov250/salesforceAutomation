package dto;

import com.github.javafaker.Faker;
import utilities.LoginUtils;

public class UserModelBuilder {

    public static UserModel getValidUser() {
        return new UserModel.UserModelBuilder()
                .email(LoginUtils.getLogin())
                .password(LoginUtils.getPassword())
                .build();
    }


    public static UserModel getIncorrectUser(){
        Faker faker = new Faker();

        return new UserModel.UserModelBuilder()
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .build();
    }
}
