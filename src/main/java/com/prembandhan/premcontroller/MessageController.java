package com.prembandhan.premcontroller;

import com.prembandhan.premservice.MessageService;
import com.prembandhan.prementity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Existing methods...

    @GetMapping("/sortedByTimestamp")
    public List<Message> getMessagesSortedByTimestamp(@RequestParam String sortOrder) {
        return messageService.getMessagesSortedByTimestamp(sortOrder);
    }

    @GetMapping("/byStatusAndDateRange")
    public List<Message> getMessagesByStatusAndDateRange(@RequestParam String status,
                                                         @RequestParam String startDate,
                                                         @RequestParam String endDate) {
        return messageService.getMessagesByStatusAndDateRange(status, startDate, endDate);
    }

    @GetMapping("/countByUserId")
    public long countMessagesByUserId(@RequestParam Long userId) {
        return messageService.countMessagesByUserId(userId);
    }

    @GetMapping("/countByStatus")
    public long countMessagesByStatus(@RequestParam String status) {
        return messageService.countMessagesByStatus(status);
    }

    @GetMapping("/latestForUser")
    public Message getLatestMessageForUser(@RequestParam Long userId) {
        return messageService.getLatestMessageForUser(userId);
    }

    // Additional endpoints for demonstration

    @GetMapping("/byUserIdOrContent")
    public List<Message> getMessagesByUserIdOrContent(@RequestParam(required = false) Long userId,
                                                      @RequestParam(required = false) String content) {
        return messageService.getMessagesByMultipleCriteria(userId, content);
    }

    @GetMapping("/byStatusAndUserId")
    public List<Message> getMessagesByStatusAndUserId(@RequestParam String status,
                                                      @RequestParam Long userId) {
        return messageService.getMessagesByUserIdAndStatus(userId, status);
    }

    @GetMapping("/countByUserIdAndStatus")
    public long countMessagesByUserIdAndStatus(@RequestParam Long userId, @RequestParam String status) {
        return messageService.getMessagesByUserIdAndStatus(userId, status).size();
    }
}

