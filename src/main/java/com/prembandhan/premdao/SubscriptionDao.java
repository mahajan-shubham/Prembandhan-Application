package com.prembandhan.premdao;

import com.prembandhan.prementity.Subscription;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriptionDao {

    @Autowired
    private SessionFactory factory;

    public List<Subscription> getAllSubscriptions() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

    public Subscription getSubscriptionById(Long id) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("id", id));
        Subscription subscription = (Subscription) criteria.uniqueResult();
        session.close();
        return subscription;
    }

    public Subscription createSubscription(Subscription subscription) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(subscription);
        session.getTransaction().commit();
        session.close();
        return subscription;
    }

    public Subscription updateSubscription(Subscription subscription) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(subscription);
        session.getTransaction().commit();
        session.close();
        return subscription;
    }

    public void deleteSubscriptionById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Subscription subscription = session.get(Subscription.class, id);
        if (subscription != null) {
            session.delete(subscription);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Subscription> getSubscriptionsByUserId(Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("userId", userId));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

    public List<Subscription> getSubscriptionsByAmountRange(double minAmount, double maxAmount) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.between("amount", minAmount, maxAmount));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

    public List<Subscription> getSubscriptionsByDateRange(String startDate, String endDate) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.between("startDate", startDate, endDate));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

    public List<Subscription> getSubscriptionsByUserIdAndAmountRange(Long userId, double minAmount, double maxAmount) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.between("amount", minAmount, maxAmount));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

    public List<Subscription> getSubscriptionsByUserIdAndDateRange(Long userId, String startDate, String endDate) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.between("startDate", startDate, endDate));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

//    public void updateSubscriptionStatusByUserId(Long userId, String status) {
//        Session session = factory.openSession();
//        session.beginTransaction();
//        Criteria criteria = session.createCriteria(Subscription.class);
//        criteria.add(Restrictions.eq("userId", userId));
//        List<Subscription> subscriptions = criteria.list();
//        for (Subscription subscription : subscriptions) {
//            subscription.setStartDate(status);
//            session.update(subscription);
//        }
//        session.getTransaction().commit();
//        session.close();
//    }

    public long countSubscriptionsByUserId(Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("userId", userId));
        long count = (long) criteria.list().size();
        session.close();
        return count;
    }
    
    public List<Subscription> getSubscriptionsByStatus(String status) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("status", status));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

    public List<Subscription> getActiveSubscriptions() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("status", "active"));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

//    public Subscription deactivateSubscription(Long id) {
//        Session session = factory.openSession();
//        session.beginTransaction();
//        Subscription subscription = session.get(Subscription.class, id);
//        if (subscription != null) {
//            subscription.setStatus("inactive");
//            session.update(subscription);
//        }
//        session.getTransaction().commit();
//        session.close();
//        return subscription;
//    }
//
//    public Subscription extendSubscriptionDuration(Long id, int extraDays) {
//        Session session = factory.openSession();
//        session.beginTransaction();
//        Subscription subscription = session.get(Subscription.class, id);
//        if (subscription != null) {
//            subscription.setDuration(subscription.getDuration() + extraDays);
//            session.update(subscription);
//        }
//        session.getTransaction().commit();
//        session.close();
//        return subscription;
//    }

    public List<Subscription> getSubscriptionsByDurationRange(int minDays, int maxDays) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.between("duration", minDays, maxDays));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }

    public List<Subscription> getSubscriptionsByType(String type) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Subscription.class);
        criteria.add(Restrictions.eq("type", type));
        List<Subscription> subscriptions = criteria.list();
        session.close();
        return subscriptions;
    }
}

