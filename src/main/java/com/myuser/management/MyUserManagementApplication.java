package com.myuser.management;

import com.myuser.management.controller.UserController;
import com.myuser.management.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyUserManagementApplication {
@Autowired
private UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(MyUserManagementApplication.class, args);
	}
//	public void run(String... args) throws Exception {
//		RoleDto roleDto=new RoleDto();
//		roleDto.setRole("Admin");
//		userController.createRole(roleDto);
//
//	}

}
