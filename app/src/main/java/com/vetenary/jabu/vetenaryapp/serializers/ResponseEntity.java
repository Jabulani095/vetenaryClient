package com.vetenary.jabu.vetenaryapp.serializers;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class ResponseEntity implements Parcelable {
    public int statusCode;
    public String message;
    public List<AppintmentEntity> data;



    public ResponseEntity() {

    }


    protected ResponseEntity(Parcel in) {
        statusCode = in.readInt();
        message = in.readString();
        data = in.createTypedArrayList(AppintmentEntity.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(statusCode);
        dest.writeString(message);
        dest.writeTypedList(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseEntity> CREATOR = new Creator<ResponseEntity>() {
        @Override
        public ResponseEntity createFromParcel(Parcel in) {
            return new ResponseEntity(in);
        }

        @Override
        public ResponseEntity[] newArray(int size) {
            return new ResponseEntity[size];
        }
    };
}
