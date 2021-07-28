package com.example.v6.auth;

import java.util.Optional;

public interface AppUserDAO {

    Optional<AppUser> selectAppUserByUserName(String username);
}
