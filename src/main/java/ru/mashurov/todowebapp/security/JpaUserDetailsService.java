package ru.mashurov.todowebapp.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mashurov.todowebapp.model.User;
import ru.mashurov.todowebapp.services.UserService;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) throw new UsernameNotFoundException("User with username=" + username +" was not found.");

        return new UserDetailsWrapper(user);
    }

}
