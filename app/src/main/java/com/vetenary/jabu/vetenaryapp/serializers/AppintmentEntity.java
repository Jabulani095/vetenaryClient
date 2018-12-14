package com.vetenary.jabu.vetenaryapp.serializers;

import android.os.Parcel;
import android.os.Parcelable;

public class AppintmentEntity implements Parcelable {
    public String customerName;
    public String time;
    public String id;

    protected AppintmentEntity(Parcel in) {
        customerName = in.readString();
        time = in.readString();
        id = in.readString();
    }

    public static final Creator<AppintmentEntity> CREATOR = new Creator<AppintmentEntity>() {
        @Override
        public AppintmentEntity createFromParcel(Parcel in) {
            return new AppintmentEntity(in);
        }

        @Override
        public AppintmentEntity[] newArray(int size) {
            return new AppintmentEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerName);
        dest.writeString(time);
        dest.writeString(id);
    }
}
