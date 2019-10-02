package pl.coderslab.springbootproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.springbootproject.model.Role;
import pl.coderslab.springbootproject.model.User;
import pl.coderslab.springbootproject.repository.RoleRepository;
import pl.coderslab.springbootproject.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findRoleByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findFirstById(id);
    }
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    public User getUser() {
        Authentication authentication = getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();


        return findByUserName(currentPrincipalName);
    }

}
