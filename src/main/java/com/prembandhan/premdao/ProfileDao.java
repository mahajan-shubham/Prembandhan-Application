package com.prembandhan.premdao;

import com.prembandhan.prementity.Profile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class ProfileDao {

    @Autowired
    private SessionFactory factory;

    public List<Profile> getAllProfiles() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public Profile getProfileById(Long id) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("id", id));
        Profile profile = (Profile) criteria.uniqueResult();
        session.close();
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(profile);
        session.getTransaction().commit();
        session.close();
        return profile;
    }

    public void deleteProfileById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Profile profile = session.get(Profile.class, id);
        if (profile != null) {
            session.delete(profile);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Profile> getProfilesByUserId(Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("userId", userId));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> searchProfiles(String keyword) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.or(
            Restrictions.ilike("occupation", "%" + keyword + "%"),
            Restrictions.ilike("interest", "%" + keyword + "%"),
            Restrictions.ilike("bio", "%" + keyword + "%")
        ));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesByOccupation(String occupation) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("occupation", occupation));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesByInterest(String interest) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("interest", interest));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public Profile createProfile(Profile profile) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(profile);
        session.getTransaction().commit();
        session.close();
        return profile;
    }

    public long countProfiles() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.setProjection(org.hibernate.criterion.Projections.rowCount());
        long count = (long) criteria.uniqueResult();
        session.close();
        return count;
    }

    public List<Profile> getProfilesWithPagination(int page, int size) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.setFirstResult((page - 1) * size);
        criteria.setMaxResults(size);
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesSortedBy(String sortBy) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.addOrder(org.hibernate.criterion.Order.asc(sortBy));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public Profile getProfileByUserIdAndOccupation(Long userId, String occupation) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("occupation", occupation));
        Profile profile = (Profile) criteria.uniqueResult();
        session.close();
        return profile;
    }

    public List<Profile> getProfilesByBioContaining(String keyword) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.ilike("bio", "%" + keyword + "%"));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public void deleteAllProfiles() {
        Session session = factory.openSession();
        session.beginTransaction();
        session.createQuery("delete from Profile").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public Profile getProfileByOccupationAndInterest(String occupation, String interest) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("occupation", occupation));
        criteria.add(Restrictions.eq("interest", interest));
        Profile profile = (Profile) criteria.uniqueResult();
        session.close();
        return profile;
    }

    public List<Profile> getProfilesByBioStartsWith(String prefix) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.like("bio", prefix + "%"));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesByOccupationStartsWith(String prefix) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.like("occupation", prefix + "%"));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesByInterestStartsWith(String prefix) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.like("interest", prefix + "%"));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public Profile getProfileByUserIdAndBio(Long userId, String bio) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("bio", bio));
        Profile profile = (Profile) criteria.uniqueResult();
        session.close();
        return profile;
    }

    public List<Profile> getProfilesByMultipleCriteria(String occupation, String interest, String bio) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        if (occupation != null) {
            criteria.add(Restrictions.eq("occupation", occupation));
        }
        if (interest != null) {
            criteria.add(Restrictions.eq("interest", interest));
        }
        if (bio != null) {
            criteria.add(Restrictions.eq("bio", bio));
        }
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }
    
    public List<Profile> getRecentProfiles() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.addOrder(org.hibernate.criterion.Order.desc("createdDate")); // Assuming "createdDate" is a field in Profile
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesByAgeRange(int minAge, int maxAge) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.ge("age", minAge)); // Assuming "age" is a field in Profile
        criteria.add(Restrictions.le("age", maxAge));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesByJoiningDate(String startDate, String endDate) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.ge("joiningDate", parseDate(startDate))); // Assuming "joiningDate" is a field in Profile
        criteria.add(Restrictions.le("joiningDate", parseDate(endDate)));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public Profile getProfileByUserIdAndInterest(Long userId, String interest) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("interest", interest));
        Profile profile = (Profile) criteria.uniqueResult();
        session.close();
        return profile;
    }

    public List<Profile> getProfilesByOccupationAndBio(String occupation, String bio) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("occupation", occupation));
        criteria.add(Restrictions.eq("bio", bio));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public List<Profile> getProfilesByInterestAndBio(String interest, String bio) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("interest", interest));
        criteria.add(Restrictions.eq("bio", bio));
        List<Profile> profiles = criteria.list();
        session.close();
        return profiles;
    }

    public Profile getProfileByIdAndUserId(Long id, Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.add(Restrictions.eq("userId", userId));
        Profile profile = (Profile) criteria.uniqueResult();
        session.close();
        return profile;
    }

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr); // Adjust the date format as needed
        } catch (ParseException e) {
            throw new RuntimeException("Date parsing error", e);
        }
}
}

