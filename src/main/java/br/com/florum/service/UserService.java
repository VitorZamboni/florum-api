package br.com.florum.service;

import br.com.florum.error.exceptions.ConflictException;
import br.com.florum.model.User;
import br.com.florum.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
            throw new ConflictException("Email address is already in use");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public Boolean existsUser(String email) {
        return this.userRepository.existsUserByEmail(email);
    }
}
