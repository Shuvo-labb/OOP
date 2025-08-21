/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package hospitalmanagementsystem;

// Import statements needed for the functionality

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import hospitalmanagementsystem.Main; // Ensure this is present
import hospitalmanagementsystem.Appointment;
import java.util.List;
// ... other imports ...

/**
 *
 * @author shaik
 */
public class DoctorDashboard extends javax.swing.JFrame {
    
    private void generateReportByDisease() {
    // Prompt the user to enter the disease name
    String disease = JOptionPane.showInputDialog(this, "Enter the disease to filter:", "Generate Report by Disease", JOptionPane.PLAIN_MESSAGE);

    if (disease == null || disease.trim().isEmpty()) {
        return; // User cancelled or entered nothing
    }

    // Filter patients by disease
    List<Patient> filteredPatients = new ArrayList<>();
    for (Patient patient : Main.patientList) {
        if (patient.getMedicalHistory().toLowerCase().contains(disease.toLowerCase())) {
            filteredPatients.add(patient);
        }
    }

    // Display the filtered patients
    if (filteredPatients.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No patients found with the specified disease.", "Report Results", JOptionPane.INFORMATION_MESSAGE);
    } else {
        StringBuilder report = new StringBuilder("Patients with Disease: " + disease + "\n\n");
        for (Patient patient : filteredPatients) {
            report.append("ID: ").append(patient.getId()).append("\n");
            report.append("Name: ").append(patient.getName()).append("\n");
            report.append("Age: ").append(patient.getAge()).append("\n");
            report.append("Gender: ").append(patient.getGender()).append("\n");
            report.append("Medical History: ").append(patient.getMedicalHistory()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(report.toString());
        textArea.setEditable(false); // Make it read-only
        textArea.setColumns(40); // Set approximate width
        textArea.setRows(20);    // Set approximate height
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Medical Report - By Disease", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    
    
    private void generateReportByGender() {
    // Prompt the user to select the gender
    String[] genders = {"Male", "Female", "Other"};
    String selectedGender = (String) JOptionPane.showInputDialog(
        this,
        "Select Gender:",
        "Generate Report by Gender",
        JOptionPane.PLAIN_MESSAGE,
        null,
        genders,
        genders[0]
    );

    if (selectedGender == null) {
        return; // User cancelled the dialog
    }

    // Filter patients by gender
    List<Patient> filteredPatients = new ArrayList<>();
    for (Patient patient : Main.patientList) {
        if (patient.getGender().equalsIgnoreCase(selectedGender)) {
            filteredPatients.add(patient);
        }
    }

    // Display the filtered patients
    if (filteredPatients.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No patients found with the specified gender.", "Report Results", JOptionPane.INFORMATION_MESSAGE);
    } else {
        StringBuilder report = new StringBuilder("Patients of Gender: " + selectedGender + "\n\n");
        for (Patient patient : filteredPatients) {
            report.append("ID: ").append(patient.getId()).append("\n");
            report.append("Name: ").append(patient.getName()).append("\n");
            report.append("Age: ").append(patient.getAge()).append("\n");
            report.append("Medical History: ").append(patient.getMedicalHistory()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(report.toString());
        textArea.setEditable(false); // Make it read-only
        textArea.setColumns(40); // Set approximate width
        textArea.setRows(20);    // Set approximate height
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Medical Report - By Gender", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    
    
    
    private void generateReportByRegion() {
    // Prompt the user to enter the region
    String region = JOptionPane.showInputDialog(this, "Enter the region to filter:", "Generate Report by Region", JOptionPane.PLAIN_MESSAGE);

    if (region == null || region.trim().isEmpty()) {
        return; // User cancelled or entered nothing
    }

    // Filter patients by region
    List<Patient> filteredPatients = new ArrayList<>();
    for (Patient patient : Main.patientList) {
        if (patient.getRegion().equalsIgnoreCase(region)) {
            filteredPatients.add(patient);
        }
    }

    // Display the filtered patients
    if (filteredPatients.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No patients found in the specified region.", "Report Results", JOptionPane.INFORMATION_MESSAGE);
    } else {
        StringBuilder report = new StringBuilder("Patients in Region: " + region + "\n\n");
        for (Patient patient : filteredPatients) {
            report.append("ID: ").append(patient.getId()).append("\n");
            report.append("Name: ").append(patient.getName()).append("\n");
            report.append("Age: ").append(patient.getAge()).append("\n");
            report.append("Medical History: ").append(patient.getMedicalHistory()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(report.toString());
        textArea.setEditable(false); // Make it read-only
        textArea.setColumns(40); // Set approximate width
        textArea.setRows(20);    // Set approximate height
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Medical Report - By Region", JOptionPane.INFORMATION_MESSAGE);
    }
}
    


    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DoctorDashboard.class.getName());
    private String doctorId; // this line stores the current doctor's ID
    /**
     * Creates new form DoctorDashboard
     */
    public DoctorDashboard() {
        initComponents();
    }
    
    public DoctorDashboard(String doctorId) {
    this(); // Call the default constructor to run initComponents()
    this.doctorId = doctorId; // Set the doctor ID
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnpatientrecords = new javax.swing.JButton();
        btnprescribemedication = new javax.swing.JButton();
        btnmedicalreport = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();
        btnconfirmappointments = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 51, 255));

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Welcome Doctor!");

        btnpatientrecords.setBackground(new java.awt.Color(0, 51, 204));
        btnpatientrecords.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnpatientrecords.setText("View patient records");
        btnpatientrecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpatientrecordsActionPerformed(evt);
            }
        });

        btnprescribemedication.setBackground(new java.awt.Color(0, 51, 204));
        btnprescribemedication.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnprescribemedication.setText("Prescribe medication");
        btnprescribemedication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprescribemedicationActionPerformed(evt);
            }
        });

        btnmedicalreport.setBackground(new java.awt.Color(0, 51, 204));
        btnmedicalreport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnmedicalreport.setText("Generate medical reports");
        btnmedicalreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmedicalreportActionPerformed(evt);
            }
        });

        btnlogout.setBackground(new java.awt.Color(0, 51, 204));
        btnlogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnlogout.setText("Log out");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        btnconfirmappointments.setBackground(new java.awt.Color(0, 51, 204));
        btnconfirmappointments.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnconfirmappointments.setText("Confirm appointments");
        btnconfirmappointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmappointmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnpatientrecords)
                        .addGap(38, 38, 38)
                        .addComponent(btnconfirmappointments)
                        .addGap(54, 54, 54)
                        .addComponent(btnprescribemedication))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btnmedicalreport))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(btnlogout)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpatientrecords)
                    .addComponent(btnconfirmappointments)
                    .addComponent(btnprescribemedication))
                .addGap(50, 50, 50)
                .addComponent(btnmedicalreport)
                .addGap(72, 72, 72)
                .addComponent(btnlogout)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    
    private void btnconfirmappointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmappointmentsActionPerformed
        
        new AppointmentConfirmationForm(doctorId).setVisible(true);
    
    }//GEN-LAST:event_btnconfirmappointmentsActionPerformed

    
    
    
    private void btnpatientrecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpatientrecordsActionPerformed
        // Open the PatientRecordsForm to display all patients
        PatientRecordsForm recordsForm = new PatientRecordsForm();
        recordsForm.loadAllPatientRecords(); // Call method to load all patients
        recordsForm.setVisible(true);
    }//GEN-LAST:event_btnpatientrecordsActionPerformed

    private void btnprescribemedicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprescribemedicationActionPerformed
        new PrescriptionForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnprescribemedicationActionPerformed

    private void btnmedicalreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmedicalreportActionPerformed
        // Display options to create or view medical records
        new CreateMedicalReportform().setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnmedicalreportActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        JOptionPane.showMessageDialog(this, "Logged out successfully!");

    // Create and display the LoginFrame
        new LoginFrame().setVisible(true);

    // Close the current DoctorDashboard window
        this.dispose();
    }//GEN-LAST:event_btnlogoutActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new DoctorDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconfirmappointments;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnmedicalreport;
    private javax.swing.JButton btnpatientrecords;
    private javax.swing.JButton btnprescribemedication;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
