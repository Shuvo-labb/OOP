/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagementsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaik
 */
public class CreateMedicalReportform extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(CreateMedicalReportform.class.getName());
    private String doctorId;

    // Common diseases/conditions for dropdown
    private static final String[] COMMON_DISEASES = {
        "Hypertension",
        "Diabetes",
        "Asthma",
        "Arthritis",
        "Common Cold",
        "Influenza",
        "Pneumonia",
        "Bronchitis",
        "Gastroenteritis",
        "Migraine",
        "Depression",
        "Anxiety Disorder",
        "COVID-19",
        "Heart Disease",
        "Stroke",
        "Cancer",
        "Allergic Rhinitis",
        "Urinary Tract Infection",
        "Osteoporosis",
        "COPD"
    };

    // Common diagnoses for dropdown
    private static final String[] COMMON_DIAGNOSES = {
        "Acute condition requiring immediate treatment",
        "Chronic condition requiring ongoing management",
        "Mild symptoms, supportive care recommended",
        "Moderate severity, medication required",
        "Severe condition requiring hospitalization",
        "Early stage, preventive measures recommended",
        "Advanced stage, aggressive treatment needed",
        "Condition in remission, monitoring required",
        "Condition requiring specialist referral",
        "Condition requiring surgical intervention",
        "Inconclusive, further testing required",
        "Negative findings, observation recommended"
    };

    // Common treatments for dropdown
    private static final String[] COMMON_TREATMENTS = {
        "Oral medication regimen",
        "Intravenous medication",
        "Antibiotic therapy",
        "Pain management",
        "Physical therapy",
        "Surgical intervention",
        "Diet and lifestyle modifications",
        "Psychological counseling",
        "Bed rest and hydration",
        "Specialist referral",
        "Preventive measures",
        "Regular monitoring",
        "No treatment required at this time"
    };

    /**
     * Creates new form CreateMedicalReportform
     */
    public CreateMedicalReportform() {
        initComponents();
        setLocationRelativeTo(null);

        // Ensure patients are loaded
        if (Main.patientList.isEmpty()) {
            loadPatients();
        }

        populatePatientComboBox();
        populateDropdownBoxes();
    }

    /**
     * Creates form with specified doctor ID
     */
    public CreateMedicalReportform(String doctorId) {
        this();
        this.doctorId = doctorId;
    }

    /**
     * Load patients from patients.txt if not already loaded
     */
    private void loadPatients() {
        try (Scanner scanner = new Scanner(new File("patients.txt"))) {
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
                    Main.patientList.add(patient);
                }
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            logger.log(Level.SEVERE, "Error loading patients", e);
            JOptionPane.showMessageDialog(this, "Error loading patients from file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Populates disease, diagnosis, and treatment dropdown boxes with predefined values
     */
    private void populateDropdownBoxes() {
        // Clear and populate disease dropdown
        cmbDisease.removeAllItems();
        cmbDisease.addItem("Select a disease/condition");
        for (String disease : COMMON_DISEASES) {
            cmbDisease.addItem(disease);
        }

        // Clear and populate diagnosis dropdown
        cmbDiagnosis.removeAllItems();
        cmbDiagnosis.addItem("Select a diagnosis");
        for (String diagnosis : COMMON_DIAGNOSES) {
            cmbDiagnosis.addItem(diagnosis);
        }

        // Clear and populate treatment dropdown
        cmbTreatment.removeAllItems();
        cmbTreatment.addItem("Select a treatment plan");
        for (String treatment : COMMON_TREATMENTS) {
            cmbTreatment.addItem(treatment);
        }
    }

    private void populatePatientComboBox() {
        cmbSelectPatient.removeAllItems();
        cmbSelectPatient.addItem("Select a patient...");

        // Add all patients to the combo box
        for (Patient patient : Main.patientList) {
            cmbSelectPatient.addItem(patient.getId() + " - " + patient.getName());
        }
    }

    /**
     * Save the medical record to file
     */
    private void saveMedicalRecord() {
        // Validate inputs
        if (cmbSelectPatient.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a patient", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cmbDisease.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a disease/condition", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cmbDiagnosis.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a diagnosis", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cmbTreatment.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a treatment plan", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Get selected patient ID from combo box
            String selectedPatient = cmbSelectPatient.getSelectedItem().toString();
            String patientId = selectedPatient.split(" - ")[0];

            // Find patient to get gender and region
            Patient patient = null;
            for (Patient p : Main.patientList) {
                if (p.getId().equals(patientId)) {
                    patient = p;
                    break;
                }
            }

            if (patient == null) {
                JOptionPane.showMessageDialog(this, "Patient not found", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Generate a unique record ID
            String recordId = "REC" + System.currentTimeMillis();

            // Format current date as YYYY-MM-DD
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            // Get the medical details from form
            String disease = cmbDisease.getSelectedItem().toString();
            String diagnosis = cmbDiagnosis.getSelectedItem().toString();
            String treatment = cmbTreatment.getSelectedItem().toString();

            // Create a new MedicalRecord object
            MedicalRecord record = new MedicalRecord(
                    recordId,
                    patientId,
                    doctorId,
                    date,
                    disease,
                    patient.getGender(),
                    patient.getRegion(),
                    diagnosis,
                    treatment
            );

            // Add to the application's list if it exists
            try {
                Main.medicalRecordList.add(record);
            } catch (Exception ex) {
                // If medicalRecordList doesn't exist, just continue to file writing
                logger.log(Level.WARNING, "Could not add to medicalRecordList, continuing with file save", ex);
            }

            // Prepare the record in CSV format
            String recordCsv = String.join(",",
                    recordId,
                    patientId,
                    doctorId,
                    date,
                    disease,
                    patient.getGender(),
                    patient.getRegion(),
                    diagnosis,
                    treatment);

            // Append the record to medical_records.txt
            try (PrintWriter writer = new PrintWriter(new FileWriter("medical_records.txt", true))) {
                writer.println(recordCsv);
            }

            JOptionPane.showMessageDialog(this,
                    "Medical record created successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Clear form fields
            cmbSelectPatient.setSelectedIndex(0);
            cmbDisease.setSelectedIndex(0);
            cmbDiagnosis.setSelectedIndex(0);
            cmbTreatment.setSelectedIndex(0);

        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error saving medical record", ex);
            JOptionPane.showMessageDialog(this,
                    "Error saving medical record: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cmbSelectPatient = new javax.swing.JComboBox<>();
        cmbDisease = new javax.swing.JComboBox<>();
        cmbDiagnosis = new javax.swing.JComboBox<>();
        cmbTreatment = new javax.swing.JComboBox<>();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Generate Medical Report");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Patient");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Disease/Condition");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Diagnosis");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Treatment Plan");

        btnSave.setBackground(new java.awt.Color(0, 255, 51));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 0));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cmbSelectPatient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDisease.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"Hypertension\",", "        \"Diabetes\",", "        \"Asthma\",", "        \"Arthritis\",", "        \"Common Cold\",", "        \"Influenza\",", "        \"Pneumonia\",", "        \"Bronchitis\",", "        \"Gastroenteritis\",", "        \"Migraine\",", "        \"Depression\",", "        \"Anxiety Disorder\",", "        \"COVID-19\",", "        \"Heart Disease\",", "        \"Stroke\",", "        \"Cancer\",", "        \"Allergic Rhinitis\",", "        \"Urinary Tract Infection\",", "        \"Osteoporosis\",", "        \"COPD\"" }));

        cmbDiagnosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"Acute condition requiring immediate treatment\",", "        \"Chronic condition requiring ongoing management\",", "        \"Mild symptoms, supportive care recommended\",", "        \"Moderate severity, medication required\",", "        \"Severe condition requiring hospitalization\",", "        \"Early stage, preventive measures recommended\",", "        \"Advanced stage, aggressive treatment needed\",", "        \"Condition in remission, monitoring required\",", "        \"Condition requiring specialist referral\",", "        \"Condition requiring surgical intervention\",", "        \"Inconclusive, further testing required\",", "        \"Negative findings, observation recommended\"" }));

        cmbTreatment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"Oral medication regimen\",", "        \"Intravenous medication\",", "        \"Antibiotic therapy\",", "        \"Pain management\",", "        \"Physical therapy\",", "        \"Surgical intervention\",", "        \"Diet and lifestyle modifications\",", "        \"Psychological counseling\",", "        \"Bed rest and hydration\",", "        \"Specialist referral\",", "        \"Preventive measures\",", "        \"Regular monitoring\",", "        \"No treatment required at this time\"" }));

        btnCancel.setBackground(new java.awt.Color(255, 51, 51));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(0, 0, 0));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addGap(59, 59, 59)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbSelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(136, 136, 136)
                        .addComponent(btnCancel)
                        .addGap(174, 174, 174)))
                .addGap(245, 245, 245))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbSelectPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbDisease, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveMedicalRecord();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        
        this.dispose();
        new DoctorDashboard().setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CreateMedicalReportform().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbDiagnosis;
    private javax.swing.JComboBox<String> cmbDisease;
    private javax.swing.JComboBox<String> cmbSelectPatient;
    private javax.swing.JComboBox<String> cmbTreatment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
