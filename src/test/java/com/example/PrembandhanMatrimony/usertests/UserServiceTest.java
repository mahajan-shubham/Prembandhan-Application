package com.example.PrembandhanMatrimony.usertests;

import com.prembandhan.premdao.UserDao;
import com.prembandhan.prementity.User;
import com.prembandhan.premservice.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserDao userDao;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password");
        user.setGender("Male");
        user.setCity("New York");
    }

   
    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(user);
        when(userDao.getAllUsers()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUserById() {
        when(userDao.getUserById(anyLong())).thenReturn(user);

        User result = userService.getUserById(1L);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testUpdateUser() {
        when(userDao.updateUser(any(User.class))).thenReturn(user);

        User result = userService.updateUser(user);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testDeleteUserById() {
        userService.deleteUserById(1L);
    }

    @Test
    public void testGetUserByEmail() {
        when(userDao.getUserByEmail(anyString())).thenReturn(user);

        User result = userService.getUserByEmail("john.doe@example.com");
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testGetUsersByCity() {
        List<User> users = Arrays.asList(user);
        when(userDao.getUsersByCity(anyString())).thenReturn(users);

        List<User> result = userService.getUsersByCity("New York");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByGender() {
        List<User> users = Arrays.asList(user);
        when(userDao.getUsersByGender(anyString())).thenReturn(users);

        List<User> result = userService.getUsersByGender("Male");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testSearchUsers() {
        List<User> users = Arrays.asList(user);
        when(userDao.searchUsers(anyString())).thenReturn(users);

        List<User> result = userService.searchUsers("John");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testExistsByEmail() {
        when(userDao.existsByEmail(anyString())).thenReturn(true);

        boolean result = userService.existsByEmail("john.doe@example.com");
        assertEquals(true, result);
    }

    @Test
    public void testCountUsers() {
        when(userDao.countUsers()).thenReturn(1L);

        long result = userService.countUsers();
        assertEquals(1L, result);
    }

    @Test
    public void testGetUsersWithPagination() {
        List<User> users = Arrays.asList(user);
        when(userDao.getUsersWithPagination(anyInt(), anyInt())).thenReturn(users);

        List<User> result = userService.getUsersWithPagination(0, 1);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersSortedBy() {
        List<User> users = Arrays.asList(user);
        when(userDao.getUsersSortedBy(anyString())).thenReturn(users);

        List<User> result = userService.getUsersSortedBy("name");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetRecentUsers() {
        List<User> users = Arrays.asList(user);
        when(userDao.getRecentUsers()).thenReturn(users);

        List<User> result = userService.getRecentUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetAdminUsers() {
        List<User> users = Arrays.asList(user);
        when(userDao.getAdminUsers()).thenReturn(users);

        List<User> result = userService.getAdminUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByLastName() {
        List<User> users = Arrays.asList(user);
        when(userDao.getUsersByLastName(anyString())).thenReturn(users);

        List<User> result = userService.getUsersByLastName("Doe");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetActiveUsers() {
        List<User> users = Arrays.asList(user);
        when(userDao.getActiveUsers()).thenReturn(users);

        List<User> result = userService.getActiveUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetInactiveUsers() {
        List<User> users = Arrays.asList(user);
        when(userDao.getInactiveUsers()).thenReturn(users);

        List<User> result = userService.getInactiveUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByAgeRange() {
        List<User> users = Arrays.asList(user);
        when(userDao.getUsersByAgeRange(anyInt(), anyInt())).thenReturn(users);

        List<User> result = userService.getUsersByAgeRange(20, 30);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByJoiningDate() {
        List<User> users = Arrays.asList(user);
        when(userDao.getUsersByJoiningDate(anyString(), anyString())).thenReturn(users);

        List<User> result = userService.getUsersByJoiningDate("2020-01-01", "2020-12-31");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }
}

