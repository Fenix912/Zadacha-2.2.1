package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity // Данная вннотация готоворит о том, что данный класс будет отображен в базе данных
@Table(name = "users") // Прописываем с какой таблицей будем связаны
public class User {

   @Id // данный солбец будет в таблице праймариКей
   @GeneratedValue(strategy = GenerationType.IDENTITY) // описывает стратегию по генерации значения ПраймериКей
   private Long id;

   @Column(name = "name") // указываем с каким столбцом в таблице делаем связку
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL) // тип отношений м/у объектами(если делаем определенные операции с users,
   // возможно информация о Car будет изменена, сохранение, удаление)
   @JoinColumn(name = "car_id") //С помощью столбца (car_id -ForenKey )осуществляется свять между таблицами
   private Car car;

   public User() {}

   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car=car;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Car getCar() {
      return car;
   }

}