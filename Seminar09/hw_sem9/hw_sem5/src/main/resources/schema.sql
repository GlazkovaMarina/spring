
CREATE TABLE IF NOT EXISTS tasks_table{
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(50) NOT NULL,
    task_status VARCHAR(12),
    local_date_time TIMESTAMP
);