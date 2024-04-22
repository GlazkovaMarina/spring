create table tasks (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         description VARCHAR(50) NOT NULL,
                         task_status VARCHAR(12),
                         local_date_time TIMESTAMP
);