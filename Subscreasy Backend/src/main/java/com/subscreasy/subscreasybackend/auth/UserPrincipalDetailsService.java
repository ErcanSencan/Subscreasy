package com.subscreasy.subscreasybackend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subscreasy.subscreasybackend.model.User;
import com.subscreasy.subscreasybackend.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	@Autowired
    private UserRepository userRepository;

    public UserPrincipalDetailsService() {

    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(userName);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}