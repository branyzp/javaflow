package dev.branyzp.flow.user;

import java.util.List;

// service layer provides one level up layering to use the repository to perform actions using functions listed here
// we then use the service layer in the controller layer to perform the RESTful functionality

public interface UserService {

    // here we just list out the various methods, we will implement the methods in the service implementation layer
    User save(UserDTO user);

    List<User> findAll();

    void delete(Long id);

    User findOne(String email);

    User findById(Long id);

    UserDTO update(UserDTO userDTO);
}
