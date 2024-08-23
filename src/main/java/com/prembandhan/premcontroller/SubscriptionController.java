package com.prembandhan.premcontroller;

import com.prembandhan.premservice.SubscriptionService;
import com.prembandhan.prementity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    // Existing methods...

    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @GetMapping("/byUserId/{userId}")
    public List<Subscription> getSubscriptionsByUserId(@PathVariable Long userId) {
        return subscriptionService.getSubscriptionsByUserId(userId);
    }

    @PostMapping("/create")
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }

    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubscriptionById(@PathVariable Long id) {
        subscriptionService.deleteSubscriptionById(id);
    }

    @GetMapping("/byAmountRange")
    public List<Subscription> getSubscriptionsByAmountRange(@RequestParam double minAmount, @RequestParam double maxAmount) {
        return subscriptionService.getSubscriptionsByAmountRange(minAmount, maxAmount);
    }

    @GetMapping("/byDateRange")
    public List<Subscription> getSubscriptionsByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return subscriptionService.getSubscriptionsByDateRange(startDate, endDate);
    }

    @GetMapping("/byUserIdAndAmountRange")
    public List<Subscription> getSubscriptionsByUserIdAndAmountRange(@RequestParam Long userId, @RequestParam double minAmount, @RequestParam double maxAmount) {
        return subscriptionService.getSubscriptionsByUserIdAndAmountRange(userId, minAmount, maxAmount);
    }

    @GetMapping("/byUserIdAndDateRange")
    public List<Subscription> getSubscriptionsByUserIdAndDateRange(@RequestParam Long userId, @RequestParam String startDate, @RequestParam String endDate) {
        return subscriptionService.getSubscriptionsByUserIdAndDateRange(userId, startDate, endDate);
    }

//    @PutMapping("/updateStatus")
//    public void updateSubscriptionStatusByUserId(@RequestParam Long userId, @RequestParam String status) {
//        subscriptionService.updateSubscriptionStatusByUserId(userId, status);
//    }

    @GetMapping("/countByUserId")
    public long countSubscriptionsByUserId(@RequestParam Long userId) {
        return subscriptionService.countSubscriptionsByUserId(userId);
    }

    // New methods...

    @GetMapping("/byStatus")
    public List<Subscription> getSubscriptionsByStatus(@RequestParam String status) {
        return subscriptionService.getSubscriptionsByStatus(status);
    }

    @GetMapping("/active")
    public List<Subscription> getActiveSubscriptions() {
        return subscriptionService.getActiveSubscriptions();
    }

//    @PutMapping("/deactivate/{id}")
//    public Subscription deactivateSubscription(@PathVariable Long id) {
//        return subscriptionService.deactivateSubscription(id);
//    }
//
//    @PutMapping("/extendDuration/{id}")
//    public Subscription extendSubscriptionDuration(@PathVariable Long id, @RequestParam int extraDays) {
//        return subscriptionService.extendSubscriptionDuration(id, extraDays);
//    }

    @GetMapping("/byDurationRange")
    public List<Subscription> getSubscriptionsByDurationRange(@RequestParam int minDays, @RequestParam int maxDays) {
        return subscriptionService.getSubscriptionsByDurationRange(minDays, maxDays);
    }

    @GetMapping("/byType")
    public List<Subscription> getSubscriptionsByType(@RequestParam String type) {
        return subscriptionService.getSubscriptionsByType(type);
    }
}
