package com.example.PrembandhanMatrimony.messageTest;

import com.prembandhan.premdao.MessageDao;
import com.prembandhan.prementity.Message;
import com.prembandhan.premservice.MessageService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageDao messageDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMessagesSortedByTimestamp() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageDao.getMessagesSortedByTimestamp("asc")).thenReturn(messages);

        List<Message> result = messageService.getMessagesSortedByTimestamp("asc");

        assertEquals(2, result.size());
        verify(messageDao, times(1)).getMessagesSortedByTimestamp("asc");
    }

    @Test
    void testGetMessagesByStatusAndDateRange() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageDao.getMessagesByStatusAndDateRange("status", "2023-01-01", "2023-12-31")).thenReturn(messages);

        List<Message> result = messageService.getMessagesByStatusAndDateRange("status", "2023-01-01", "2023-12-31");

        assertEquals(2, result.size());
        verify(messageDao, times(1)).getMessagesByStatusAndDateRange("status", "2023-01-01", "2023-12-31");
    }

    @Test
    void testCountMessagesByUserId() {
        when(messageDao.countMessagesByUserId(1L)).thenReturn(5L);

        long result = messageService.countMessagesByUserId(1L);

        assertEquals(5L, result);
        verify(messageDao, times(1)).countMessagesByUserId(1L);
    }

    @Test
    void testCountMessagesByStatus() {
        when(messageDao.countMessagesByStatus("status")).thenReturn(5L);

        long result = messageService.countMessagesByStatus("status");

        assertEquals(5L, result);
        verify(messageDao, times(1)).countMessagesByStatus("status");
    }

    @Test
    void testGetLatestMessageForUser() {
        Message message = new Message();
        when(messageDao.getLatestMessageForUser(1L)).thenReturn(message);

        Message result = messageService.getLatestMessageForUser(1L);

        assertEquals(message, result);
        verify(messageDao, times(1)).getLatestMessageForUser(1L);
    }

    @Test
    void testGetMessagesByUserIdAndStatus() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageDao.getMessagesByUserIdAndStatus(1L, "status")).thenReturn(messages);

        List<Message> result = messageService.getMessagesByUserIdAndStatus(1L, "status");

        assertEquals(2, result.size());
        verify(messageDao, times(1)).getMessagesByUserIdAndStatus(1L, "status");
    }

    @Test
    void testGetMessagesByUserIdOrContent() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageDao.getMessagesByUserIdOrContent(1L, "content")).thenReturn(messages);

        List<Message> result = messageService.getMessagesByUserIdOrContent(1L, "content");

        assertEquals(2, result.size());
        verify(messageDao, times(1)).getMessagesByUserIdOrContent(1L, "content");
    }

    @Test
    void testGetMessagesByMultipleCriteria() {
        List<Message> messages = Arrays.asList(new Message(), new Message());
        when(messageDao.getMessagesByMultipleCriteria(1L, "content")).thenReturn(messages);

        List<Message> result = messageService.getMessagesByMultipleCriteria(1L, "content");

        assertEquals(2, result.size());
        verify(messageDao, times(1)).getMessagesByMultipleCriteria(1L, "content");
    }

    @Test
    void testCountMessagesByUserIdAndStatus() {
        when(messageDao.countMessagesByUserIdAndStatus(1L, "status")).thenReturn(5L);

        long result = messageService.countMessagesByUserIdAndStatus(1L, "status");

        assertEquals(5L, result);
        verify(messageDao, times(1)).countMessagesByUserIdAndStatus(1L, "status");
    }
}

