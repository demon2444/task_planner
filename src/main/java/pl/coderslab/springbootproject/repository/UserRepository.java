package pl.coderslab.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springbootproject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstById(Long id);

    User findUserByUsername(String username);
}
