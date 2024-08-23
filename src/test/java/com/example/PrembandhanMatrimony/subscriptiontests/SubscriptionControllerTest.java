package com.example.PrembandhanMatrimony.subscriptiontests;

import com.prembandhan.premservice.SubscriptionService;
import com.prembandhan.premcontroller.SubscriptionController;
import com.prembandhan.prementity.Subscription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SubscriptionControllerTest {

    @InjectMocks
    private SubscriptionController subscriptionController;

    @Mock
    private SubscriptionService subscriptionService;

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
        when(subscriptionService.getAllSubscriptions()).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getAllSubscriptions();
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getAllSubscriptions();
    }

    @Test
    public void testGetSubscriptionById() {
        when(subscriptionService.getSubscriptionById(1L)).thenReturn(subscription);

        Subscription result = subscriptionController.getSubscriptionById(1L);
        assertEquals(subscription, result);
        verify(subscriptionService, times(1)).getSubscriptionById(1L);
    }

    @Test
    public void testGetSubscriptionsByUserId() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByUserId(1L)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByUserId(1L);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByUserId(1L);
    }

    @Test
    public void testCreateSubscription() {
        when(subscriptionService.createSubscription(subscription)).thenReturn(subscription);

        Subscription result = subscriptionController.createSubscription(subscription);
        assertEquals(subscription, result);
        verify(subscriptionService, times(1)).createSubscription(subscription);
    }

    @Test
    public void testUpdateSubscription() {
        when(subscriptionService.updateSubscription(subscription)).thenReturn(subscription);

        Subscription result = subscriptionController.updateSubscription(subscription);
        assertEquals(subscription, result);
        verify(subscriptionService, times(1)).updateSubscription(subscription);
    }

    @Test
    public void testDeleteSubscriptionById() {
        doNothing().when(subscriptionService).deleteSubscriptionById(1L);

        subscriptionController.deleteSubscriptionById(1L);
        verify(subscriptionService, times(1)).deleteSubscriptionById(1L);
    }

    @Test
    public void testGetSubscriptionsByAmountRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByAmountRange(50.0, 150.0)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByAmountRange(50.0, 150.0);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByAmountRange(50.0, 150.0);
    }

    @Test
    public void testGetSubscriptionsByDateRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByDateRange("2022-01-01", "2022-12-31")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByDateRange("2022-01-01", "2022-12-31");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByDateRange("2022-01-01", "2022-12-31");
    }

    @Test
    public void testGetSubscriptionsByUserIdAndAmountRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByUserIdAndAmountRange(1L, 50.0, 150.0)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByUserIdAndAmountRange(1L, 50.0, 150.0);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByUserIdAndAmountRange(1L, 50.0, 150.0);
    }

    @Test
    public void testGetSubscriptionsByUserIdAndDateRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByUserIdAndDateRange(1L, "2022-01-01", "2022-12-31")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByUserIdAndDateRange(1L, "2022-01-01", "2022-12-31");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByUserIdAndDateRange(1L, "2022-01-01", "2022-12-31");
    }

    @Test
    public void testCountSubscriptionsByUserId() {
        when(subscriptionService.countSubscriptionsByUserId(1L)).thenReturn(1L);

        long result = subscriptionController.countSubscriptionsByUserId(1L);
        assertEquals(1L, result);
        verify(subscriptionService, times(1)).countSubscriptionsByUserId(1L);
    }

    @Test
    public void testGetSubscriptionsByStatus() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByStatus("active")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByStatus("active");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByStatus("active");
    }

    @Test
    public void testGetActiveSubscriptions() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getActiveSubscriptions()).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getActiveSubscriptions();
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getActiveSubscriptions();
    }

    @Test
    public void testGetSubscriptionsByDurationRange() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByDurationRange(20, 40)).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByDurationRange(20, 40);
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByDurationRange(20, 40);
    }

    @Test
    public void testGetSubscriptionsByType() {
        List<Subscription> subscriptions = Arrays.asList(subscription);
        when(subscriptionService.getSubscriptionsByType("monthly")).thenReturn(subscriptions);

        List<Subscription> result = subscriptionController.getSubscriptionsByType("monthly");
        assertEquals(1, result.size());
        assertEquals(subscription, result.get(0));
        verify(subscriptionService, times(1)).getSubscriptionsByType("monthly");
    }
}

