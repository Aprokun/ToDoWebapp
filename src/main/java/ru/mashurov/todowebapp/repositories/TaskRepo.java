package ru.mashurov.todowebapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mashurov.todowebapp.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
}
