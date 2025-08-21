/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;

/**
 *
 * @author User
 */
public class Viewscript {
   //attributes
    private String PerscriptionId; 
    private String Patient; 
    private String Doctor;
    private String Medicine; 
    private String Dosage;
    private String Duration;
    // methods 1.Constructor (Empty, Parmeterised)
    public Viewscript(String Pi, String PI, String Dc, String MD, String Ds, String DT)
    {
     PerscriptionId = Pi;Patient =PI; Doctor =Dc; Medicine =MD; 
     Dosage =Ds;Duration =DT;
    }
    public Viewscript()
    {
      System.out.println("Duration object created...");
      Duration = "OP";
    }
    public void setPerscriptionId(String P)
    {
      PerscriptionId = P;
    }

    public void setPatient(String Patient) {
        this.Patient = Patient;
    }

    public void setDoctor(String Doctor) {
        this.Doctor = Doctor;
    }

    public void setMedicine(String Medicine) {
        this.Medicine = Medicine;
    }

    public void setDosage(String Dosage) {
        this.Dosage = Dosage;
    }
     public void setDuration(String Duration) {
        this.Duration = Duration;
    }
    //Getter
    public String getPerscriptionId()
    {
        return PerscriptionId;
    }

    public String getPatient() {
        return Patient;
    }

    public String getDoctor() {
        return Doctor;
    }

    public String getMedicine() {
        return Medicine;
    }

    public String getDosage() {
        return Dosage;
    }
    
    public String getDuration() {
        return Duration;
    }
    
    public void PrintPatientDetails()
    {
      System.out.println("Perscription Id = " + getPerscriptionId());
      System.out.println("Patient  = " + getPatient());
      System.out.println("Doctor = " + getDoctor());
      System.out.println("Medicine = " + getMedicine());
      System.out.println("Dosage = " + getDosage());
      System.out.println("Duration = " + getDuration());
    } 
}
