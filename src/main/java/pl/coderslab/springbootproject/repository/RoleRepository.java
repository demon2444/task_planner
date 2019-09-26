package pl.coderslab.springbootproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.springbootproject.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);
}
