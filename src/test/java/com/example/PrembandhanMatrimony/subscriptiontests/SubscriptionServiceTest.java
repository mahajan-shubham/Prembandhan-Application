package com.example.PrembandhanMatrimony.subscriptiontests;

import com.prembandhan.premdao.SubscriptionDao;
import com.prembandhan.prementity.Subscription;
import com.prembandhan.premservice.SubscriptionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SubscriptionServiceTest {

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Mock
    private SubscriptionDao subscriptionDao;

    private Subscription subscription;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        subscription = new Subscription();
        subscription.setId(1L);
        subscription.setUserId(1L);
        subscription.setAmount(100.0);
       
    }

    @Test
    public void testGetAllSubscriptions() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getAllSubscriptions()).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getAllSubscriptions();
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getAllSubscriptions();
    }

    @Test
    public void testGetSubscriptionById() {
        when(subscriptionDao.getSubscriptionById(1L)).thenReturn(subscription);

        Subscription result = subscriptionService.getSubscriptionById(1L);
        assertEquals(subscription, result);
        verify(subscriptionDao, times(1)).getSubscriptionById(1L);
    }

    @Test
    public void testGetSubscriptionsByUserId() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByUserId(1L)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByUserId(1L);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByUserId(1L);
    }

    @Test
    public void testCreateSubscription() {
        when(subscriptionDao.createSubscription(subscription)).thenReturn(subscription);

        Subscription result = subscriptionService.createSubscription(subscription);
        assertEquals(subscription, result);
        verify(subscriptionDao, times(1)).createSubscription(subscription);
    }

    @Test
    public void testUpdateSubscription() {
        when(subscriptionDao.updateSubscription(subscription)).thenReturn(subscription);

        Subscription result = subscriptionService.updateSubscription(subscription);
        assertEquals(subscription, result);
        verify(subscriptionDao, times(1)).updateSubscription(subscription);
    }

    @Test
    public void testDeleteSubscriptionById() {
        doNothing().when(subscriptionDao).deleteSubscriptionById(1L);

        subscriptionService.deleteSubscriptionById(1L);
        verify(subscriptionDao, times(1)).deleteSubscriptionById(1L);
    }

    @Test
    public void testGetSubscriptionsByAmountRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByAmountRange(50.0, 150.0)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByAmountRange(50.0, 150.0);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByAmountRange(50.0, 150.0);
    }

    @Test
    public void testGetSubscriptionsByDateRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByDateRange("2022-01-01", "2022-12-31")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByDateRange("2022-01-01", "2022-12-31");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByDateRange("2022-01-01", "2022-12-31");
    }

    @Test
    public void testGetSubscriptionsByUserIdAndAmountRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByUserIdAndAmountRange(1L, 50.0, 150.0)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByUserIdAndAmountRange(1L, 50.0, 150.0);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByUserIdAndAmountRange(1L, 50.0, 150.0);
    }

    @Test
    public void testGetSubscriptionsByUserIdAndDateRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByUserIdAndDateRange(1L, "2022-01-01", "2022-12-31")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByUserIdAndDateRange(1L, "2022-01-01", "2022-12-31");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByUserIdAndDateRange(1L, "2022-01-01", "2022-12-31");
    }

    @Test
    public void testCountSubscriptionsByUserId() {
        when(subscriptionDao.countSubscriptionsByUserId(1L)).thenReturn(1L);

        long result = subscriptionService.countSubscriptionsByUserId(1L);
        assertEquals(1L, result);
        verify(subscriptionDao, times(1)).countSubscriptionsByUserId(1L);
    }

    @Test
    public void testGetSubscriptionsByStatus() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByStatus("active")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByStatus("active");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByStatus("active");
    }

    @Test
    public void testGetActiveSubscriptions() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getActiveSubscriptions()).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getActiveSubscriptions();
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getActiveSubscriptions();
    }

    @Test
    public void testGetSubscriptionsByDurationRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByDurationRange(20, 40)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByDurationRange(20, 40);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByDurationRange(20, 40);
    }

    @Test
    public void testGetSubscriptionsByType() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionDao.getSubscriptionsByType("monthly")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionService.getSubscriptionsByType("monthly");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionDao, times(1)).getSubscriptionsByType("monthly");
    }
}

