package com.example.v6.appUser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private static final List<AppUser> APP_USERS = Arrays.asList(
      new AppUser(1, "James Bond"),
      new AppUser(2, "Maria Jones"),
      new AppUser(3, "Anna Smith")
    );

    @GetMapping(path = "{userId}")
    public AppUser getUser(@PathVariable("userId") Integer userId) {
        return APP_USERS.stream()
                .filter(appUser -> userId.equals(appUser.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "User " + userId + " does not exists"
                ));
    }
}
