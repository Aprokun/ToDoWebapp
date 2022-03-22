package ru.mashurov.todowebapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mashurov.todowebapp.model.User;
import ru.mashurov.todowebapp.security.UserDetailsWrapper;
import ru.mashurov.todowebapp.services.TaskService;
import ru.mashurov.todowebapp.services.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mytasks")
public class MyTasksPageController {

    private final TaskService taskService;

    private final UserService userService;

    @GetMapping
    public String page(Model model) {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("userTasks", user.getTasks());
        return "index";
    }
}
