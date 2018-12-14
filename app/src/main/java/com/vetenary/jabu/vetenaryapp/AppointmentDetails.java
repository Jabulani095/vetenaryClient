package com.vetenary.jabu.vetenaryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.vetenary.jabu.vetenaryapp.core.BaseEntry;
import com.vetenary.jabu.vetenaryapp.serializers.AppointmentDetailEntity;
import com.vetenary.jabu.vetenaryapp.serializers.DeleteViewModel;
import com.vetenary.jabu.vetenaryapp.serializers.ResponseAppointEntity;
import com.vetenary.jabu.vetenaryapp.services.AppConfig;

import java.util.List;

public class AppointmentDetails extends BaseEntry {

    private TextView lbl_customerName;
    private TextView lbl_identityNumber;
    private  TextView lbl_petName;
    private Button btn_cancel;
    private ResponseAppointEntity Appointment;
    private String appId;
    private Context context;

    @Override
    protected String getScreenName() {
        return "Details";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {

            } else {
                 appId = extras.getString("getid");
                getDetails(appId);
            }
        }
    }

    private void initViews(){
        lbl_customerName = findViewById(R.id.lbl_customerName);
        lbl_identityNumber = findViewById(R.id.lbl_identityNumber);
        lbl_petName = findViewById(R.id.lbl_petName);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( Appointment != null){
                    DELETE(AppConfig.ENDPOINT.CANCEL_APPOINTMENT,new DeleteViewModel(appId));
                }
            }
        });
    }

    private void getDetails(String id){
        GET(AppConfig.ENDPOINT.GET_APPOINTMENT_BY_ID+id,new AppointmentDetailEntity());
    }

    @Override
    public void OnGetDataSuccess(final String responseBody, Object object) {
        if(object instanceof AppointmentDetailEntity){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Gson gson = new Gson();

                    Appointment = gson.fromJson(responseBody, ResponseAppointEntity.class);
                    lbl_customerName.setText(Appointment.data.customerName);
                    lbl_identityNumber.setText(Appointment.data.identityNumber);
                    lbl_petName.setText(Appointment.data.petName);
                }
            });
        }else {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(context,MainActivity.class);
                    context.startActivity(i);
                }
            });
        }
    }

    @Override
    public void OnGetDataFailed(String ResponseBody, Object object, int status) {

    }
}
