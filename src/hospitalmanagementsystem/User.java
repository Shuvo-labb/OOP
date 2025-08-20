/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: User.java
package hospitalmanagementsystem;

public abstract class User {
    protected String username;
    protected String password;
    protected String role;

    // Constructor
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Authentication method
    public boolean authenticate(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    // Abstract method — every user must open their own dashboard
    public abstract void showDashboard();
}