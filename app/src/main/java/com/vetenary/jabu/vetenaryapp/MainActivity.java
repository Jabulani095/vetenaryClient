package com.vetenary.jabu.vetenaryapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.vetenary.jabu.vetenaryapp.Adoptors.AppointmentAdaptor;
import com.vetenary.jabu.vetenaryapp.core.BaseEntry;
import com.vetenary.jabu.vetenaryapp.events.CustomAdaptorEvents;
import com.vetenary.jabu.vetenaryapp.serializers.AppintmentEntity;
import com.vetenary.jabu.vetenaryapp.serializers.AppointRequestAll;
import com.vetenary.jabu.vetenaryapp.serializers.ResponseEntity;
import com.vetenary.jabu.vetenaryapp.services.AppConfig;

import butterknife.BindView;

public class MainActivity extends BaseEntry implements CustomAdaptorEvents {

    private ResponseEntity allAppointments;
    private AppointmentAdaptor appointmentAdaptor;
    private ListView lstView;
    private Context context;
    private ProgressBar progress_br;
    @Override
    protected String getScreenName() {
        return "Main";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        lstView = findViewById(R.id.lstView);
        progress_br = findViewById(R.id.progress_br);
        getAppointments();

    }

    private void getAppointments(){
        GET(AppConfig.ENDPOINT.GET_ALL_APPOINTMENT,new AppointRequestAll());
    }

    @Override
    public void OnGetDataSuccess(final String responseBody, Object object) {
        try {
            if (object instanceof AppointRequestAll) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Gson gson = new Gson();

                    allAppointments = gson.fromJson(responseBody, ResponseEntity.class);
                    appointmentAdaptor = new AppointmentAdaptor(allAppointments.data, context);
                    lstView.setAdapter(appointmentAdaptor);
                    progress_br.setVisibility(View.GONE);
                    lstView.setVisibility(View.VISIBLE);
                }
            });
            }
        }catch (Exception ex){
            String sdsd = ex.getMessage();
        }
    }

    @Override
    public void OnGetDataFailed(String ResponseBody, Object object, int status) {

    }

    @Override
    public void customEventTrigger(final String stringValue, final int intValue, Object objectValue) {
        if(intValue == 343434){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(context,AppointmentDetails.class);
                    i.putExtra("getid",stringValue);
                    context.startActivity(i);
                }
            });
        }
    }
}
