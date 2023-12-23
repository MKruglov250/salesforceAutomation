package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private final String email;
    private final String password;
}