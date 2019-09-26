package pl.coderslab.springbootproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.springbootproject.model.Role;
import pl.coderslab.springbootproject.model.User;
import pl.coderslab.springbootproject.repository.RoleRepository;
import pl.coderslab.springbootproject.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;
    public SpringBootProjectApplication(UserRepository userRepository,RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @Override
    public void run(String... params){
        if(roleRepository.findRoleByName("ROLE_USER")==null){
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }
        if(roleRepository.findRoleByName("ROLE_ADMIN")==null){
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if(userRepository.findUserByUsername("admin")==null){
            User admin = new User();
            admin.setEmail("admin@mail.com");
            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin"));
            admin.setFirstName("Admin");
            admin.setLastName("Name");
            admin.setEnabled(true);
            Role adminRole = roleRepository.findRoleByName("ROLE_ADMIN");
            Role userRole = roleRepository.findRoleByName("ROLE_USER");
            admin.setRoles(new HashSet<>(Arrays.asList(adminRole,userRole)));
            userRepository.save(admin);
        }
    }
}
