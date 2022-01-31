package hiber.dao;

import hiber.model.User;
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
    @SuppressWarnings("unchecked")
    //сообщает компилятору, что программист считает код безопасным и не вызовет непредвиденных исключений.
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public List<User> listUsersOnCar(String model, int series) {
        String hql = "from User u join fetch u.car as c where c.model = :model and c.series = :series";
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getResultList();


    }
}
