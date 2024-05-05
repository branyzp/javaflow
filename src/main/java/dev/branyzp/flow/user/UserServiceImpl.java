package dev.branyzp.flow.user;

import dev.branyzp.flow.api.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public List<User> seedUsers() {

        // delete all users
        userRepository.deleteAll();
        userRepository.flush();
        // create new seed users
        User newUser1 = new User();
        newUser1.setFirstname("Brandon");
        newUser1.setLastname("Yeo");
        newUser1.setEmail("bran@gmail.com");
        newUser1.setPassword(encoder().encode("fvgbhn45"));
        newUser1.setCreatedDt(LocalDate.now());

        User newUser2 = new User();
        newUser2.setFirstname("Yuan En");
        newUser2.setLastname("Wong");
        newUser2.setEmail("yuan@gmail.com");
        newUser2.setPassword(encoder().encode("fvgbhn456"));
        newUser2.setCreatedDt(LocalDate.now());

        userRepository.save(newUser1);
        userRepository.save(newUser2);

        return userRepository.findAll();
    }

    public List<User> findAll() {
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
        newUser.setCreatedDt(LocalDate.now());

        return userRepository.save(newUser);
    }
}
