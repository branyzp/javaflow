package dev.branyzp.flow;

import dev.branyzp.flow.user.User;
import dev.branyzp.flow.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(UserRepository userRepository){
//		return args->{
//			User user = new User();
//			user.setFirstname("Brandon");
//			user.setLastname("Yeo");
//			user.setEmail("branyzp@gmail.com");
//			user.setPassword("fvgbhn45");
//			user.setCreatedDt(LocalDate.now());
//			user.setUserId(1L);
//
//			userRepository.save(user);
//			User savedUser = userRepository.findById(user.getUserId()).orElseThrow(NoSuchElementException::new);
//			System.out.println(savedUser);
//		};
//	}

}
