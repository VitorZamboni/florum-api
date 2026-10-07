package br.com.florum.repository;

import br.com.florum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String username);
    Boolean existsUserByEmail(String email);
    User getUserById(Long id);
}
