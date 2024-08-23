
package com.example.PrembandhanMatrimony.preferencetest;

import com.prembandhan.premdao.PreferenceDao;
import com.prembandhan.prementity.Preference;
import com.prembandhan.premservice.PreferenceService;

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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PreferenceServiceTest {

    @InjectMocks
    private PreferenceService preferenceService;

    @Mock
    private PreferenceDao preferenceDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPreferences() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));
        preferences.add(new Preference(2L, 2L, "Details 2"));

        when(preferenceDao.getAllPreferences()).thenReturn(preferences);

        List<Preference> result = preferenceService.getAllPreferences();
        assertEquals(2, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferenceById() {
        Preference preference = new Preference(1L, 1L, "Details 1");

        when(preferenceDao.getPreferenceById(anyLong())).thenReturn(preference);

        Preference result = preferenceService.getPreferenceById(1L);
        assertEquals("Details 1", result.getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByUserId() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));

        when(preferenceDao.getPreferencesByUserId(anyLong())).thenReturn(preferences);

        List<Preference> result = preferenceService.getPreferencesByUserId(1L);
        assertEquals(1, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testCreatePreference() {
        Preference preference = new Preference(1L, 1L, "Details 1");

        when(preferenceDao.createPreference(any(Preference.class))).thenReturn(preference);

        Preference result = preferenceService.createPreference(preference);
        assertEquals("Details 1", result.getPreferenceDetails());
    }

    @Test
    public void testUpdatePreference() {
        Preference preference = new Preference(1L, 1L, "Updated Details");

        when(preferenceDao.updatePreference(any(Preference.class))).thenReturn(preference);

        Preference result = preferenceService.updatePreference(preference);
        assertEquals("Updated Details", result.getPreferenceDetails());
    }

    @Test
    public void testDeletePreferenceById() {
        doNothing().when(preferenceDao).deletePreferenceById(anyLong());

        preferenceService.deletePreferenceById(1L);
        verify(preferenceDao, times(1)).deletePreferenceById(1L);
    }

    @Test
    public void testDeletePreferencesByUserId() {
        doNothing().when(preferenceDao).deletePreferencesByUserId(anyLong());

        preferenceService.deletePreferencesByUserId(1L);
        verify(preferenceDao, times(1)).deletePreferencesByUserId(1L);
    }

    @Test
    public void testGetPreferencesByDetails() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));

        when(preferenceDao.getPreferencesByDetails(anyString())).thenReturn(preferences);

        List<Preference> result = preferenceService.getPreferencesByDetails("Details 1");
        assertEquals(1, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByUserIdAndDetails() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details 1"));

        when(preferenceDao.getPreferencesByUserIdAndDetails(anyLong(), anyString())).thenReturn(preferences);

        List<Preference> result = preferenceService.getPreferencesByUserIdAndDetails(1L, "Details 1");
        assertEquals(1, result.size());
        assertEquals("Details 1", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetRecentPreferences() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Recent Details"));

        when(preferenceDao.getRecentPreferences()).thenReturn(preferences);

        List<Preference> result = preferenceService.getRecentPreferences();
        assertEquals(1, result.size());
        assertEquals("Recent Details", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByDateRange() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details in Date Range"));

        when(preferenceDao.getPreferencesByDateRange(anyString(), anyString())).thenReturn(preferences);

        List<Preference> result = preferenceService.getPreferencesByDateRange("2024-01-01", "2024-12-31");
        assertEquals(1, result.size());
        assertEquals("Details in Date Range", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferencesByMultipleCriteria() {
        List<Preference> preferences = new ArrayList<>();
        preferences.add(new Preference(1L, 1L, "Details with Multiple Criteria"));

        when(preferenceDao.getPreferencesByMultipleCriteria(anyLong(), anyString())).thenReturn(preferences);

        List<Preference> result = preferenceService.getPreferencesByMultipleCriteria(1L, "Details with Multiple Criteria");
        assertEquals(1, result.size());
        assertEquals("Details with Multiple Criteria", result.get(0).getPreferenceDetails());
    }

    @Test
    public void testGetPreferenceByIdAndUserId() {
        Preference preference = new Preference(1L, 1L, "Details by ID and User ID");

        when(preferenceDao.getPreferenceByIdAndUserId(anyLong(), anyLong())).thenReturn(preference);

        Preference result = preferenceService.getPreferenceByIdAndUserId(1L, 1L);
        assertEquals("Details by ID and User ID", result.getPreferenceDetails());
    }
}


