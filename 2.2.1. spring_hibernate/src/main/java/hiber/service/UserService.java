package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getListUsers();
    void getUserWithCar(String modelCar, int seriesCar);
}
