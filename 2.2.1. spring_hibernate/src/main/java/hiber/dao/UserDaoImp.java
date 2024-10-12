package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.SQLOutput;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void userWithCar(String modelCar, int seriesCar) {
        String hql = "FROM User usrs LEFT OUTER JOIN FETCH usrs.userCar car WHERE car.model =: modelCar AND car.series =: seriesCar";
        User user = sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("modelCar", modelCar)
                .setParameter("seriesCar", seriesCar).uniqueResult();
        if (user != null) {
            System.out.println("\n Найден пользователь по заданным параметрам автомобиля:  ");
            System.out.println(user + "\n");
        } else {
            System.out.println("\n Пользователь не найден...\n");
        }


    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User ");
        return query.getResultList();
    }

}
