package com.chapur.services.config;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.chapur.services.entity.UserInfo;
import com.chapur.services.repository.UserInfoRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Optional<UserInfo> userInfo = repository.findByName(username);
        Optional<UserInfo> userInfo = Optional.ofNullable(new UserInfo());
        userInfo.get().setName(username);
        userInfo.get().setPassword(UUID.randomUUID().toString());

        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}