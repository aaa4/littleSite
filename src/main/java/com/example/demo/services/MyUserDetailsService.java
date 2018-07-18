package com.example.demo.services;

import com.example.demo.model.SecurityAccount;
import com.example.demo.model.SecurityRole;
import com.example.demo.repository.SecurityAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class MyUserDetailsService implements UserDetailsService {


    private SecurityAccountRepository securityAccountRepository;

    @Autowired
    public void setSecurityAccountRepository(SecurityAccountRepository securityAccountRepository) {
        this.securityAccountRepository = securityAccountRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SecurityAccount account = securityAccountRepository.findByUsername(username);
        if (account == null)
            throw new UsernameNotFoundException("User with " + username + "not found");

        Set<GrantedAuthority> authoritySet = new HashSet<>();
        for (SecurityRole role : account.getRoles())
            authoritySet.add(new SimpleGrantedAuthority(role.getRole()));
        return new User(account.getUsername(), account.getPassword(), authoritySet);
    }
}
