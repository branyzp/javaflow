package dev.branyzp.flow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


//    @Autowired
//    private UserRepository userRepository;

    private UserServiceImpl userServiceImpl;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) throws Exception{
        return userServiceImpl.findById(id);
    }

}
