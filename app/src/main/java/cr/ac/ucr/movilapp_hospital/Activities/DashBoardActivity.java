package cr.ac.ucr.movilapp_hospital.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import cr.ac.ucr.movilapp_hospital.Model.PatientSession;
import cr.ac.ucr.movilapp_hospital.R;

public class DashBoardActivity extends AppCompatActivity {

    PatientSession session;

    private TextView txt_Identification_Dashboard;
    private TextView txt_Name_Dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        txt_Identification_Dashboard = (TextView) findViewById(R.id.Patient_Identification_Dashboard);
        txt_Name_Dashboard = (TextView) findViewById(R.id.Patient_Name_Dashboard);



        Bundle extra = getIntent().getExtras();
        if(extra != null){
            session = new PatientSession(extra.getInt("identification"),extra.getString("name"));
            txt_Identification_Dashboard.setText(String.valueOf(session.getPatientIdentification()));
            txt_Name_Dashboard.setText(session.getPatientName());
        }

    }
}