package dev.branyzp.flow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// implements indicates that a class implements an interface, which sets a blueprint for classes to follow
// for example, a circle class implements shape interface and must then provide a set of methods from shape

@Service
public class UserServiceImpl implements UserService{

    // autowired annotation refers to automatic dependency injection, which means spring boot automatically injects the dependencies needed for this object without you needing to add boilerplate code
    // here we autowire the repository layer to use it to perform data access and retrieval actions
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){

    }

    public User findOne(String username){

    }

    public User findById(Long id){

    }

    public UserDTO update(UserDTO userDTO){

    }

    public void delete(Long id){

    }
    public User save(UserDTO user) {

    }



}
