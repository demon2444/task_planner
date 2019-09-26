package pl.coderslab.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.springbootproject.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstById(Long id);

    User findUserByUsername(String username);
}
