package dev.branyzp.flow.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

// implements indicates that a class implements an interface, which sets a blueprint for classes to follow
// for example, a circle class implements shape interface and must then provide a set of methods from shape

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;


}
