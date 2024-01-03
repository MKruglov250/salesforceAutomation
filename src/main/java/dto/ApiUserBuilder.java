package dto;

import utilities.LoginUtils;

public class ApiUserBuilder {

    public static ApiUser getApiUser(){
        return new ApiUser.ApiUserBuilder()
                .username(LoginUtils.getLogin())
                .password(LoginUtils.getPassword()+LoginUtils.getVerificationCode())
                .grant_type(LoginUtils.getGrantType())
                .client_id(LoginUtils.getClientId())
                .client_secret(LoginUtils.getClientSecret())
                .build();
    }
}
