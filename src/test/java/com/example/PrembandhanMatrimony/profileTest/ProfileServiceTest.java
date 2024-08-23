package com.example.PrembandhanMatrimony.profileTest;

import com.prembandhan.premdao.ProfileDao;
import com.prembandhan.prementity.Profile;
import com.prembandhan.premservice.ProfileService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProfileServiceTest {

    @InjectMocks
    private ProfileService profileService;

    @Mock
    private ProfileDao profileDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProfiles() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileDao.getAllProfiles()).thenReturn(profiles);

        List<Profile> result = profileService.getAllProfiles();
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getAllProfiles();
    }

    @Test
    public void testGetProfileById() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileDao.getProfileById(1L)).thenReturn(profile);

        Profile result = profileService.getProfileById(1L);
        assertEquals(profile, result);
        verify(profileDao, times(1)).getProfileById(1L);
    }

    @Test
    public void testUpdateProfile() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Updated Bio");

        when(profileDao.updateProfile(profile)).thenReturn(profile);

        Profile result = profileService.updateProfile(profile);
        assertEquals(profile, result);
        verify(profileDao, times(1)).updateProfile(profile);
    }

    @Test
    public void testDeleteProfileById() {
        profileService.deleteProfileById(1L);
        verify(profileDao, times(1)).deleteProfileById(1L);
    }

    @Test
    public void testGetProfilesByUserId() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 1L, "Doctor", "Traveling", "Bio2")
        );

        when(profileDao.getProfilesByUserId(1L)).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByUserId(1L);
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByUserId(1L);
    }

    @Test
    public void testSearchProfiles() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileDao.searchProfiles("Bio")).thenReturn(profiles);

        List<Profile> result = profileService.searchProfiles("Bio");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).searchProfiles("Bio");
    }

    @Test
    public void testGetProfilesByOccupation() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByOccupation("Engineer")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByOccupation("Engineer");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByOccupation("Engineer");
    }

    @Test
    public void testGetProfilesByInterest() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByInterest("Reading")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByInterest("Reading");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByInterest("Reading");
    }

    @Test
    public void testCreateProfile() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileDao.createProfile(profile)).thenReturn(profile);

        Profile result = profileService.createProfile(profile);
        assertEquals(profile, result);
        verify(profileDao, times(1)).createProfile(profile);
    }

    @Test
    public void testCountProfiles() {
        when(profileDao.countProfiles()).thenReturn(10L);

        long count = profileService.countProfiles();
        assertEquals(10L, count);
        verify(profileDao, times(1)).countProfiles();
    }

    @Test
    public void testGetProfilesWithPagination() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileDao.getProfilesWithPagination(0, 2)).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesWithPagination(0, 2);
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesWithPagination(0, 2);
    }

    @Test
    public void testGetProfilesSortedBy() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileDao.getProfilesSortedBy("occupation")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesSortedBy("occupation");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesSortedBy("occupation");
    }

    @Test
    public void testGetProfileByUserIdAndOccupation() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileDao.getProfileByUserIdAndOccupation(1L, "Engineer")).thenReturn(profile);

        Profile result = profileService.getProfileByUserIdAndOccupation(1L, "Engineer");
        assertEquals(profile, result);
        verify(profileDao, times(1)).getProfileByUserIdAndOccupation(1L, "Engineer");
    }

    @Test
    public void testGetProfilesByBioContaining() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileDao.getProfilesByBioContaining("Bio")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByBioContaining("Bio");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByBioContaining("Bio");
    }

    @Test
    public void testDeleteAllProfiles() {
        profileService.deleteAllProfiles();
        verify(profileDao, times(1)).deleteAllProfiles();
    }

    @Test
    public void testGetProfileByOccupationAndInterest() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileDao.getProfileByOccupationAndInterest("Engineer", "Reading")).thenReturn(profile);

        Profile result = profileService.getProfileByOccupationAndInterest("Engineer", "Reading");
        assertEquals(profile, result);
        verify(profileDao, times(1)).getProfileByOccupationAndInterest("Engineer", "Reading");
    }

    @Test
    public void testGetProfilesByBioStartsWith() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByBioStartsWith("Bio")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByBioStartsWith("Bio");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByBioStartsWith("Bio");
    }

    @Test
    public void testGetProfilesByOccupationStartsWith() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByOccupationStartsWith("Eng")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByOccupationStartsWith("Eng");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByOccupationStartsWith("Eng");
    }

    @Test
    public void testGetProfilesByInterestStartsWith() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByInterestStartsWith("Rea")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByInterestStartsWith("Rea");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByInterestStartsWith("Rea");
    }

    @Test
    public void testGetProfileByUserIdAndBio() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileDao.getProfileByUserIdAndBio(1L, "Bio1")).thenReturn(profile);

        Profile result = profileService.getProfileByUserIdAndBio(1L, "Bio1");
        assertEquals(profile, result);
        verify(profileDao, times(1)).getProfileByUserIdAndBio(1L, "Bio1");
    }

    @Test
    public void testGetProfilesByMultipleCriteria() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByMultipleCriteria("Engineer", "Reading", "Bio1")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByMultipleCriteria("Engineer", "Reading", "Bio1");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByMultipleCriteria("Engineer", "Reading", "Bio1");
    }

    @Test
    public void testGetRecentProfiles() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getRecentProfiles()).thenReturn(profiles);

        List<Profile> result = profileService.getRecentProfiles();
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getRecentProfiles();
    }

    @Test
    public void testGetProfilesByAgeRange() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByAgeRange(25, 35)).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByAgeRange(25, 35);
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByAgeRange(25, 35);
    }

    @Test
    public void testGetProfilesByJoiningDate() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByJoiningDate("2023-01-01", "2024-01-01")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByJoiningDate("2023-01-01", "2024-01-01");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByJoiningDate("2023-01-01", "2024-01-01");
    }

    @Test
    public void testGetProfileByUserIdAndInterest() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileDao.getProfileByUserIdAndInterest(1L, "Reading")).thenReturn(profile);

        Profile result = profileService.getProfileByUserIdAndInterest(1L, "Reading");
        assertEquals(profile, result);
        verify(profileDao, times(1)).getProfileByUserIdAndInterest(1L, "Reading");
    }

    @Test
    public void testGetProfilesByOccupationAndBio() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByOccupationAndBio("Engineer", "Bio1")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByOccupationAndBio("Engineer", "Bio1");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByOccupationAndBio("Engineer", "Bio1");
    }

    @Test
    public void testGetProfilesByInterestAndBio() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileDao.getProfilesByInterestAndBio("Reading", "Bio1")).thenReturn(profiles);

        List<Profile> result = profileService.getProfilesByInterestAndBio("Reading", "Bio1");
        assertEquals(profiles, result);
        verify(profileDao, times(1)).getProfilesByInterestAndBio("Reading", "Bio1");
    }

    @Test
    public void testGetProfileByIdAndUserId() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileDao.getProfileByIdAndUserId(1L, 1L)).thenReturn(profile);

        Profile result = profileService.getProfileByIdAndUserId(1L, 1L);
        assertEquals(profile, result);
        verify(profileDao, times(1)).getProfileByIdAndUserId(1L, 1L);
    }
}
