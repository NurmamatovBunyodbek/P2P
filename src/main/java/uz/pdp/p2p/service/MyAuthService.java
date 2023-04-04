package uz.pdp.p2p.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyAuthService implements UserDetailsService {

   private PasswordEncoder passwordEncoder = null;

    List<User> userList = new ArrayList<>(Arrays.asList(
            new User("PDP", passwordEncoder.encode("4747"), new ArrayList<>())
    ));

    public MyAuthService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (User user : userList) {
            if (user.getUsername().equals(username))
                return user;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
