package pl.coderslab.springbootproject.service;

import org.springframework.context.annotation.Bean;
import pl.coderslab.springbootproject.model.User;

import java.util.List;


public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
    User findUserById(Long id);
    List<User> findAllUsers();

}
