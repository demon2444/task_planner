package pl.coderslab.springbootproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootproject.model.User;
import pl.coderslab.springbootproject.repository.UserRepository;

import java.util.List;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findFirstById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
