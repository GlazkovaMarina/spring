package ru.gb.my_first_crud.repository;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.my_first_crud.config.DataBase;
import ru.gb.my_first_crud.model.User;

import java.util.List;
@AllArgsConstructor
@Repository
public class UserRepository {


    private final JdbcTemplate jdbc;
    private final DataBase dataBase;


    public List<User> findAll() {

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(dataBase.getFindAll(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(dataBase.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id)
    {
        jdbc.update(dataBase.getDeleteById(), id);
    }
    public void updateUser(User user){
        jdbc.update(dataBase.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }

}
