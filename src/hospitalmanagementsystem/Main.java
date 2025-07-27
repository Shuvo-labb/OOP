/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalmanagementsystem;

import javax.swing.SwingUtilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Main class to start the Hospital Management System.
 * Responsible for initial data loading.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    // Static lists to hold data accessible throughout the application
    public static List<Patient> patientList = new ArrayList<>();
    // You can add more lists here for doctors, appointments, etc.
    // public static List<Doctor> doctorList = new ArrayList<>();
    // public static List<Appointment> appointmentList = new ArrayList<>();

    /**
     * Loads patient data from patients.txt into the patientList.
     */
    private static void loadPatients() {
        patientList.clear(); // Clear list before loading
        try (Scanner scanner = new Scanner(new File("patients.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue; // Skip empty lines

                String[] parts = line.split(",");
                // Ensure the line has the correct number of parts
                // ID, Name, Age, Gender, MedicalHistory
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String gender = parts[3].trim();
                    String medicalHistory = parts[4].trim();

                    Patient patient = new Patient(id, name, age, gender, medicalHistory);
                    patientList.add(patient);
                } else {
                    LOGGER.log(Level.WARNING, "Skipping invalid patient line in patients.txt: {0}", line);
                }
            }
            LOGGER.info("Patients loaded successfully. Count: " + patientList.size());
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "patients.txt not found. No patient data loaded.", e);
             // It's okay if the file doesn't exist initially, list will remain empty
        } catch (NumberFormatException e) {
             LOGGER.log(Level.SEVERE, "Error parsing number in patients.txt. Check age format.", e);
        } catch (Exception e) {
             LOGGER.log(Level.SEVERE, "An unexpected error occurred while loading patients.", e);
        }
    }

    /**
     * Loads other data (doctors, appointments, etc.) in a similar fashion.
     * Placeholder for future implementation.
     */
    /*
    private static void loadDoctors() { ... }
    private static void loadAppointments() { ... }
    */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Load all necessary data at application startup
        loadPatients();
        // loadDoctors();
        // loadAppointments();

        // Launch the Login Frame on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}