package com.prembandhan.prementity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preference {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "user_id")
	    private Long userId;

	    private String preferenceDetails;

		public Preference(Long id, Long userId, String preferenceDetails) {
			super();
			this.id = id;
			this.userId = userId;
			this.preferenceDetails = preferenceDetails;
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

	    public String getPreferenceDetails() {
	        return preferenceDetails;
	    }

	    public void setPreferenceDetails(String preferenceDetails) {
	        this.preferenceDetails = preferenceDetails;
	    }
}
