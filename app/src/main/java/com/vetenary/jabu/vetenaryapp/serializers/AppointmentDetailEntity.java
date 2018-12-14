package com.vetenary.jabu.vetenaryapp.serializers;

import android.os.Parcel;
import android.os.Parcelable;

public class AppointmentDetailEntity implements Parcelable {
    public String customerName;
    public String identityNumber;
    public String petName;

    public AppointmentDetailEntity(Parcel in) {
        customerName = in.readString();
        identityNumber = in.readString();
        petName = in.readString();
    }

    public static final Creator<AppointmentDetailEntity> CREATOR = new Creator<AppointmentDetailEntity>() {
        @Override
        public AppointmentDetailEntity createFromParcel(Parcel in) {
            return new AppointmentDetailEntity(in);
        }

        @Override
        public AppointmentDetailEntity[] newArray(int size) {
            return new AppointmentDetailEntity[size];
        }
    };

    public AppointmentDetailEntity() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerName);
        dest.writeString(identityNumber);
        dest.writeString(petName);
    }
}
