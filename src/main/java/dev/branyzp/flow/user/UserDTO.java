package dev.branyzp.flow.user;

import lombok.Getter;
import lombok.Setter;

// a Data Transfer Object is used to contain data
// the userDTO should contain user details coming in from the frontend to the backend for processing
// this ensures that the data coming in is consistent with what should be inside a user object

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String email;

    private String firstname;

    private String lastname;

    private String password;
}
