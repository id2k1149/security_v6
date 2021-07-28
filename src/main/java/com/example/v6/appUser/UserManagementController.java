package com.example.v6.appUser;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/users")
public class UserManagementController {

    private static final List<AppUser> APP_USERS = Arrays.asList(
            new AppUser(1, "James Bond"),
            new AppUser(2, "Maria Jones"),
            new AppUser(3, "Anna Smith")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<AppUser> getAllUsers() {
        return APP_USERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerNewUser(@RequestBody AppUser user) {
        System.out.println("registerNewUser");
        System.out.println(user);
    }

    @DeleteMapping(path = "/{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("deleteUser");
        System.out.println(userId);
    }

    @PutMapping(path = "/{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateUser(@PathVariable("userId") Integer userId,
                           @RequestBody AppUser user) {
        System.out.println("updateUser");
        System.out.println(String.format("%s %s", user, userId));

    }

}
