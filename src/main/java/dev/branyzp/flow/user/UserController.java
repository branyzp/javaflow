package dev.branyzp.flow.user;

import dev.branyzp.flow.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/seed")
    public ApiResponse<List<User>> seed() {
        return new ApiResponse<>(HttpStatus.OK.value(),"Users seeded successfully",userService.seedUsers());
    }

    @PostMapping("/register")
    public ApiResponse<User> saveUser(@RequestBody UserDTO userDTO) {
        return new ApiResponse<>(HttpStatus.OK.value(),"User saved successfully",userService.save(userDTO));
    }

    @GetMapping
    public ApiResponse<List<User>> listUsers() {
        return new ApiResponse<>(HttpStatus.OK.value(),"User list fetched successfully",userService.findAll());
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@RequestBody UserDTO userDTO) {
        return new ApiResponse<>(HttpStatus.OK.value(),"User updated successfully",userService.update(userDTO));
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable Long id) {
        return new ApiResponse<>(HttpStatus.OK.value(),"User fetched successfully",userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(),"User deleted successfully",null);
    }
}
