package com.example.v6.auth;

import com.example.v6.security.AppUserRole;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.v6.security.AppUserRole.*;

@Repository("fake")
public class FakeAppUserDAOService implements AppUserDAO {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeAppUserDAOService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> selectAppUserByUserName(String username) {
        return getAppUsers()
                .stream()
                .filter(appUser -> username.equals(appUser.getUsername()))
                .findFirst();
    }

    public List<AppUser> getAppUsers() {
        List<AppUser> appUsers = Lists.newArrayList(
                new AppUser(
                        "anna",
                        passwordEncoder.encode("password"),
                        STUDENT.getGrantedAuthorities()
                ),

                new AppUser(
                        "linda",
                        passwordEncoder.encode("password"),
                        ADMIN.getGrantedAuthorities()
                ),

                new AppUser(
                        "tom",
                        passwordEncoder.encode("password"),
                        ADMINTRAINEE.getGrantedAuthorities()
                )
        );

        return appUsers;
    }
}
