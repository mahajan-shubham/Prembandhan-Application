package com.prembandhan.premservice;

import com.prembandhan.premdao.ProfileDao;
import com.prembandhan.prementity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileDao profileDao;

    public List<Profile> getAllProfiles() {
        return profileDao.getAllProfiles();
    }

    public Profile getProfileById(Long id) {
        return profileDao.getProfileById(id);
    }

    public Profile updateProfile(Profile profile) {
        return profileDao.updateProfile(profile);
    }

    public void deleteProfileById(Long id) {
        profileDao.deleteProfileById(id);
    }

    public List<Profile> getProfilesByUserId(Long userId) {
        return profileDao.getProfilesByUserId(userId);
    }

    public List<Profile> searchProfiles(String keyword) {
        return profileDao.searchProfiles(keyword);
    }

    public List<Profile> getProfilesByOccupation(String occupation) {
        return profileDao.getProfilesByOccupation(occupation);
    }

    public List<Profile> getProfilesByInterest(String interest) {
        return profileDao.getProfilesByInterest(interest);
    }

    public Profile createProfile(Profile profile) {
        return profileDao.createProfile(profile);
    }

    public long countProfiles() {
        return profileDao.countProfiles();
    }

    public List<Profile> getProfilesWithPagination(int page, int size) {
        return profileDao.getProfilesWithPagination(page, size);
    }

    public List<Profile> getProfilesSortedBy(String sortBy) {
        return profileDao.getProfilesSortedBy(sortBy);
    }

    public Profile getProfileByUserIdAndOccupation(Long userId, String occupation) {
        return profileDao.getProfileByUserIdAndOccupation(userId, occupation);
    }

    public List<Profile> getProfilesByBioContaining(String keyword) {
        return profileDao.getProfilesByBioContaining(keyword);
    }

    public void deleteAllProfiles() {
        profileDao.deleteAllProfiles();
    }

    public Profile getProfileByOccupationAndInterest(String occupation, String interest) {
        return profileDao.getProfileByOccupationAndInterest(occupation, interest);
    }

    public List<Profile> getProfilesByBioStartsWith(String prefix) {
        return profileDao.getProfilesByBioStartsWith(prefix);
    }

    public List<Profile> getProfilesByOccupationStartsWith(String prefix) {
        return profileDao.getProfilesByOccupationStartsWith(prefix);
    }

    public List<Profile> getProfilesByInterestStartsWith(String prefix) {
        return profileDao.getProfilesByInterestStartsWith(prefix);
    }

    public Profile getProfileByUserIdAndBio(Long userId, String bio) {
        return profileDao.getProfileByUserIdAndBio(userId, bio);
    }

    public List<Profile> getProfilesByMultipleCriteria(String occupation, String interest, String bio) {
        return profileDao.getProfilesByMultipleCriteria(occupation, interest, bio);
    }

    public List<Profile> getRecentProfiles() {
        // Implement this method if needed
        return profileDao.getRecentProfiles();
    }

    public List<Profile> getProfilesByAgeRange(int minAge, int maxAge) {
        // Implement this method if needed
        return profileDao.getProfilesByAgeRange(minAge, maxAge);
    }

    public List<Profile> getProfilesByJoiningDate(String startDate, String endDate) {
        // Implement this method if needed
        return profileDao.getProfilesByJoiningDate(startDate, endDate);
    }

    public Profile getProfileByUserIdAndInterest(Long userId, String interest) {
        return profileDao.getProfileByUserIdAndInterest(userId, interest);
    }

    public List<Profile> getProfilesByOccupationAndBio(String occupation, String bio) {
        return profileDao.getProfilesByOccupationAndBio(occupation, bio);
    }

    public List<Profile> getProfilesByInterestAndBio(String interest, String bio) {
        return profileDao.getProfilesByInterestAndBio(interest, bio);
    }

    public Profile getProfileByIdAndUserId(Long id, Long userId) {
        return profileDao.getProfileByIdAndUserId(id, userId);
    }
}

