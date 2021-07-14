package cr.ac.ucr.movilapp_hospital.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import cr.ac.ucr.movilapp_hospital.R;

public class ItemAppointmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    Context context;

    TextView clinicName;
    TextView dateTime;
    ConstraintLayout itemPress;

    public ItemAppointmentViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        clinicName = (TextView) itemView.findViewById(R.id.clinic_name_item);
        dateTime = (TextView) itemView.findViewById(R.id.date_time_item);
        itemPress = (ConstraintLayout) itemView.findViewById(R.id.layout_eventPress_item);

    }

    public void setOnClickListener() { itemPress.setOnClickListener(this); }

    @Override
    public void onClick(View v) {

    }
}
