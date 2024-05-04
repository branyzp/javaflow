package dev.branyzp.flow.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// implements indicates that a class implements an interface, which sets a blueprint for classes to follow
// for example, a circle class implements shape interface and must then provide a set of methods from shape

@Service(value = "userService")
public class UserServiceImpl implements UserService{

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    // autowired annotation refers to automatic dependency injection, which means spring boot automatically injects the dependencies needed for this object without you needing to add boilerplate code
    // here we autowire the repository layer to use it to perform data access and retrieval actions
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        Optional<User> optionalUser =userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public UserDTO update(UserDTO userDTO) {
        User user = findById(userDTO.getId());
        if(user != null) {
            BeanUtils.copyProperties(userDTO,user,"password");
            userRepository.save(user);
        }
        return userDTO;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    public User save(UserDTO userDTO) {
        User newUser = new User();
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(encoder().encode(userDTO.getPassword()));
        newUser.setFirstname(userDTO.getFirstname());
        newUser.setLastname(userDTO.getLastname());

        return userRepository.save(newUser);
    }
}
