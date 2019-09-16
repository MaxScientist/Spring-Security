package org.doit.security;

import org.doit.exceptions.OhOhHoldOnException;
import org.doit.model.User;
import org.doit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String email = authentication.getName();
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        String password = authentication.getCredentials().toString();
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new BadCredentialsException("Bad credentials");
//        }
//        if(email.equals("2sd5214@gmail.com")){
//                throw new OhOhHoldOnException("Haha Nice Try Body");
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        return new UsernamePasswordAuthenticationToken(user, null, authorities);

        UsernamePasswordAuthenticationToken authToken = null;
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.findByEmail(email);
        if (user != null){
            if (email.equals(user.getEmail())  && BCrypt.checkpw(password,user.getPassword())){
                Collection<GrantedAuthority> authorities = getGrantedAuthorities(user);
                authToken = new UsernamePasswordAuthenticationToken(
                        new org.springframework.security.core.userdetails.User(
                                email,password,authorities
                        ),password,authorities
                );
            }
        }
        else {
            throw new UsernameNotFoundException("User name " + email + " not found");
        }
        return authentication;
    }
    private Collection<GrantedAuthority> getGrantedAuthorities(User user){
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user.getRole().getName().equals("admin")){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return
                aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
