package com.prembandhan.premdao;

import com.prembandhan.prementity.Preference;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PreferenceDao {

    @Autowired
    private SessionFactory factory;

    public List<Preference> getAllPreferences() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        List<Preference> preferences = criteria.list();
        session.close();
        return preferences;
    }

    public Preference getPreferenceById(Long id) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        criteria.add(Restrictions.eq("id", id));
        Preference preference = (Preference) criteria.uniqueResult();
        session.close();
        return preference;
    }

    public Preference createPreference(Preference preference) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(preference);
        session.getTransaction().commit();
        session.close();
        return preference;
    }

    public Preference updatePreference(Preference preference) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(preference);
        session.getTransaction().commit();
        session.close();
        return preference;
    }

    public void deletePreferenceById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Preference preference = session.get(Preference.class, id);
        if (preference != null) {
            session.delete(preference);
        }
        session.getTransaction().commit();
        session.close();
    }

    public void deletePreferencesByUserId(Long userId) {
        Session session = factory.openSession();
        session.beginTransaction();
        List<Preference> preferences = getPreferencesByUserId(userId);
        for (Preference preference : preferences) {
            session.delete(preference);
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Preference> getPreferencesByUserId(Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        criteria.add(Restrictions.eq("userId", userId));
        List<Preference> preferences = criteria.list();
        session.close();
        return preferences;
    }

    public List<Preference> getPreferencesByDetails(String details) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        criteria.add(Restrictions.like("preferenceDetails", "%" + details + "%"));
        List<Preference> preferences = criteria.list();
        session.close();
        return preferences;
    }

    public List<Preference> getPreferencesByUserIdAndDetails(Long userId, String details) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.like("preferenceDetails", "%" + details + "%"));
        List<Preference> preferences = criteria.list();
        session.close();
        return preferences;
    }

    public List<Preference> getRecentPreferences() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        criteria.addOrder(org.hibernate.criterion.Order.desc("creationDate")); // Assume creationDate is a field in Preference
        List<Preference> preferences = criteria.list();
        session.close();
        return preferences;
    }

    public List<Preference> getPreferencesByDateRange(String startDate, String endDate) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        criteria.add(Restrictions.between("creationDate", startDate, endDate)); // Assume creationDate is a field in Preference
        List<Preference> preferences = criteria.list();
        session.close();
        return preferences;
    }

    // Additional methods for demonstration

    public List<Preference> getPreferencesByMultipleCriteria(Long userId, String details) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        if (userId != null) {
            criteria.add(Restrictions.eq("userId", userId));
        }
        if (details != null) {
            criteria.add(Restrictions.like("preferenceDetails", "%" + details + "%"));
        }
        List<Preference> preferences = criteria.list();
        session.close();
        return preferences;
    }

    public Preference getPreferenceByIdAndUserId(Long id, Long userId) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Preference.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.add(Restrictions.eq("userId", userId));
        Preference preference = (Preference) criteria.uniqueResult();
        session.close();
        return preference;
    }
}

