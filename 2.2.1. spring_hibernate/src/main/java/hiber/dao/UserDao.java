package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user); //Добавляет пользователей

   List<User> listUsers(); //Лист пользователей

   List<User> listUsersOnCar(String model, int series); //Таблица машин
}
