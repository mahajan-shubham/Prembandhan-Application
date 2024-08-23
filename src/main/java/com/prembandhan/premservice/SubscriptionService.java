package com.prembandhan.premservice;

import com.prembandhan.premdao.SubscriptionDao;
import com.prembandhan.prementity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionDao.getAllSubscriptions();
    }

    public Subscription getSubscriptionById(Long id) {
        return subscriptionDao.getSubscriptionById(id);
    }

    public List<Subscription> getSubscriptionsByUserId(Long userId) {
        return subscriptionDao.getSubscriptionsByUserId(userId);
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionDao.createSubscription(subscription);
    }

    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionDao.updateSubscription(subscription);
    }

    public void deleteSubscriptionById(Long id) {
        subscriptionDao.deleteSubscriptionById(id);
    }

    public List<Subscription> getSubscriptionsByAmountRange(double minAmount, double maxAmount) {
        return subscriptionDao.getSubscriptionsByAmountRange(minAmount, maxAmount);
    }

    public List<Subscription> getSubscriptionsByDateRange(String startDate, String endDate) {
        return subscriptionDao.getSubscriptionsByDateRange(startDate, endDate);
    }

    public List<Subscription> getSubscriptionsByUserIdAndAmountRange(Long userId, double minAmount, double maxAmount) {
        return subscriptionDao.getSubscriptionsByUserIdAndAmountRange(userId, minAmount, maxAmount);
    }

    public List<Subscription> getSubscriptionsByUserIdAndDateRange(Long userId, String startDate, String endDate) {
        return subscriptionDao.getSubscriptionsByUserIdAndDateRange(userId, startDate, endDate);
    }

//    public void updateSubscriptionStatusByUserId(Long userId, String status) {
//        subscriptionDao.updateSubscriptionStatusByUserId(userId, status);
//    }

    public long countSubscriptionsByUserId(Long userId) {
        return subscriptionDao.countSubscriptionsByUserId(userId);
    }
    
    public List<Subscription> getSubscriptionsByStatus(String status) {
        return subscriptionDao.getSubscriptionsByStatus(status);
    }

    public List<Subscription> getActiveSubscriptions() {
        return subscriptionDao.getActiveSubscriptions();
    }

//    public Subscription deactivateSubscription(Long id) {
//        return subscriptionDao.deactivateSubscription(id);
//    }
//
//    public Subscription extendSubscriptionDuration(Long id, int extraDays) {
//        return subscriptionDao.extendSubscriptionDuration(id, extraDays);
//    }

    public List<Subscription> getSubscriptionsByDurationRange(int minDays, int maxDays) {
        return subscriptionDao.getSubscriptionsByDurationRange(minDays, maxDays);
    }

    public List<Subscription> getSubscriptionsByType(String type) {
        return subscriptionDao.getSubscriptionsByType(type);
    }
}

