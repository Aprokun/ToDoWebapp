package ru.mashurov.todowebapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mashurov.todowebapp.model.Task;
import ru.mashurov.todowebapp.repositories.TaskRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private  final TaskRepo taskRepo;

    public List<Task> getAllByUserId(Long userId) {
        return taskRepo.findAllByUserId(userId).orElse(Collections.emptyList());
    }
}
