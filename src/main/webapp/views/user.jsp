<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
</head>
<body>
    <h1>User Management</h1>

    <h2>Register User</h2>
    <form action="/users/register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Register</button>
    </form>

    <h2>Login User</h2>
    <form action="/users/login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Login</button>
    </form>

    <h2>All Users</h2>
    <form action="/users/all" method="get">
        <button type="submit">Get All Users</button>
    </form>
    
    <h2>Get User by ID</h2>
    <form action="/users" method="get">
        <label for="id">User ID:</label>
        <input type="text" id="id" name="id" required><br>
        <button type="submit">Get User</button>
    </form>

    <h2>Update User</h2>
    <form action="/users/update" method="put">
        <label for="updateId">User ID:</label>
        <input type="text" id="updateId" name="id" required><br>
        <label for="updateName">Name:</label>
        <input type="text" id="updateName" name="name"><br>
        <label for="updateEmail">Email:</label>
        <input type="email" id="updateEmail" name="email"><br>
        <label for="updatePassword">Password:</label>
        <input type="password" id="updatePassword" name="password"><br>
        <button type="submit">Update User</button>
    </form>

    <h2>Delete User by ID</h2>
    <form action="/users/delete" method="delete">
        <label for="deleteId">User ID:</label>
        <input type="text" id="deleteId" name="id" required><br>
        <button type="submit">Delete User</button>
    </form>

    <h2>Get User by Email</h2>
    <form action="/users/byEmail" method="get">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <button type="submit">Get User</button>
    </form>

    <h2>Get Users by City</h2>
    <form action="/users/byCity" method="get">
        <label for="city">City:</label>
        <input type="text" id="city" name="city" required><br>
        <button type="submit">Get Users</button>
    </form>

    <h2>Get Users by Gender</h2>
    <form action="/users/byGender" method="get">
        <label for="gender">Gender:</label>
        <input type="text" id="gender" name="gender" required><br>
        <button type="submit">Get Users</button>
    </form>

    <h2>Search Users</h2>
    <form action="/users/search" method="get">
        <label for="keyword">Keyword:</label>
        <input type="text" id="keyword" name="keyword" required><br>
        <button type="submit">Search Users</button>
    </form>

    <h2>Check if Email Exists</h2>
    <form action="/users/existsByEmail" method="get">
        <label for="checkEmail">Email:</label>
        <input type="email" id="checkEmail" name="email" required><br>
        <button type="submit">Check Email</button>
    </form>

    <h2>Count Users</h2>
    <form action="/users/count" method="get">
        <button type="submit">Count Users</button>
    </form>

    <h2>Get Users with Pagination</h2>
    <form action="/users/page" method="get">
        <label for="page">Page:</label>
        <input type="number" id="page" name="page" required><br>
        <label for="size">Size:</label>
        <input type="number" id="size" name="size" required><br>
        <button type="submit">Get Users</button>
    </form>

    <h2>Get Users Sorted</h2>
    <form action="/users/sorted" method="get">
        <label for="sortBy">Sort By:</label>
        <input type="text" id="sortBy" name="sortBy" required><br>
        <button type="submit">Get Users</button>
    </form>

    <h2>Get Recent Users</h2>
    <form action="/users/recent" method="get">
        <button type="submit">Get Recent Users</button>
    </form>

    <h2>Get Admin Users</h2>
    <form action="/users/admins" method="get">
        <button type="submit">Get Admin Users</button>
    </form>

    <h2>Get Users by Last Name</h2>
    <form action="/users/lastName" method="get">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>
        <button type="submit">Get Users</button>
    </form>

    <h2>Get Active Users</h2>
    <form action="/users/active" method="get">
        <button type="submit">Get Active Users</button>
    </form>

    <h2>Get Inactive Users</h2>
    <form action="/users/inactive" method="get">
        <button type="submit">Get Inactive Users</button>
    </form>

    <h2>Get Users by Age Range</h2>
    <form action="/users/byAgeRange" method="get">
        <label for="minAge">Min Age:</label>
        <input type="number" id="minAge" name="minAge" required><br>
        <label for="maxAge">Max Age:</label>
        <input type="number" id="maxAge" name="maxAge" required><br>
        <button type="submit">Get Users</button>
    </form>

    <h2>Get Users by Joining Date</h2>
    <form action="/users/byJoiningDate" method="get">
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required><br>
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required><br>
        <button type="submit">Get Users</button>
    </form>
</body>
</html>
