/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalmanagementsystem;

/**
 *
 * @author shaik
 */
public class PatientRecordsForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PatientRecordsForm.class.getName());
    private String patientId;

    /**
     * Creates new form PatientRecordsForm
     */
    public PatientRecordsForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Creates new form PatientRecordsForm with specified patient ID
     * @param patientId The ID of the patient whose records to display
     */
    public PatientRecordsForm(String patientId) {
        this();
        this.patientId = patientId;
        loadPatientRecords();
    }

    /**
     * Loads the patient records for the specified patient ID
     */
    private void loadPatientRecords() {
        if (patientId == null || patientId.isEmpty()) {
            txtPatientRecords.setText("No patient ID provided.");
            return;
        }

        try {
            // First load patient details from patients.txt
            java.io.File patientFile = new java.io.File("patients.txt");
            if (!patientFile.exists()) {
                txtPatientRecords.setText("Patient file not found.");
                return;
            }

            StringBuilder recordsText = new StringBuilder();
            recordsText.append("PATIENT INFORMATION\n");
            recordsText.append("===================\n\n");

            // Find patient information
            boolean patientFound = false;
            java.util.Scanner patientScanner = new java.util.Scanner(patientFile);

            while (patientScanner.hasNextLine()) {
                String line = patientScanner.nextLine();
                String[] parts = line.split(",");

                // Format expected: patientId,name,age,gender,contact,address,medicalHistory,...
                if (parts.length >= 7 && parts[0].equals(patientId)) {
                    recordsText.append("Patient ID: ").append(parts[0]).append("\n");
                    recordsText.append("Name: ").append(parts[1]).append("\n");
                    recordsText.append("Age: ").append(parts[2]).append("\n");
                    recordsText.append("Gender: ").append(parts[3]).append("\n");
                    recordsText.append("Contact: ").append(parts[4]).append("\n");
                    recordsText.append("Address: ").append(parts[5]).append("\n");
                    recordsText.append("Medical History: ").append(parts[6]).append("\n\n");
                    patientFound = true;
                    break;
                }
            }
            patientScanner.close();

            if (!patientFound) {
                recordsText.append("Patient with ID ").append(patientId).append(" not found.\n\n");
            }

            // Now load medical records from medical_records.txt
            recordsText.append("MEDICAL RECORDS\n");
            recordsText.append("===================\n\n");

            java.io.File medicalFile = new java.io.File("medical_records.txt");
            if (!medicalFile.exists()) {
                recordsText.append("No medical records file found.");
                txtPatientRecords.setText(recordsText.toString());
                return;
            }

            java.util.Scanner medicalScanner = new java.util.Scanner(medicalFile);
            boolean foundRecords = false;

            while (medicalScanner.hasNextLine()) {
                String line = medicalScanner.nextLine();
                String[] parts = line.split(",");

                // Format: patientId,recordDate,diagnosis,treatment,doctorId
                if (parts.length >= 5 && parts[0].equals(patientId)) {
                    recordsText.append("Date: ").append(parts[1]).append("\n");
                    recordsText.append("Diagnosis: ").append(parts[2]).append("\n");
                    recordsText.append("Treatment: ").append(parts[3]).append("\n");
                    recordsText.append("Doctor ID: ").append(parts[4]).append("\n");
                    recordsText.append("-------------------\n");
                    foundRecords = true;
                }
            }

            medicalScanner.close();

            if (!foundRecords) {
                recordsText.append("No medical records found for this patient.");
            }

            txtPatientRecords.setText(recordsText.toString());

        } catch (Exception e) {
            txtPatientRecords.setText("Error loading patient records: " + e.getMessage());
            logger.log(java.util.logging.Level.SEVERE, "Error loading patient records", e);
        }
    }

    /**
     * Loads all patient records from the patients.txt file
     */
    public void loadAllPatientRecords() {
        try {
            // Load all patients from patients.txt
            java.io.File patientFile = new java.io.File("patients.txt");
            if (!patientFile.exists()) {
                txtPatientRecords.setText("Patient file not found.");
                return;
            }

            StringBuilder recordsText = new StringBuilder();
            recordsText.append("ALL PATIENT RECORDS\n");
            recordsText.append("===================\n\n");

            java.util.Scanner patientScanner = new java.util.Scanner(patientFile);
            boolean patientsFound = false;

            while (patientScanner.hasNextLine()) {
                String line = patientScanner.nextLine();
                String[] parts = line.split(",");

                // Format in file: patientId,name,age,gender,medicalHistory,address
                if (parts.length >= 6) {
                    recordsText.append("Patient ID: ").append(parts[0]).append("\n");
                    recordsText.append("Name: ").append(parts[1]).append("\n");
                    recordsText.append("Age: ").append(parts[2]).append("\n");
                    recordsText.append("Gender: ").append(parts[3]).append("\n");
                    recordsText.append("Medical History: ").append(parts[4]).append("\n");
                    recordsText.append("Address: ").append(parts[5]).append("\n");
                    recordsText.append("-------------------\n\n");
                    patientsFound = true;
                }
            }
            patientScanner.close();

            if (!patientsFound) {
                recordsText.append("No patient records found.");
            }

            txtPatientRecords.setText(recordsText.toString());

        } catch (Exception e) {
            txtPatientRecords.setText("Error loading patient records: " + e.getMessage());
            logger.log(java.util.logging.Level.SEVERE, "Error loading patient records", e);
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

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPatientRecords = new javax.swing.JTextArea();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        txtPatientRecords.setBackground(new java.awt.Color(102, 255, 255));
        txtPatientRecords.setColumns(20);
        txtPatientRecords.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPatientRecords.setRows(5);
        jScrollPane2.setViewportView(txtPatientRecords);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        java.awt.EventQueue.invokeLater(() -> new PatientRecordsForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtPatientRecords;
    // End of variables declaration//GEN-END:variables
}
