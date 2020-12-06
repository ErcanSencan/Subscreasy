package com.subscreasy.subscreasybackend.app;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.subscreasy.subscreasybackend.enums.RoleType;
import com.subscreasy.subscreasybackend.model.Role;
import com.subscreasy.subscreasybackend.model.User;
import com.subscreasy.subscreasybackend.repository.RoleRepository;
import com.subscreasy.subscreasybackend.repository.UserRepository;



@Service
public class DbInit implements CommandLineRunner {
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	
    private PasswordEncoder passwordEncoder;

    public DbInit() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) {
        this.userRepository.deleteAll();
        this.roleRepository.deleteAll();
        
        Role userRole = new Role(RoleType.ROLE_USER,"user");
        Role adminRole = new Role(RoleType.ROLE_ADMIN,"admin");
        
        userRole = this.roleRepository.save(userRole);
        adminRole = this.roleRepository.save(adminRole);
        User user = new User("user",passwordEncoder.encode("user"),"user","user",userRole);
        User admin = new User("admin",passwordEncoder.encode("admin"),"admin","admin",adminRole);    
        admin= userRepository.save(admin);
        user = userRepository.save(user);
    }
}