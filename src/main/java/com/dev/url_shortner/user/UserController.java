package com.dev.url_shortner.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")

    public void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "/delete/{email}")
    public void deleteUser(@PathVariable("email") String email) {
        userService.deleteUser(email);
    }
}
