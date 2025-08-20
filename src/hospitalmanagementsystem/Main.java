/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalmanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Main class to start the Hospital Management System.
 * Responsible for initial data loading.
 */
public class Main {
    // Static logger for logging messages
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    // Static lists to hold data accessible throughout the application
    public static List<Patient> patientList = new ArrayList<>();
    public static List<Doctor> doctorList = new ArrayList<>();
    public static List<Appointment> appointmentList = new ArrayList<>();
    public static List<InventoryItem> inventoryList = new ArrayList<>();
    public static List<Prescription> prescriptionList = new ArrayList<>();
    public static List<Bill> billList = new ArrayList<>();
    public static List<Policy> policyList = new ArrayList<>();
    public static List<HealthcareProgram> healthcareProgramList = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<MedicalRecord> medicalRecordList = new ArrayList<>();

    /**
     * Saves appointments to appointments.txt.
     */
    public static void saveAppointments() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("C:/oopagm/HospitalManagementSystem/appointments.txt"))) {
            for (Appointment appt : appointmentList) {
                pw.println(appt.getAppointmentId() + "," +
                           appt.getPatientId() + "," +
                           appt.getDoctorId() + "," +
                           appt.getDate() + "," +
                           appt.getTime() + "," +
                           appt.getStatus());
            }
            LOGGER.info("Appointments saved successfully.");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error saving appointments to appointments.txt", e);
        }
    }

    /**
     * Loads patient data from patients.txt into the patientList.
     */
    private static void loadPatients() {
        patientList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/patients.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String gender = parts[3].trim();
                    String medicalHistory = parts[4].trim();
                    String region = parts[5].trim();

                    Patient patient = new Patient(id, name, age, gender, medicalHistory, region);
                    patientList.add(patient);
                } else {
                    LOGGER.log(Level.WARNING, "Skipping invalid patient line: {0}", line);
                }
            }
            LOGGER.info("Patients loaded successfully. Count: " + patientList.size());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "patients.txt not found!");
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error parsing age in patients.txt", e);
        }
    }

    /**
     * Loads appointment data from appointments.txt into the appointmentList.
     */
    private static void loadAppointments() {
        appointmentList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/appointments.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String appointmentId = parts[0].trim();
                    String patientId = parts[1].trim();
                    String doctorId = parts[2].trim();
                    String date = parts[3].trim();
                    String time = parts[4].trim();
                    String status = parts[5].trim();

                    Appointment appt = new Appointment(appointmentId, patientId, doctorId, date, time, status);
                    appointmentList.add(appt);
                }
            }
            System.out.println("✅ Loaded " + appointmentList.size() + " appointments.");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "appointments.txt not found!");
        }
    }

    /**
     * Loads user data from users.txt into the users list.
     */
    private static void loadUsers() {
        users.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/users.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String role = parts[0].trim();
                    String username = parts[1].trim();
                    String password = parts[2].trim();

                    switch (role) {
                        case "Admin":
                            users.add(new Admin(username, password));
                            break;
                        case "Doctor":
                            if (parts.length >= 4) {
                                String doctorId = parts[3].trim();
                                users.add(new Doctor(username, password, doctorId));
                            }
                            break;
                        case "Patient":
                            if (parts.length >= 4) {
                                String patientId = parts[3].trim();
                                users.add(new Patient(username, password, patientId));
                            }
                            break;
                        case "Guest":
                            users.add(new Guest(username, password));
                            break;
                    }
                }
            }
            System.out.println("✅ Users loaded: " + users.size());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "users.txt not found!");
        }
    }

    /**
     * Loads doctor data from doctors.txt
     */
    private static void loadDoctors() {
        doctorList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/doctors.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String specialization = parts[2].trim();
                    String contact = parts[3].trim();

                    Doctor doctor = new Doctor(id, name, specialization, contact);
                    doctorList.add(doctor);
                }
            }
        } catch (FileNotFoundException e) {
            // Optional: create file if missing
        }
    }

    /**
     * Loads inventory data from inventory.txt
     */
    private static void loadInventory() {
        inventoryList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/inventory.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String itemId = parts[0].trim();
                    String name = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    String supplier = parts[3].trim();

                    InventoryItem item = new InventoryItem(itemId, name, quantity, supplier);
                    inventoryList.add(item);
                }
            }
            System.out.println("✅ Loaded " + inventoryList.size() + " inventory items.");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "inventory.txt not found!");
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error parsing quantity in inventory.txt", e);
        }
    }

    /**
     * Loads prescriptions from prescriptions.txt
     */
    private static void loadPrescriptions() {
        prescriptionList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/prescriptions.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String id = parts[0].trim();
                    String patientId = parts[1].trim();
                    String doctorId = parts[2].trim();
                    String medicine = parts[3].trim();
                    String dosage = parts[4].trim();
                    String date = parts[5].trim();

                    Prescription p = new Prescription(id, patientId, doctorId, medicine, dosage, date);
                    prescriptionList.add(p);
                }
            }
        } catch (FileNotFoundException e) {
            // Optional
        }
    }

    /**
     * Loads bills from bills.txt
     */
    private static void loadBills() {
        billList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/bills.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String patientId = parts[1].trim();
                    double amount = Double.parseDouble(parts[2].trim());

                    Bill bill = new Bill(id, patientId, amount, "Unpaid"); // Added "Unpaid" as default status
                    billList.add(bill);
                }
            }
        } catch (FileNotFoundException e) {
            // Optional
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Invalid bill amount", e);
        }
    }

    /**
     * Loads policies from policies.txt
     */
    private static void loadPolicies() {
        policyList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/policies.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String title = parts[0].trim();
                    String content = parts[1].trim();
                    String policyId = "POL" + title.substring(0, Math.min(3, title.length())).toUpperCase(); // Generate policy ID from title
                    policyList.add(new Policy(policyId, title, content));
                }
            }
        } catch (FileNotFoundException e) {
            // Optional
        }
    }

    /**
     * Loads healthcare programs from healthcare_programs.txt
     */
    private static void loadHealthcarePrograms() {
        healthcareProgramList.clear();
        try (Scanner scanner = new Scanner(new File("C:/oopagm/HospitalManagementSystem/healthcare_programs.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String desc = parts[1].trim();
                    String programId = "PROG" + name.substring(0, Math.min(3, name.length())).toUpperCase(); // Generate program ID from name
                    String schedule = "To be announced"; // Default schedule value
                    healthcareProgramList.add(new HealthcareProgram(programId, name, desc, schedule));
                }
            }
        } catch (FileNotFoundException e) {
            // Optional
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Load all necessary data at application startup
        loadUsers();
        loadPatients();
        loadAppointments();
        loadDoctors();
        loadInventory();
        loadPrescriptions();
        loadBills();
        loadPolicies();
        loadHealthcarePrograms();

        // Launch the Login Frame
        java.awt.EventQueue.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}