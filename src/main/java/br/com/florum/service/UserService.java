package br.com.florum.service;

import br.com.florum.model.User;
import br.com.florum.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user) {
        if(userRepository.existsUserByEmail(user.getEmail())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Email já está em uso"
            );
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public Boolean existsUser(String email) {
        return this.userRepository.existsUserByEmail(email);
    }
}
