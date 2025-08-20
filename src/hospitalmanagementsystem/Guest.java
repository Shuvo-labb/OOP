/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

import javax.swing.*;

public class Guest extends User {
    public Guest(String username, String password) {
        super(username, password, "Guest");
    }

    public void showDashboard() {
        new GuestDashboard().setVisible(true);
    }
}
