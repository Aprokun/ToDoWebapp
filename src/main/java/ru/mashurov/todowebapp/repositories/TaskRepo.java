package ru.mashurov.todowebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mashurov.todowebapp.model.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    Optional<List<Task>> findAllByUserId(Long userId);
}
