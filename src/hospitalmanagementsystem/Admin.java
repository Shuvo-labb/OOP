/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

import javax.swing.*;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, "Admin");
    }

    public void showDashboard() {
        new AdminDashboard().setVisible(true);
    }
}
