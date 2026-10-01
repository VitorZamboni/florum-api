package br.com.florum.controller;

import br.com.florum.dto.UserDTO;
import br.com.florum.mapper.UserMapper;
import br.com.florum.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(
            UserService userService,
            UserMapper userMapper
    ) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UserDTO userDTO) {
        userService.save(userMapper.toEntity(userDTO));
        log.info("User created: {}", userDTO);
    }

    @GetMapping("{email}/exists")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> existsUser(@PathVariable String email) {
        return ResponseEntity.accepted().body(userService.existsUser(email));
    }

}
