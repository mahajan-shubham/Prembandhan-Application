package com.prembandhan.prementity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "user_id")
	    private Long userId;

	    private String bio;
	    private String interests;
	    private String occupation;

	    

		public Profile(Long id, Long userId, String bio, String interests, String occupation) {
			super();
			this.id = id;
			this.userId = userId;
			this.bio = bio;
			this.interests = interests;
			this.occupation = occupation;
		}

		// Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getBio() {
	        return bio;
	    }

	    public void setBio(String bio) {
	        this.bio = bio;
	    }

	    public String getInterests() {
	        return interests;
	    }

	    public void setInterests(String interests) {
	        this.interests = interests;
	    }

	    public String getOccupation() {
	        return occupation;
	    }

	    public void setOccupation(String occupation) {
	        this.occupation = occupation;
	    }
}
