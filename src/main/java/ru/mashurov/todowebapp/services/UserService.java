package ru.mashurov.todowebapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mashurov.todowebapp.model.User;
import ru.mashurov.todowebapp.repositories.UserRepo;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(RuntimeException::new);
    }


}
