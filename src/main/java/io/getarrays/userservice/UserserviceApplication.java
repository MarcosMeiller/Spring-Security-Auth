package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(1,"ROLE_STUDENT"));
			userService.saveRole(new Role(2,"ROLE_TEACHER"));
			userService.saveRole(new Role(3,"ROLE_ADMIN"));
			userService.saveRole(new Role(4,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(1,"pepe","per3","12134",new ArrayList()));
			userService.saveUser(new User(2,"juan","jasdin2","12134",new ArrayList()));
			userService.saveUser(new User(3,"pedro","admins","12134",new ArrayList()));

			userService.addRoleToUser("per3","ROLE_STUDENT");
			userService.addRoleToUser("per3","ROLE_ADMIN");
			userService.addRoleToUser("jasdin2","ROLE_TEACHER");
			userService.addRoleToUser("admins","ROLE_SUPER_ADMIN");

		};
	}
}
