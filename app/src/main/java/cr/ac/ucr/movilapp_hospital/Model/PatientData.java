package cr.ac.ucr.movilapp_hospital.Model;

public class PatientData {
    public int id;
    public int patient_identification;
    public String patient_name;
    public int age;
    public String blood_type;
    public String civil_status;
    public String telephone;
    public PatientAddres patient_addres;

    public int getId() { return id; }

    public int getPatient_identification() { return patient_identification; }

    public String getPatient_name() { return patient_name; }

    public int getAge() { return age; }

    public String getBlood_type() { return blood_type; }

    public String getCivil_status() { return civil_status; }

    public void setCivil_status(String civil_status) { this.civil_status = civil_status; }

    public String getTelephone() { return telephone; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public PatientAddres getPatient_addres() { return patient_addres; }

    public void setPatient_addres(PatientAddres patient_addres) { this.patient_addres = patient_addres; }
}
