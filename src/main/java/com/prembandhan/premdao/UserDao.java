package com.prembandhan.premdao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prembandhan.prementity.User;

@Repository
public class UserDao {

    @Autowired
    SessionFactory factory;
    
    public User createUser(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        criteria.add(Restrictions.eq("password", password));
        User user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    public List<User> getAllUsers() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public User getUserById(Long id) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        User user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    public User updateUser(User user) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public void deleteById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, id);
        if (user != null) {
            session.delete(user);
        }
        session.getTransaction().commit();
        session.close();
    }

    public User getUserByEmail(String email) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();
        session.close();
        return user;
    }

    public List<User> getUsersByCity(String city) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("city", city));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getUsersByGender(String gender) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("gender", gender));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> searchUsers(String keyword) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.or(
                Restrictions.like("name", "%" + keyword + "%"),
                Restrictions.like("email", "%" + keyword + "%")
        ));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public boolean existsByEmail(String email) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        boolean exists = criteria.uniqueResult() != null;
        session.close();
        return exists;
    }

    public long countUsers() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        session.close();
        return count;
    }

    public List<User> getUsersWithPagination(int page, int size) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.setFirstResult(page * size);
        criteria.setMaxResults(size);
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getUsersSortedBy(String sortBy) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.addOrder(Order.asc(sortBy));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getRecentUsers() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.addOrder(Order.desc("id"));
        criteria.setMaxResults(10);
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getAdminUsers() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("isAdmin", true));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getUsersByLastName(String lastName) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("lastName", lastName));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getActiveUsers() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("status", "ACTIVE"));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getInactiveUsers() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("status", "INACTIVE"));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getUsersByAgeRange(int minAge, int maxAge) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.between("age", minAge, maxAge));
        List<User> users = criteria.list();
        session.close();
        return users;
    }

    public List<User> getUsersByJoiningDate(String startDate, String endDate) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.between("joiningDate", startDate, endDate));
        List<User> users = criteria.list();
        session.close();
        return users;
    }
}
