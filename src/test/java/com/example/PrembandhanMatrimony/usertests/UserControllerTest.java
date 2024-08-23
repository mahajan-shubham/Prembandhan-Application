package com.example.PrembandhanMatrimony.usertests;

import com.prembandhan.premservice.UserService;
import com.prembandhan.premcontroller.UserController;
import com.prembandhan.prementity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

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
    void registerUser() {
        User user = new User();
        when(userService.registerUser(user)).thenReturn(user);

        User result = userController.registerUser(user);

        assertEquals(user, result);
        verify(userService, times(1)).registerUser(user);
    }

    @Test
    void loginUser_Success() {
        User user = new User();
        when(userService.loginUser("username", "password")).thenReturn(user);

        User result = userController.loginUser("username", "password");

        assertEquals(user, result);
        verify(userService, times(1)).loginUser("username", "password");
    }

    @Test
    void loginUser_Failure() {
        when(userService.loginUser("username", "wrongpassword")).thenReturn(null);

        User result = userController.loginUser("username", "wrongpassword");

        assertNull(result);
        verify(userService, times(1)).loginUser("username", "wrongpassword");
    }
    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getAllUsers()).thenReturn(users);

        List<User> result = userController.getAllUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUserById() {
        when(userService.getUserById(anyLong())).thenReturn(user);

        User result = userController.getUserById(1L);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testUpdateUser() {
        when(userService.updateUser(any(User.class))).thenReturn(user);

        User result = userController.updateUser(user);
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testDeleteUserById() {
        userController.deleteUserById(1L);
    }

    @Test
    public void testGetUserByEmail() {
        when(userService.getUserByEmail(anyString())).thenReturn(user);

        User result = userController.getUserByEmail("john.doe@example.com");
        assertEquals("John Doe", result.getName());
    }

    @Test
    public void testGetUsersByCity() {
        List<User> users = Arrays.asList(user);
        when(userService.getUsersByCity(anyString())).thenReturn(users);

        List<User> result = userController.getUsersByCity("New York");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByGender() {
        List<User> users = Arrays.asList(user);
        when(userService.getUsersByGender(anyString())).thenReturn(users);

        List<User> result = userController.getUsersByGender("Male");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testSearchUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.searchUsers(anyString())).thenReturn(users);

        List<User> result = userController.searchUsers("John");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testExistsByEmail() {
        when(userService.existsByEmail(anyString())).thenReturn(true);

        boolean result = userController.existsByEmail("john.doe@example.com");
        assertEquals(true, result);
    }

    @Test
    public void testCountUsers() {
        when(userService.countUsers()).thenReturn(1L);

        long result = userController.countUsers();
        assertEquals(1L, result);
    }

    @Test
    public void testGetUsersWithPagination() {
        List<User> users = Arrays.asList(user);
        when(userService.getUsersWithPagination(0, 1)).thenReturn(users);

        List<User> result = userController.getUsersWithPagination(0, 1);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersSortedBy() {
        List<User> users = Arrays.asList(user);
        when(userService.getUsersSortedBy(anyString())).thenReturn(users);

        List<User> result = userController.getUsersSortedBy("name");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetRecentUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getRecentUsers()).thenReturn(users);

        List<User> result = userController.getRecentUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetAdminUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getAdminUsers()).thenReturn(users);

        List<User> result = userController.getAdminUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByLastName() {
        List<User> users = Arrays.asList(user);
        when(userService.getUsersByLastName(anyString())).thenReturn(users);

        List<User> result = userController.getUsersByLastName("Doe");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetActiveUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getActiveUsers()).thenReturn(users);

        List<User> result = userController.getActiveUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetInactiveUsers() {
        List<User> users = Arrays.asList(user);
        when(userService.getInactiveUsers()).thenReturn(users);

        List<User> result = userController.getInactiveUsers();
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByAgeRange() {
        List<User> users = Arrays.asList(user);
        when(userService.getUsersByAgeRange(20, 30)).thenReturn(users);

        List<User> result = userController.getUsersByAgeRange(20, 30);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testGetUsersByJoiningDate() {
        List<User> users = Arrays.asList(user);
        when(userService.getUsersByJoiningDate(anyString(), anyString())).thenReturn(users);

        List<User> result = userController.getUsersByJoiningDate("2020-01-01", "2020-12-31");
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }
}
