package ru.gb.hw_sem5.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import static ru.gb.hw_sem5.domain.TaskStatus.NOT_STARTED;
import static ru.gb.hw_sem5.domain.TaskStatus.IN_PROGRESS;
import static ru.gb.hw_sem5.domain.TaskStatus.COMPLETED;
import org.springframework.http.converter.HttpMessageNotReadableException;


@Data
@Entity
@Table(name = "tasks_table")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;
    @Column(name = "task_status")
    private TaskStatus taskStatus;
    @Column(name = "local_date_time")
    private LocalDateTime localDateTime =  LocalDateTime.now();
    public String getLocalDateTime(){
        return this.localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
