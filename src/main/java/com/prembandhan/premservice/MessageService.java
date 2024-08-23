package com.prembandhan.premservice;

import com.prembandhan.premdao.MessageDao;
import com.prembandhan.prementity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    // Existing methods...

    public List<Message> getMessagesSortedByTimestamp(String sortOrder) {
        return messageDao.getMessagesSortedByTimestamp(sortOrder);
    }

    public List<Message> getMessagesByStatusAndDateRange(String status, String startDate, String endDate) {
        return messageDao.getMessagesByStatusAndDateRange(status, startDate, endDate);
    }

    public long countMessagesByUserId(Long userId) {
        return messageDao.countMessagesByUserId(userId);
    }

    public long countMessagesByStatus(String status) {
        return messageDao.countMessagesByStatus(status);
    }

    public Message getLatestMessageForUser(Long userId) {
        return messageDao.getLatestMessageForUser(userId);
    }

    public List<Message> getMessagesByUserIdAndStatus(Long userId, String status) {
        return messageDao.getMessagesByUserIdAndStatus(userId, status);
    }

    public List<Message> getMessagesByUserIdOrContent(Long userId, String content) {
        return messageDao.getMessagesByUserIdOrContent(userId, content);
    }

   

    public List<Message> getMessagesByMultipleCriteria(Long userId, String content) {
        return messageDao.getMessagesByMultipleCriteria(userId, content);
    }

    public long countMessagesByUserIdAndStatus(Long userId, String status) {
        return messageDao.countMessagesByUserIdAndStatus(userId, status);
    }
}

   