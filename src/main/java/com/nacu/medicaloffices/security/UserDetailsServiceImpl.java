package com.nacu.medicaloffices.security;

import com.nacu.medicaloffices.domain.User;
import com.nacu.medicaloffices.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthority(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthority(User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getRole().getName().equalsIgnoreCase("admin")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(user.getRole().getName().equalsIgnoreCase("doctor")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));
        }
        if(user.getRole().getName().equalsIgnoreCase("pharmacy_owner")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_PHARMACY_OWNER"));
        }
        if(user.getRole().getName().equalsIgnoreCase("patient")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }
}
