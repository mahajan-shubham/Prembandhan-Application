package com.prembandhan.premservice;

import com.prembandhan.premdao.PreferenceDao;
import com.prembandhan.prementity.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {

    @Autowired
    private PreferenceDao preferenceDao;

    public List<Preference> getAllPreferences() {
        return preferenceDao.getAllPreferences();
    }

    public Preference getPreferenceById(Long id) {
        return preferenceDao.getPreferenceById(id);
    }

    public List<Preference> getPreferencesByUserId(Long userId) {
        return preferenceDao.getPreferencesByUserId(userId);
    }

    public Preference createPreference(Preference preference) {
        return preferenceDao.createPreference(preference);
    }

    public Preference updatePreference(Preference preference) {
        return preferenceDao.updatePreference(preference);
    }

    public void deletePreferenceById(Long id) {
        preferenceDao.deletePreferenceById(id);
    }

    public void deletePreferencesByUserId(Long userId) {
        preferenceDao.deletePreferencesByUserId(userId);
    }

    public List<Preference> getPreferencesByDetails(String details) {
        return preferenceDao.getPreferencesByDetails(details);
    }

    public List<Preference> getPreferencesByUserIdAndDetails(Long userId, String details) {
        return preferenceDao.getPreferencesByUserIdAndDetails(userId, details);
    }

    public List<Preference> getRecentPreferences() {
        return preferenceDao.getRecentPreferences();
    }

    public List<Preference> getPreferencesByDateRange(String startDate, String endDate) {
        return preferenceDao.getPreferencesByDateRange(startDate, endDate);
    }

    // Additional methods for demonstration

    public List<Preference> getPreferencesByMultipleCriteria(Long userId, String details) {
        return preferenceDao.getPreferencesByMultipleCriteria(userId, details);
    }

    public Preference getPreferenceByIdAndUserId(Long id, Long userId) {
        return preferenceDao.getPreferenceByIdAndUserId(id, userId);
    }
}

