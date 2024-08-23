package com.prembandhan.premcontroller;

import com.prembandhan.premservice.PreferenceService;
import com.prembandhan.prementity.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preferences")
public class PreferenceController {

    @Autowired
    private PreferenceService preferenceService;

    @GetMapping("/all")
    public List<Preference> getAllPreferences() {
        return preferenceService.getAllPreferences();
    }

    @GetMapping("/{id}")
    public Preference getPreferenceById(@PathVariable Long id) {
        return preferenceService.getPreferenceById(id);
    }

    @GetMapping("/byUserId/{userId}")
    public List<Preference> getPreferencesByUserId(@PathVariable Long userId) {
        return preferenceService.getPreferencesByUserId(userId);
    }

    @PostMapping("/create")
    public Preference createPreference(@RequestBody Preference preference) {
        return preferenceService.createPreference(preference);
    }

    @PutMapping("/update")
    public Preference updatePreference(@RequestBody Preference preference) {
        return preferenceService.updatePreference(preference);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePreferenceById(@PathVariable Long id) {
        preferenceService.deletePreferenceById(id);
    }

    @DeleteMapping("/deleteByUserId/{userId}")
    public void deletePreferencesByUserId(@PathVariable Long userId) {
        preferenceService.deletePreferencesByUserId(userId);
    }

    @GetMapping("/byDetails")
    public List<Preference> getPreferencesByDetails(@RequestParam String details) {
        return preferenceService.getPreferencesByDetails(details);
    }

    @GetMapping("/byUserIdAndDetails")
    public List<Preference> getPreferencesByUserIdAndDetails(@RequestParam Long userId, @RequestParam String details) {
        return preferenceService.getPreferencesByUserIdAndDetails(userId, details);
    }

    @GetMapping("/recent")
    public List<Preference> getRecentPreferences() {
        return preferenceService.getRecentPreferences();
    }

    @GetMapping("/byDateRange")
    public List<Preference> getPreferencesByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return preferenceService.getPreferencesByDateRange(startDate, endDate);
    }

    @GetMapping("/byMultipleCriteria")
    public List<Preference> getPreferencesByMultipleCriteria(@RequestParam(required = false) Long userId, @RequestParam(required = false) String details) {
        return preferenceService.getPreferencesByMultipleCriteria(userId, details);
    }

    @GetMapping("/byIdAndUserId")
    public Preference getPreferenceByIdAndUserId(@RequestParam Long id, @RequestParam Long userId) {
        return preferenceService.getPreferenceByIdAndUserId(id, userId);
    }
}

