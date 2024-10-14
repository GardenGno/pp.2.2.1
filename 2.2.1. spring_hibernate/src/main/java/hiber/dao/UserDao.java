package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getListUsers();

    void getUserWithCar(String modelCar, int seriesCar);
}
