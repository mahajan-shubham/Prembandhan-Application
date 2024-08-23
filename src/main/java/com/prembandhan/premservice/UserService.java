package com.prembandhan.premservice;

import com.prembandhan.prementity.User;
import com.prembandhan.premdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    
    public User registerUser(User user) {
        return userDao.createUser(user);
    }

    public User loginUser(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userDao. getAllUsers();
    }

    // Get User by ID
    public User getUserById(Long id) {
        return userDao.getUserById( id) ;
    }

    // Update User
    public User updateUser(User user) {
        return userDao.updateUser( user);
    }

    // Delete User by ID
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

    // Additional methods...

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public List<User> getUsersByCity(String city) {
        return userDao.getUsersByCity(city);
    }

    public List<User> getUsersByGender(String gender) {
        return userDao.getUsersByGender(gender);
    }

    public List<User> searchUsers(String keyword) {
        return userDao.searchUsers(keyword);
    }

    public boolean existsByEmail(String email) {
        return userDao.existsByEmail(email);
    }

    public long countUsers() {
        return userDao.countUsers();
    }

    public List<User> getUsersWithPagination(int page, int size) {
        return userDao.getUsersWithPagination(page, size);
    }

    public List<User> getUsersSortedBy(String sortBy) {
        return userDao.getUsersSortedBy(sortBy);
    }

    public List<User> getRecentUsers() {
        return userDao.getRecentUsers();
    }

    public List<User> getAdminUsers() {
        return userDao. getAdminUsers();
    }

    public List<User> getUsersByLastName(String lastName) {
        return userDao. getUsersByLastName(lastName);
    }

    public List<User> getActiveUsers() {
        return userDao.getActiveUsers();
    }

    public List<User> getInactiveUsers() {
        return userDao.getInactiveUsers();
    }

    public List<User> getUsersByAgeRange(int minAge, int maxAge) {
        return userDao.getUsersByAgeRange(minAge, maxAge);
    }

    public List<User> getUsersByJoiningDate(String startDate, String endDate) {
        return userDao.getUsersByJoiningDate(startDate, endDate);
    }

//    public User changeUserPassword(Long id, String newPassword) {
//        User user = userDao.changeUserPassword(id,newPassword);
//        if (user != null) {
//            user.setPassword(newPassword);
//            return userDao.changeUserPassword(user);
//        }
//        return null;
//    }
//
//    public User updateUserEmail(Long id, String newEmail) {
//        User user = userDao.findById(id).orElse(null);
//        if (user != null) {
//            user.setEmail(newEmail);
//            return userDao.save(user);
//        }
//        return null;
//    }
//
//    public User updateUserCity(Long id, String newCity) {
//        User user = userDao.findById(id).orElse(null);
//        if (user != null) {
//            user.setCity(newCity);
//            return userDao.save(user);
//        }
//        return null;
//    }

//    public User updateUserName(Long id, String newName) {
//        User user = userDao.findById(id).orElse(null);
//        if (user != null) {
//            user.setName(newName);
//            return userDao.save(user);
//        }
//        return null;
//    }
//
//    public User updateUserGender(Long id, String newGender) {
//        User user = userDao.findById(id).orElse(null);
//        if (user != null) {
//            user.setGender(newGender);
//            return userDao.save(user);
//        }
//        return null;
//    }
//
//    
}
