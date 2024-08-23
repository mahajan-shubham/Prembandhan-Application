package com.prembandhan.premdao;

import com.prembandhan.prementity.Message;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDao {

    @Autowired
    private SessionFactory factory;

    // Existing methods...

    public List<Message> getMessagesSortedByTimestamp(String sortOrder) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        if ("asc".equalsIgnoreCase(sortOrder)) {
            criteria.addOrder(Order.asc("timestamp"));
        } else {
            criteria.addOrder(Order.desc("timestamp"));
        }
        List<Message> messages = criteria.list();
        session.close();
        return messages;
    }

    public List<Message> getMessagesByKeyword(Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.like("messageContent", "%" + userId + "%"));
        List<Message> messages = criteria.list();
        session.close();
        return messages;
    }

    public List<Message> getMessagesByStatusAndDateRange(String status, String startDate, String endDate) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("status", status));
        criteria.add(Restrictions.between("timestamp", startDate, endDate));
        List<Message> messages = criteria.list();
        session.close();
        return messages;
    }

    public long countMessagesByUserId(Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("userId", userId));
        long count = criteria.list().size();
        session.close();
        return count;
    }

    public long countMessagesByStatus(String status) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("status", status));
        long count = criteria.list().size();
        session.close();
        return count;
    }

    public Message getLatestMessageForUser(Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.addOrder(Order.desc("timestamp"));
        criteria.setMaxResults(1);
        Message message = (Message) criteria.uniqueResult();
        session.close();
        return message;
    }

    public List<Message> getMessagesByUserIdAndStatus(Long userId, String status) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("status", status));
        List<Message> messages = criteria.list();
        session.close();
        return messages;
    }

    public List<Message> getMessagesByUserIdOrContent(Long userId, String content) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        if (userId != null) {
            criteria.add(Restrictions.eq("userId", userId));
        }
        if (content != null) {
            criteria.add(Restrictions.like("messageContent", "%" + content + "%"));
        }
        List<Message> messages = criteria.list();
        session.close();
        return messages;
    }

    public List<Message> getMessagesByMultipleCriteria(Long userId, String content) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        if (userId != null) {
            criteria.add(Restrictions.eq("userId", userId));
        }
        if (content != null) {
            criteria.add(Restrictions.like("messageContent", "%" + content + "%"));
        }
        List<Message> messages = criteria.list();
        session.close();
        return messages;
    }

    public long countMessagesByUserIdAndStatus(Long userId, String status) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("status", status));
        long count = criteria.list().size();
        session.close();
        return count;
    }

	

	
}
