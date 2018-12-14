package com.vetenary.jabu.vetenaryapp.serializers;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ResponseAppointEntity implements Parcelable {
    public int statusCode;
    public String message;
    public AppointmentDetailEntity data;


    protected ResponseAppointEntity(Parcel in) {
        statusCode = in.readInt();
        message = in.readString();
        data = in.readParcelable(AppointmentDetailEntity.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(statusCode);
        dest.writeString(message);
        dest.writeParcelable(data, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseAppointEntity> CREATOR = new Creator<ResponseAppointEntity>() {
        @Override
        public ResponseAppointEntity createFromParcel(Parcel in) {
            return new ResponseAppointEntity(in);
        }

        @Override
        public ResponseAppointEntity[] newArray(int size) {
            return new ResponseAppointEntity[size];
        }
    };
}
