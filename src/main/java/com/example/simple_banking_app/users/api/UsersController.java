package com.example.simple_banking_app.users.api;

import com.example.simple_banking_app.users.api.dto.CreateUser;
import com.example.simple_banking_app.users.api.dto.User;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/{pesel}")
    @GetMapping
    User get(@PathVariable String pesel) {
        return userFacade.getUserByPesel(pesel);
    }
}
