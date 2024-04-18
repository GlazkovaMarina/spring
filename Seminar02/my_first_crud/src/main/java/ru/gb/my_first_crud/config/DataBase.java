package ru.gb.my_first_crud.config;

import lombok.Setter;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "db")
public class DataBase {
    private String findAll;
    private String save;
    private String deleteById;
    private String updateUser;
}
