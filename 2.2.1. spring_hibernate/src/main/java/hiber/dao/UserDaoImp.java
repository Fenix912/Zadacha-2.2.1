package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository //Указывает, что класс используе/.тся для работы с поиском, получением и хранением данных.
public class UserDaoImp implements UserDao {

    @Autowired  //Для внедрения зависимостей
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked") //сообщает компилятору, что программист считает код безопасным и не вызовет непредвиденных исключений.
    public List<User> listUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


    public List<User> listUsersOnCar(String model, int series) { //Получение объектов из таблицы
        List<User> users = null;
        Session session = sessionFactory.openSession(); // открытие сессии
        try {
            session.beginTransaction(); // открытие транзакции
            users = session.createQuery("FROM User u WHERE car.model =: model AND car.series =: series", User.class) //создание запроса (поиск объектов по модели и серии)
                    .setParameter("model", model)
                    .setParameter("series", series)
                    .getResultList(); // получение результата
            session.getTransaction().commit(); // закрытие транзакции
        } catch (Exception e) {
            session.getTransaction().rollback(); // откат всех модификаций
            e.printStackTrace();
        } finally {
            session.close(); // закрытие сессии
        }
        return users; //возвращает таблицу
    }
}
