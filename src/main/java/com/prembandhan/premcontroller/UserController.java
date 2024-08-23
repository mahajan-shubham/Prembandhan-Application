package com.prembandhan.premcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prembandhan.prementity.User;
import com.prembandhan.premservice.UserService;

import antlr.collections.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @PostMapping("/register")
    public User registerUser(@ModelAttribute User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@ModelAttribute String username, @ModelAttribute  String password) {
        return userService.loginUser(username, password);
    }

    // Get All Users
    @GetMapping("/all")
    public List getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update User
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // Delete User by ID
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    // Additional methods...

    @GetMapping("/byEmail")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/byCity")
    public List<User> getUsersByCity(@RequestParam String city) {
        return userService.getUsersByCity(city);
    }

    @GetMapping("/byGender")
    public List<User> getUsersByGender(@RequestParam String gender) {
        return userService.getUsersByGender(gender);
    }

    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam String keyword) {
        return userService.searchUsers(keyword);
    }

    @GetMapping("/existsByEmail")
    public boolean existsByEmail(@RequestParam String email) {
        return userService.existsByEmail(email);
    }

    @GetMapping("/count")
    public long countUsers() {
        return userService.countUsers();
    }

    // Pagination and sorting
    @GetMapping("/page")
    public List<User> getUsersWithPagination(@RequestParam int page, @RequestParam int size) {
        return userService.getUsersWithPagination(page, size);
    }

    @GetMapping("/sorted")
    public List<User> getUsersSortedBy(@RequestParam String sortBy) {
        return userService.getUsersSortedBy(sortBy);
    }

    @GetMapping("/recent")
    public List<User> getRecentUsers() {
        return userService.getRecentUsers();
    }

    @GetMapping("/admins")
    public List<User> getAdminUsers() {
        return userService.getAdminUsers();
    }

    @GetMapping("/lastName/{lastName}")
    public List<User> getUsersByLastName(@PathVariable String lastName) {
        return userService.getUsersByLastName(lastName);
    }

    // Additional advanced queries...

    @GetMapping("/active")
    public List<User> getActiveUsers() {
        return userService.getActiveUsers();
    }

    @GetMapping("/inactive")
    public List<User> getInactiveUsers() {
        return userService.getInactiveUsers();
    }

    @GetMapping("/byAgeRange")
    public List<User> getUsersByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        return userService.getUsersByAgeRange(minAge, maxAge);
    }

    @GetMapping("/byJoiningDate")
    public List<User> getUsersByJoiningDate(@RequestParam String startDate, @RequestParam String endDate) {
        return userService.getUsersByJoiningDate(startDate, endDate);
    }

//    @PutMapping("/changePassword")
//    public User changeUserPassword(@RequestParam Long id, @RequestParam String newPassword) {
//        return userService.changeUserPassword(id, newPassword);
//    }
//
//    @PutMapping("/updateEmail")
//    public User updateUserEmail(@RequestParam Long id, @RequestParam String newEmail) {
//        return userService.updateUserEmail(id, newEmail);
//    }
//
//    @PutMapping("/updateCity")
//    public User updateUserCity(@RequestParam Long id, @RequestParam String newCity) {
//        return userService.updateUserCity(id, newCity);
//    }
//
//    @PutMapping("/updateName")
//    public User updateUserName(@RequestParam Long id, @RequestParam String newName) {
//        return userService.updateUserName(id, newName);
//    }
//
//    @PutMapping("/updateGender")
//    public User updateUserGender(@RequestParam Long id, @RequestParam String newGender) {
//        return userService.updateUserGender(id, newGender);
//    }
//
//    

}
