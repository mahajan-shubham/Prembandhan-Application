package com.prembandhan.premcontroller;

import com.prembandhan.premservice.ProfileService;
import com.prembandhan.prementity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/all")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public Profile getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id);
    }

    @PutMapping("/update")
    public Profile updateProfile(@RequestBody Profile profile) {
        return profileService.updateProfile(profile);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable Long id) {
        profileService.deleteProfileById(id);
    }

    @GetMapping("/byUserId/{userId}")
    public List<Profile> getProfilesByUserId(@PathVariable Long userId) {
        return profileService.getProfilesByUserId(userId);
    }

    @GetMapping("/search")
    public List<Profile> searchProfiles(@RequestParam String keyword) {
        return profileService.searchProfiles(keyword);
    }

    @GetMapping("/byOccupation")
    public List<Profile> getProfilesByOccupation(@RequestParam String occupation) {
        return profileService.getProfilesByOccupation(occupation);
    }

    @GetMapping("/byInterest")
    public List<Profile> getProfilesByInterest(@RequestParam String interest) {
        return profileService.getProfilesByInterest(interest);
    }

    @PostMapping("/create")
    public Profile createProfile(@RequestBody Profile profile) {
        return profileService.createProfile(profile);
    }

    @GetMapping("/count")
    public long countProfiles() {
        return profileService.countProfiles();
    }

    @GetMapping("/page")
    public List<Profile> getProfilesWithPagination(@RequestParam int page, @RequestParam int size) {
        return profileService.getProfilesWithPagination(page, size);
    }

    @GetMapping("/sorted")
    public List<Profile> getProfilesSortedBy(@RequestParam String sortBy) {
        return profileService.getProfilesSortedBy(sortBy);
    }

    @GetMapping("/byUserIdAndOccupation")
    public Profile getProfileByUserIdAndOccupation(@RequestParam Long userId, @RequestParam String occupation) {
        return profileService.getProfileByUserIdAndOccupation(userId, occupation);
    }

    @GetMapping("/byBioContaining")
    public List<Profile> getProfilesByBioContaining(@RequestParam String keyword) {
        return profileService.getProfilesByBioContaining(keyword);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllProfiles() {
        profileService.deleteAllProfiles();
    }

    @GetMapping("/byOccupationAndInterest")
    public Profile getProfileByOccupationAndInterest(@RequestParam String occupation, @RequestParam String interest) {
        return profileService.getProfileByOccupationAndInterest(occupation, interest);
    }

    @GetMapping("/byBioStartsWith")
    public List<Profile> getProfilesByBioStartsWith(@RequestParam String prefix) {
        return profileService.getProfilesByBioStartsWith(prefix);
    }

    @GetMapping("/byOccupationStartsWith")
    public List<Profile> getProfilesByOccupationStartsWith(@RequestParam String prefix) {
        return profileService.getProfilesByOccupationStartsWith(prefix);
    }

    @GetMapping("/byInterestStartsWith")
    public List<Profile> getProfilesByInterestStartsWith(@RequestParam String prefix) {
        return profileService.getProfilesByInterestStartsWith(prefix);
    }

    @GetMapping("/byUserIdAndBio")
    public Profile getProfileByUserIdAndBio(@RequestParam Long userId, @RequestParam String bio) {
        return profileService.getProfileByUserIdAndBio(userId, bio);
    }

    @GetMapping("/byMultipleCriteria")
    public List<Profile> getProfilesByMultipleCriteria(@RequestParam(required = false) String occupation,
                                                       @RequestParam(required = false) String interest,
                                                       @RequestParam(required = false) String bio) {
        return profileService.getProfilesByMultipleCriteria(occupation, interest, bio);
    }

    @GetMapping("/recent")
    public List<Profile> getRecentProfiles() {
        return profileService.getRecentProfiles();
    }

    @GetMapping("/byAgeRange")
    public List<Profile> getProfilesByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        return profileService.getProfilesByAgeRange(minAge, maxAge);
    }

    @GetMapping("/byJoiningDate")
    public List<Profile> getProfilesByJoiningDate(@RequestParam String startDate, @RequestParam String endDate) {
        return profileService.getProfilesByJoiningDate(startDate, endDate);
    }

    @GetMapping("/byUserIdAndInterest")
    public Profile getProfileByUserIdAndInterest(@RequestParam Long userId, @RequestParam String interest) {
        return profileService.getProfileByUserIdAndInterest(userId, interest);
    }

    @GetMapping("/byOccupationAndBio")
    public List<Profile> getProfilesByOccupationAndBio(@RequestParam String occupation, @RequestParam String bio) {
        return profileService.getProfilesByOccupationAndBio(occupation, bio);
    }

    @GetMapping("/byInterestAndBio")
    public List<Profile> getProfilesByInterestAndBio(@RequestParam String interest, @RequestParam String bio) {
        return profileService.getProfilesByInterestAndBio(interest, bio);
    }

    @GetMapping("/byIdAndUserId")
    public Profile getProfileByIdAndUserId(@RequestParam Long id, @RequestParam Long userId) {
        return profileService.getProfileByIdAndUserId(id, userId);
    }

}
