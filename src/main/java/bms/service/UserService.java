package bms.service;

import bms.dao.Database;
import bms.models.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    private final Database db =  Database.init();

    public List<User> getUsers() {
        return db.users;
    }

    public Optional<User> getUserByName(String name) {
        if(name == null)
            throw new IllegalArgumentException("null not allowed");
        return db.users.stream().filter(user -> user.name.equals(name)).findFirst();
    }

}
