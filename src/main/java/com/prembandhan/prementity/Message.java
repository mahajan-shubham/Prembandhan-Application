package com.prembandhan.prementity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "sender_id")
	    private Long senderId;

	    @Column(name = "receiver_id")
	    private Long receiverId;

	    private String content;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date timestamp;

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getSenderId() {
	        return senderId;
	    }

	    public void setSenderId(Long senderId) {
	        this.senderId = senderId;
	    }

	    public Long getReceiverId() {
	        return receiverId;
	    }

	    public void setReceiverId(Long receiverId) {
	        this.receiverId = receiverId;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(Date timestamp) {
	        this.timestamp = timestamp;
	    }

		
}
