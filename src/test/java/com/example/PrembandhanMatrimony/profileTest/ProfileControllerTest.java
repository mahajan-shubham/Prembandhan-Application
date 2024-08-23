package com.example.PrembandhanMatrimony.profileTest;

import com.prembandhan.premservice.ProfileService;
import com.prembandhan.premcontroller.ProfileController;
import com.prembandhan.prementity.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProfileControllerTest {

    @InjectMocks
    private ProfileController profileController;

    @Mock
    private ProfileService profileService;

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

        when(profileService.getAllProfiles()).thenReturn(profiles);

        List<Profile> result = profileController.getAllProfiles();
        assertEquals(profiles, result);
        verify(profileService, times(1)).getAllProfiles();
    }

    @Test
    public void testGetProfileById() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileService.getProfileById(1L)).thenReturn(profile);

        Profile result = profileController.getProfileById(1L);
        assertEquals(profile, result);
        verify(profileService, times(1)).getProfileById(1L);
    }

    @Test
    public void testUpdateProfile() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Updated Bio");

        when(profileService.updateProfile(profile)).thenReturn(profile);

        Profile result = profileController.updateProfile(profile);
        assertEquals(profile, result);
        verify(profileService, times(1)).updateProfile(profile);
    }

    @Test
    public void testDeleteProfileById() {
        profileController.deleteProfileById(1L);
        verify(profileService, times(1)).deleteProfileById(1L);
    }

    @Test
    public void testGetProfilesByUserId() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 1L, "Doctor", "Traveling", "Bio2")
        );

        when(profileService.getProfilesByUserId(1L)).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByUserId(1L);
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByUserId(1L);
    }

    @Test
    public void testSearchProfiles() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileService.searchProfiles("Bio")).thenReturn(profiles);

        List<Profile> result = profileController.searchProfiles("Bio");
        assertEquals(profiles, result);
        verify(profileService, times(1)).searchProfiles("Bio");
    }

    @Test
    public void testGetProfilesByOccupation() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByOccupation("Engineer")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByOccupation("Engineer");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByOccupation("Engineer");
    }

    @Test
    public void testGetProfilesByInterest() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByInterest("Reading")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByInterest("Reading");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByInterest("Reading");
    }

    @Test
    public void testCreateProfile() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileService.createProfile(profile)).thenReturn(profile);

        Profile result = profileController.createProfile(profile);
        assertEquals(profile, result);
        verify(profileService, times(1)).createProfile(profile);
    }

    @Test
    public void testCountProfiles() {
        when(profileService.countProfiles()).thenReturn(10L);

        long count = profileController.countProfiles();
        assertEquals(10L, count);
        verify(profileService, times(1)).countProfiles();
    }

    @Test
    public void testGetProfilesWithPagination() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileService.getProfilesWithPagination(0, 2)).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesWithPagination(0, 2);
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesWithPagination(0, 2);
    }

    @Test
    public void testGetProfilesSortedBy() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileService.getProfilesSortedBy("occupation")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesSortedBy("occupation");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesSortedBy("occupation");
    }

    @Test
    public void testGetProfileByUserIdAndOccupation() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileService.getProfileByUserIdAndOccupation(1L, "Engineer")).thenReturn(profile);

        Profile result = profileController.getProfileByUserIdAndOccupation(1L, "Engineer");
        assertEquals(profile, result);
        verify(profileService, times(1)).getProfileByUserIdAndOccupation(1L, "Engineer");
    }

    @Test
    public void testGetProfilesByBioContaining() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1"),
                new Profile(2L, 2L, "Doctor", "Traveling", "Bio2")
        );

        when(profileService.getProfilesByBioContaining("Bio")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByBioContaining("Bio");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByBioContaining("Bio");
    }

    @Test
    public void testDeleteAllProfiles() {
        profileController.deleteAllProfiles();
        verify(profileService, times(1)).deleteAllProfiles();
    }

    @Test
    public void testGetProfileByOccupationAndInterest() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileService.getProfileByOccupationAndInterest("Engineer", "Reading")).thenReturn(profile);

        Profile result = profileController.getProfileByOccupationAndInterest("Engineer", "Reading");
        assertEquals(profile, result);
        verify(profileService, times(1)).getProfileByOccupationAndInterest("Engineer", "Reading");
    }

    @Test
    public void testGetProfilesByBioStartsWith() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByBioStartsWith("Bio")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByBioStartsWith("Bio");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByBioStartsWith("Bio");
    }

    @Test
    public void testGetProfilesByOccupationStartsWith() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByOccupationStartsWith("Eng")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByOccupationStartsWith("Eng");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByOccupationStartsWith("Eng");
    }

    @Test
    public void testGetProfilesByInterestStartsWith() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByInterestStartsWith("Rea")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByInterestStartsWith("Rea");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByInterestStartsWith("Rea");
    }

    @Test
    public void testGetProfileByUserIdAndBio() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileService.getProfileByUserIdAndBio(1L, "Bio1")).thenReturn(profile);

        Profile result = profileController.getProfileByUserIdAndBio(1L, "Bio1");
        assertEquals(profile, result);
        verify(profileService, times(1)).getProfileByUserIdAndBio(1L, "Bio1");
    }

    @Test
    public void testGetProfilesByMultipleCriteria() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByMultipleCriteria("Engineer", "Reading", "Bio1")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByMultipleCriteria("Engineer", "Reading", "Bio1");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByMultipleCriteria("Engineer", "Reading", "Bio1");
    }

    @Test
    public void testGetRecentProfiles() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getRecentProfiles()).thenReturn(profiles);

        List<Profile> result = profileController.getRecentProfiles();
        assertEquals(profiles, result);
        verify(profileService, times(1)).getRecentProfiles();
    }

    @Test
    public void testGetProfilesByAgeRange() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByAgeRange(25, 35)).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByAgeRange(25, 35);
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByAgeRange(25, 35);
    }

    @Test
    public void testGetProfilesByJoiningDate() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByJoiningDate("2023-01-01", "2024-01-01")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByJoiningDate("2023-01-01", "2024-01-01");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByJoiningDate("2023-01-01", "2024-01-01");
    }

    @Test
    public void testGetProfileByUserIdAndInterest() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileService.getProfileByUserIdAndInterest(1L, "Reading")).thenReturn(profile);

        Profile result = profileController.getProfileByUserIdAndInterest(1L, "Reading");
        assertEquals(profile, result);
        verify(profileService, times(1)).getProfileByUserIdAndInterest(1L, "Reading");
    }

    @Test
    public void testGetProfilesByOccupationAndBio() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByOccupationAndBio("Engineer", "Bio1")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByOccupationAndBio("Engineer", "Bio1");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByOccupationAndBio("Engineer", "Bio1");
    }

    @Test
    public void testGetProfilesByInterestAndBio() {
        List<Profile> profiles = Arrays.asList(
                new Profile(1L, 1L, "Engineer", "Reading", "Bio1")
        );

        when(profileService.getProfilesByInterestAndBio("Reading", "Bio1")).thenReturn(profiles);

        List<Profile> result = profileController.getProfilesByInterestAndBio("Reading", "Bio1");
        assertEquals(profiles, result);
        verify(profileService, times(1)).getProfilesByInterestAndBio("Reading", "Bio1");
    }

    @Test
    public void testGetProfileByIdAndUserId() {
        Profile profile = new Profile(1L, 1L, "Engineer", "Reading", "Bio1");

        when(profileService.getProfileByIdAndUserId(1L, 1L)).thenReturn(profile);

        Profile result = profileController.getProfileByIdAndUserId(1L, 1L);
        assertEquals(profile, result);
        verify(profileService, times(1)).getProfileByIdAndUserId(1L, 1L);
    }
}

