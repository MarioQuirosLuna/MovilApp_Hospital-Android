package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cr.ac.ucr.movilapp_hospital.R;
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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options_civil_state, android.R.layout.simple_spinner_item);
        options_civil_state.setAdapter(adapter);
    }
}