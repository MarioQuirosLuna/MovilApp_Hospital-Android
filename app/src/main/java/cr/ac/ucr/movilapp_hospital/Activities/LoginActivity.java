package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Model.PatientLogin;
import cr.ac.ucr.movilapp_hospital.Model.PatientSession;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;

    private EditText txt_identification;
    private EditText txt_password;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_identification = (EditText)findViewById(R.id.Patient_Identification_Login);
        txt_password = (EditText)findViewById(R.id.Patient_Password_Login);
        btnLogin = (Button)findViewById(R.id.Login_Button);
        btnRegister = (Button)findViewById(R.id.Register_Button_Login);

        btnLogin.setOnClickListener(v -> {

            retrofit = RetrofitSingleton.getRetrofit();

            searchPatient(Integer.parseInt(txt_identification.getText().toString().trim()), String.valueOf(txt_password.getText().toString().trim()));
        });

        btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
            startActivity(intent);
        });

    }

    private void searchPatient(int identification, String password){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);
        PatientLogin patientLogin = new PatientLogin(identification, password);

        Call<PatientSession> call = api.loginPatient(patientLogin);

        call.enqueue(new Callback<PatientSession>() {

            @Override
            public void onResponse(Call<PatientSession> call, Response<PatientSession> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }

                PatientSession patient = response.body();

                if(patient != null){
                    Log.e(TAG, " onResponse: SI "+patient.toString());
                    Intent intent = new Intent(getApplicationContext(),DashBoardActivity.class);
                    intent.putExtra("identification", patient.getPatientIdentification());
                    intent.putExtra("name", patient.getPatientName());
                    startActivity(intent);
                }else{
                    Log.e(TAG, " onResponse: Incorrect ");
                }
            }

            @Override
            public void onFailure(Call<PatientSession> call, Throwable t) {
                Log.e(TAG, " onFailure: "+t.getMessage());
            }
        });

    }
}