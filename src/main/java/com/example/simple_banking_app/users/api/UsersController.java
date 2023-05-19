package com.example.simple_banking_app.users.api;

import com.example.simple_banking_app.users.api.dto.CreateUser;
import com.example.simple_banking_app.users.api.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
class UsersController {
    private final UserFacade userFacade;

    UsersController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    User create(@RequestBody CreateUser createUser) {
        return userFacade.create(createUser);
    }

    @RequestMapping("/{userId}")
    @GetMapping
    User get(@PathVariable UUID userId) {
        return userFacade.getUser(userId);
    }
}
