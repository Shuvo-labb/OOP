/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// MedicalRecord.java
package hospitalmanagementsystem;

public class MedicalRecord {
    private String recordId;
    private String patientId;
    private String doctorId;
    private String date;
    private String disease;
    private String gender;
    private String region;
    private String diagnosis;
    private String treatment;

    // Constructor
    public MedicalRecord(String recordId, String patientId, String doctorId, String date,
                         String disease, String gender, String region, String diagnosis, String treatment) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.disease = disease;
        this.gender = gender;
        this.region = region;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    // Getters
    public String getRecordId() {
        return recordId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getDisease() {
        return disease;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    @Override
    public String toString() {
        return String.format("Record[ID=%s, Disease=%s, Gender=%s, Region=%s, Date=%s]",
                recordId, disease, gender, region, date);
    }
}
