package com.learning.jenkins.repo;

import com.learning.jenkins.entity.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("userRepo")
public class UserRepo {

    private Integer id = 0;

    private List<User> userList = new ArrayList<>();

    @PostConstruct
    public void init() {
        userList.add(new User(++id, "Nishant", "Charan", "nishant.charan@test.com", "Pune", "India"));
        userList.add(new User(++id, "Shailja", "Srivastava", "shailja.srivastava@test.com", "Bangalore", "India"));
    }

    public List<User> getAll() {
        return userList;
    }

    public Optional<User> getById(Integer userId) {
        return userList.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    public User save(User user) {
        User userToBeSaved = new User(++id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getCity(), user.getCountry());
        userList.add(userToBeSaved);
        return userToBeSaved;
    }

    public User update(Integer userId, User user) {
        User userToBeUpdated = userList.stream().filter(user1 -> user1.getId().equals(userId)).findAny().get();
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setCity(user.getCity());
        userToBeUpdated.setCountry(user.getCountry());
        return userToBeUpdated;
    }
}
