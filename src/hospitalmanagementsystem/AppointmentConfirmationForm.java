/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagementsystem;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import hospitalmanagementsystem.Appointment;
import hospitalmanagementsystem.Main;

/**
 *
 * @author shaik
 */
public class AppointmentConfirmationForm extends javax.swing.JFrame {
    
    private String doctorId;
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AppointmentConfirmationForm.class.getName());

    /**
     * Creates new form AppointmentConfirmationForm
     */
    public AppointmentConfirmationForm() {
        initComponents();
    }
    
    
    public AppointmentConfirmationForm(String doctorId) {
        this(); // Call the default constructor to run initComponents()
        this.doctorId = doctorId;

        // Print debug info about the doctor ID and appointments
        System.out.println("AppointmentConfirmationForm created with doctorId: " + doctorId);

        // Check if Main.appointmentList is initialized and has data
        if (Main.appointmentList == null) {
            System.out.println("ERROR: Main.appointmentList is null!");
        } else {
            System.out.println("Main.appointmentList contains " + Main.appointmentList.size() + " appointments");

            // Print ALL appointments for debugging
            System.out.println("--- ALL APPOINTMENTS IN SYSTEM ---");
            for (Appointment appt : Main.appointmentList) {
                System.out.println("Appointment: " + appt.getAppointmentId() +
                                   ", Doctor: " + appt.getDoctorId() +
                                   ", Status: " + appt.getStatus());
            }
            System.out.println("--------------------------------");
        }

        // Force a debug reload of appointments directly from the file
        reloadAppointmentsFromFile();

        // Load appointments normally
        loadAppointments();
    }
    
    
    
    
    
    
    /**
 * Loads the doctor's pending appointments into the table.
 */
private void loadAppointments() {
    // Get the table model
    DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();
    model.setRowCount(0); // Clear existing rows

    // Debug: Print some info about what we're looking for
    System.out.println("Loading appointments for doctor ID: " + doctorId);
    System.out.println("Total appointments in the system: " + Main.appointmentList.size());

    // Debug: Check if appointmentList is actually initialized
    if (Main.appointmentList == null) {
        System.out.println("ERROR: Main.appointmentList is null!");
        JOptionPane.showMessageDialog(this, "Appointment list not initialized.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Filter appointments for the current doctor that are "Pending"
    int count = 0;
    for (Appointment appt : Main.appointmentList) {
        // Debug: Print each appointment we're considering
        System.out.println("Checking appointment: " + appt.getAppointmentId() +
                           ", Doctor: " + appt.getDoctorId() +
                           ", Status: " + appt.getStatus());

        if (appt.getDoctorId().equals(doctorId) && "Pending".equalsIgnoreCase(appt.getStatus())) {
            Object[] row = {appt.getAppointmentId(), appt.getPatientId(), appt.getDate(), appt.getTime(), appt.getStatus()};
            model.addRow(row);
            count++;
        }
    }

    // Debug: Inform about the result
    System.out.println("Found " + count + " pending appointments for doctor: " + doctorId);

    // If no appointments were found, show a message
    if (count == 0) {
        JOptionPane.showMessageDialog(this, "No pending appointments found for you.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}

    /**
     * Reloads appointments directly from the file for debugging purposes
     */
    private void reloadAppointmentsFromFile() {
        System.out.println("Forcing reload of appointments from file...");
        try {
            // Clear the existing appointment list
            Main.appointmentList.clear();

            // Read the appointments file directly
            java.io.File file = new java.io.File("C:/oopagm/HospitalManagementSystem/appointments.txt");
            if (!file.exists()) {
                System.out.println("ERROR: appointments.txt file not found!");
                JOptionPane.showMessageDialog(this, "Appointments file not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Read and parse each line
            java.util.Scanner scanner = new java.util.Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("//")) continue;

                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    String appointmentId = parts[0].trim();
                    String patientId = parts[1].trim();
                    String doctorId = parts[2].trim();
                    String date = parts[3].trim();
                    String time = parts[4].trim();
                    String status = parts[5].trim();

                    System.out.println("Loading appointment: ID=" + appointmentId +
                                       ", Doctor=" + doctorId +
                                       ", Status=" + status);

                    Appointment appt = new Appointment(appointmentId, patientId, doctorId, date, time, status);
                    Main.appointmentList.add(appt);
                } else {
                    System.out.println("WARNING: Skipping invalid appointment line: " + line);
                }
            }
            scanner.close();

            System.out.println("Successfully loaded " + Main.appointmentList.size() +
                              " appointments directly from file");

        } catch (Exception e) {
            System.out.println("ERROR loading appointments: " + e.getMessage());
            e.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        btnconfirm = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Confirm Appointments");

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 255));

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Appointment ID", "Patient ID", "Date", "Time", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblAppointments);

        btnconfirm.setBackground(new java.awt.Color(0, 0, 255));
        btnconfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnconfirm.setForeground(new java.awt.Color(0, 0, 0));
        btnconfirm.setText("Confirm");
        btnconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 0, 255));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(0, 0, 0));
        btnRefresh.setText("Refresh List");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(0, 0, 255));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(0, 0, 0));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnconfirm)
                        .addGap(108, 108, 108)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(193, 193, 193))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnconfirm)
                    .addComponent(btnRefresh)
                    .addComponent(btnClose))
                .addContainerGap(71, Short.MAX_VALUE))
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

    private void btnconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmActionPerformed
        
        
        int selectedRow = tblAppointments.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select an appointment to confirm.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Get the appointment ID from the table (assuming ID is in the first column)
    String apptId = (String) tblAppointments.getValueAt(selectedRow, 0);

    // Find the appointment in Main.appointmentList and update its status
    boolean found = false;
    for (Appointment appt : Main.appointmentList) {
        if (appt.getAppointmentId().equals(apptId)) {
            appt.setStatus("Confirmed");
            found = true;
            break;
        }
    }

    if (!found) {
        JOptionPane.showMessageDialog(this, "Failed to find the selected appointment.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Save the updated list to the file
    Main.saveAppointments();

    // Refresh the table to show the updated status
    loadAppointments();

    JOptionPane.showMessageDialog(this, "Appointment " + apptId + " has been confirmed!");
        
        
        
    }//GEN-LAST:event_btnconfirmActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadAppointments();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new AppointmentConfirmationForm().setVisible(true));
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnconfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAppointments;
    // End of variables declaration//GEN-END:variables
}
