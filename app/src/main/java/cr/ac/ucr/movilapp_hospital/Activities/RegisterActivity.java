package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cr.ac.ucr.movilapp_hospital.API.API_HospitalPatient;
import cr.ac.ucr.movilapp_hospital.Model.PatientData;
import cr.ac.ucr.movilapp_hospital.Model.PatientRegister;
import cr.ac.ucr.movilapp_hospital.Model.PatientSession;
import cr.ac.ucr.movilapp_hospital.Model.RetrofitSingleton;
import cr.ac.ucr.movilapp_hospital.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "PATIENT_APP";

    private Retrofit retrofit;

    private Spinner options_civil_state;

    private EditText txt_identification;
    private EditText txt_name;
    private EditText txt_password;
    private EditText txt_age;
    private EditText txt_bloodType;
    private EditText txt_telephone;
    private EditText txt_province;
    private EditText txt_canton;
    private EditText txt_district;
    private EditText txt_otherSigns;

    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        options_civil_state = (Spinner) findViewById(R.id.Combo_Civil_State);
        txt_identification = (EditText) findViewById(R.id.Patient_Identification_Register);
        txt_name = (EditText) findViewById(R.id.Patient_Name_Register);
        txt_password = (EditText) findViewById(R.id.Patient_Password_Register);
        txt_age = (EditText) findViewById(R.id.Patient_Age_Register);
        txt_bloodType = (EditText) findViewById(R.id.Patient_Blood_type_Register);
        txt_telephone = (EditText) findViewById(R.id.Patient_Telephone_Register);
        txt_province = (EditText) findViewById(R.id.Patient_Province_Register);
        txt_canton = (EditText) findViewById(R.id.Patient_Canton_Register);
        txt_district = (EditText) findViewById(R.id.Patient_District_Register);
        txt_otherSigns = (EditText) findViewById(R.id.Patient_Description_Register);

        btn_register = (Button) findViewById(R.id.Register_Button_Register);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options_civil_state, android.R.layout.simple_spinner_item);
        options_civil_state.setAdapter(adapter);

        btn_register.setOnClickListener(v -> {
            retrofit = RetrofitSingleton.getRetrofit();
            registerPacient(
                    new PatientRegister(
                            Integer.parseInt(txt_identification.getText().toString().trim()),
                            txt_name.getText().toString().trim(),
                            txt_password.getText().toString().trim(),
                            Integer.parseInt(txt_age.getText().toString().trim()),
                            txt_bloodType.getText().toString().trim(),
                            options_civil_state.getSelectedItem().toString(),
                            txt_telephone.getText().toString().trim(),
                            txt_province.getText().toString().trim(),
                            txt_canton.getText().toString().trim(),
                            txt_district.getText().toString().trim(),
                            txt_otherSigns.getText().toString().trim()
                    )
            );
        });
    }

    public void registerPacient(PatientRegister patientregister){

        API_HospitalPatient api = retrofit.create(API_HospitalPatient.class);

        Call<PatientData> call = api.addPatient(patientregister);

        call.enqueue(new Callback<PatientData>() {
            @Override
            public void onResponse(Call<PatientData> call, Response<PatientData> response) {
                if(!response.isSuccessful()){
                    Log.e(TAG, " onResponse: "+response.errorBody());
                    return;
                }

                PatientData patientData = response.body();

                if(patientData != null){
                    Log.e(TAG, " onResponse: "+patientData.toString());
                    Log.e(TAG, " onResponse2: "+patientData.patient_addres.getProvince());
                    onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<PatientData> call, Throwable t) {
                Log.e(TAG, " onFailure: "+t.getMessage());
            }
        });
    }
}