package com.example.PrembandhanMatrimony.messageTest;

import com.prembandhan.premservice.MessageService;
import com.prembandhan.premcontroller.MessageController;
import com.prembandhan.prementity.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MessageControllerTest {

    @InjectMocks
    private MessageController messageController;

    @Mock
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMessagesSortedByTimestamp() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageService.getMessagesSortedByTimestamp("asc")).thenReturn(messages);

        List<Message> result = messageController.getMessagesSortedByTimestamp("asc");

        assertEquals(2, result.size());
        verify(messageService, times(1)).getMessagesSortedByTimestamp("asc");
    }

    @Test
    void testGetMessagesByStatusAndDateRange() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageService.getMessagesByStatusAndDateRange("status", "2023-01-01", "2023-12-31")).thenReturn(messages);

        List<Message> result = messageController.getMessagesByStatusAndDateRange("status", "2023-01-01", "2023-12-31");

        assertEquals(2, result.size());
        verify(messageService, times(1)).getMessagesByStatusAndDateRange("status", "2023-01-01", "2023-12-31");
    }

    @Test
    void testCountMessagesByUserId() {
        when(messageService.countMessagesByUserId(1L)).thenReturn(5L);

        long result = messageController.countMessagesByUserId(1L);

        assertEquals(5L, result);
        verify(messageService, times(1)).countMessagesByUserId(1L);
    }

    @Test
    void testCountMessagesByStatus() {
        when(messageService.countMessagesByStatus("status")).thenReturn(5L);

        long result = messageController.countMessagesByStatus("status");

        assertEquals(5L, result);
        verify(messageService, times(1)).countMessagesByStatus("status");
    }

    @Test
    void testGetLatestMessageForUser() {
        Message message = new Message();
        when(messageService.getLatestMessageForUser(1L)).thenReturn(message);

        Message result = messageController.getLatestMessageForUser(1L);

        assertEquals(message, result);
        verify(messageService, times(1)).getLatestMessageForUser(1L);
    }

    @Test
    void testGetMessagesByUserIdOrContent() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageService.getMessagesByMultipleCriteria(1L, "content")).thenReturn(messages);

        List<Message> result = messageController.getMessagesByUserIdOrContent(1L, "content");

        assertEquals(2, result.size());
        verify(messageService, times(1)).getMessagesByMultipleCriteria(1L, "content");
    }

    @Test
    void testGetMessagesByStatusAndUserId() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageService.getMessagesByUserIdAndStatus(1L, "status")).thenReturn(messages);

        List<Message> result = messageController.getMessagesByStatusAndUserId("status", 1L);

        assertEquals(2, result.size());
        verify(messageService, times(1)).getMessagesByUserIdAndStatus(1L, "status");
    }

    @Test
    void testCountMessagesByUserIdAndStatus() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageService.getMessagesByUserIdAndStatus(1L, "status")).thenReturn(messages);

        long result = messageController.countMessagesByUserIdAndStatus(1L, "status");

        assertEquals(2, result);
        verify(messageService, times(1)).getMessagesByUserIdAndStatus(1L, "status");
    }
}

