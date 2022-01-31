package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user); // Добавляет юзеров
    List<User> listUsers(); //Список юзеров

    List<User> listUsersOnCar(String model, int series);
}