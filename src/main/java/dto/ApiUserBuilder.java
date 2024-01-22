package dto;

import utilities.PropertyReader;

import java.io.FileNotFoundException;

public class ApiUserBuilder {

    public static ApiUser getApiUser() throws FileNotFoundException {
        return new ApiUser.ApiUserBuilder()
                .username(PropertyReader.getLogin())
                .password(PropertyReader.getPassword()+PropertyReader.getVerificationCode())
                .grant_type(PropertyReader.getGrantType())
                .client_id(PropertyReader.getClientId())
                .client_secret(PropertyReader.getClientSecret())
                .build();
    }
}
