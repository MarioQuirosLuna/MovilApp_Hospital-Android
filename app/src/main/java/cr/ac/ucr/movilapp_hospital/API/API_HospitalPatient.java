package cr.ac.ucr.movilapp_hospital.API;

import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.PatientLogin;
import cr.ac.ucr.movilapp_hospital.Model.PatientRegister;
import cr.ac.ucr.movilapp_hospital.Model.PatientSession;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API_HospitalPatient {
    @GET("showDataPatient")
    Call<PatientData> getPatientData(@Query("identification") int identification);

    @POST("loginPatient")
    Call<PatientSession> loginPatient(@Body PatientLogin patientLogin);

    @POST("createPatient")
    Call<PatientData> addPatient(@Body PatientRegister patientRegister);
}
