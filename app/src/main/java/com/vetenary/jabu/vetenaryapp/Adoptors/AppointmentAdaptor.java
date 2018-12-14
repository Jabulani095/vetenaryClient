package com.vetenary.jabu.vetenaryapp.Adoptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.vetenary.jabu.vetenaryapp.R;
import com.vetenary.jabu.vetenaryapp.events.CustomAdaptorEvents;
import com.vetenary.jabu.vetenaryapp.serializers.AppintmentEntity;

import java.util.List;

public class AppointmentAdaptor extends BaseAdapter {
    private List<AppintmentEntity> appintmentEntities;
    Context context;
    LayoutInflater layoutInflater;

    public AppointmentAdaptor(List<AppintmentEntity> appintmentEntities, Context context) {
        this.appintmentEntities = appintmentEntities;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return appintmentEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View viewContent, ViewGroup parent) {
        AppointmentAdaptor.ViewHolder viewHolder = null;
        if (viewContent == null) {
            viewContent = layoutInflater.inflate(R.layout.item_appointment, null);
        }
        viewHolder = new AppointmentAdaptor.ViewHolder();
        viewContent = layoutInflater.inflate(R.layout.item_appointment, null);
        viewHolder.txtTime = viewContent.findViewById(R.id.txttime);
        viewHolder.txtName = viewContent.findViewById(R.id.txtName);
        viewHolder.btn_more = viewContent.findViewById(R.id.btn_more);

        viewHolder.txtName.setText(appintmentEntities.get(position).customerName);
        viewHolder.txtTime.setText(appintmentEntities.get(position).time);
        viewHolder.btn_more.setTag(appintmentEntities.get(position));


        viewHolder.btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppintmentEntity app = (AppintmentEntity) v.getTag();
                CustomAdaptorEvents listener = (CustomAdaptorEvents) context;
                listener.customEventTrigger(app.id, 343434, null);
            }
        });

        return viewContent;
    }

    private class ViewHolder {
        public TextView txtTime;
        public TextView txtName;
        public Button btn_more;
    }
}
