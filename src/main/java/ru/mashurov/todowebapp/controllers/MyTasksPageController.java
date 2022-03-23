package ru.mashurov.todowebapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.cache.CacheManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mashurov.todowebapp.model.User;
import ru.mashurov.todowebapp.services.TaskService;
import ru.mashurov.todowebapp.services.UserService;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mytasks")
public class MyTasksPageController {

    private final UserService userService;

    private final TaskService taskService;

    @GetMapping
    public String page(Model model) {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("tasks", user.getTasks());
        return "index";
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String page(@PathVariable Long id) {
        User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        //TODO: add removing task without using task service
        taskService.deleteTaskById(id);
        user.getTasks().removeIf(task -> Objects.equals(task.getId(), id));
        return "redirect:/mytasks";
    }

}
