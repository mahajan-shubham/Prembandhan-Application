package com.example.PrembandhanMatrimony.preferencetest;

import com.prembandhan.premservice.PreferenceService;
import com.prembandhan.premcontroller.PreferenceController;
import com.prembandhan.prementity.Preference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class PreferenceControllerTest {

    @InjectMocks
    private PreferenceController preferenceController;

    @Mock
    private PreferenceService preferenceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPreferences() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));
        preferences.add(new Preference(2L, 2L, "Details 2"));

        when(preferenceService.getAllPreferences()).thenReturn(preferences);

        List<Preference> result = preferenceController.getAllPreferences();
        assertEquals(2, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferenceById() {
        Preference preference = new Preference(1L, 1L, "Details 1");

        when(preferenceService.getPreferenceById(anyLong())).thenReturn(preference);

        Preference result = preferenceController.getPreferenceById(1L);
        assertEquals("Details 1", result.getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByUserId() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));

        when(preferenceService.getPreferencesByUserId(anyLong())).thenReturn(preferences);

        List<Preference> result = preferenceController.getPreferencesByUserId(1L);
        assertEquals(1, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testCreatePreference() {
        Preference preference = new Preference(1L, 1L, "Details 1");

        when(preferenceService.createPreference(any(Preference.class))).thenReturn(preference);

        Preference result = preferenceController.createPreference(preference);
        assertEquals("Details 1", result.getPreferenceDetails());
    }

    @Test
    public void testUpdatePreference() {
        Preference preference = new Preference(1L, 1L, "Updated Details");

        when(preferenceService.updatePreference(any(Preference.class))).thenReturn(preference);

        Preference result = preferenceController.updatePreference(preference);
        assertEquals("Updated Details", result.getPreferenceDetails());
    }

    @Test
    public void testDeletePreferenceById() {
        doNothing().when(preferenceService).deletePreferenceById(anyLong());

        preferenceController.deletePreferenceById(1L);
        verify(preferenceService, times(1)).deletePreferenceById(1L);
    }

    @Test
    public void testDeletePreferencesByUserId() {
        doNothing().when(preferenceService).deletePreferencesByUserId(anyLong());

        preferenceController.deletePreferencesByUserId(1L);
        verify(preferenceService, times(1)).deletePreferencesByUserId(1L);
    }

    @Test
    public void testGetPreferencesByDetails() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));

        when(preferenceService.getPreferencesByDetails(any(String.class))).thenReturn(preferences);

        List<Preference> result = preferenceController.getPreferencesByDetails("Details 1");
        assertEquals(1, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByUserIdAndDetails() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));

        when(preferenceService.getPreferencesByUserIdAndDetails(anyLong(), any(String.class))).thenReturn(preferences);

        List<Preference> result = preferenceController.getPreferencesByUserIdAndDetails(1L, "Details 1");
        assertEquals(1, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetRecentPreferences() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Recent Details"));

        when(preferenceService.getRecentPreferences()).thenReturn(preferences);

        List<Preference> result = preferenceController.getRecentPreferences();
        assertEquals(1, result.size());
        assertEquals("Recent Details", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByDateRange() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details in Date Range"));

        when(preferenceService.getPreferencesByDateRange(any(String.class), any(String.class))).thenReturn(preferences);

        List<Preference> result = preferenceController.getPreferencesByDateRange("2024-01-01", "2024-12-31");
        assertEquals(1, result.size());
        assertEquals("Details in Date Range", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByMultipleCriteria() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details with Multiple Criteria"));

        when(preferenceService.getPreferencesByMultipleCriteria(any(Long.class), any(String.class))).thenReturn(preferences);

        List<Preference> result = preferenceController.getPreferencesByMultipleCriteria(1L, "Details with Multiple Criteria");
        assertEquals(1, result.size());
        assertEquals("Details with Multiple Criteria", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferenceByIdAndUserId() {
        Preference preference = new Preference(1L, 1L, "Details by ID and User ID");

        when(preferenceService.getPreferenceByIdAndUserId(anyLong(), anyLong())).thenReturn(preference);

        Preference result = preferenceController.getPreferenceByIdAndUserId(1L, 1L);
        assertEquals("Details by ID and User ID", result.getPreferenceDetails());
    }
}
