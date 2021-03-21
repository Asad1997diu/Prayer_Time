package com.studio69.namajsikkha.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Kalima implements Parcelable {

    private int title;
    private int kalimaArbi;
    private int kalimaSpell;
    private int kalimaMean;
    private int serialNumber;

    public Kalima(int title, int kalimaArbi, int kalimaSpell, int kalimaMean, int serialNumber) {
        this.title = title;
        this.kalimaArbi = kalimaArbi;
        this.kalimaSpell = kalimaSpell;
        this.kalimaMean = kalimaMean;
        this.serialNumber = serialNumber;
    }

    public Kalima() {
    }

    protected Kalima(Parcel in) {
        title = in.readInt();
        kalimaArbi = in.readInt();
        kalimaSpell = in.readInt();
        kalimaMean = in.readInt();
        serialNumber = in.readInt();
    }

    public static final Creator<Kalima> CREATOR = new Creator<Kalima>() {
        @Override
        public Kalima createFromParcel(Parcel in) {
            return new Kalima(in);
        }

        @Override
        public Kalima[] newArray(int size) {
            return new Kalima[size];
        }
    };

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getKalimaArbi() {
        return kalimaArbi;
    }

    public void setKalimaArbi(int kalimaArbi) {
        this.kalimaArbi = kalimaArbi;
    }

    public int getKalimaSpell() {
        return kalimaSpell;
    }

    public void setKalimaSpell(int kalimaSpell) {
        this.kalimaSpell = kalimaSpell;
    }

    public int getKalimaMean() {
        return kalimaMean;
    }

    public void setKalimaMean(int kalimaMean) {
        this.kalimaMean = kalimaMean;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(title);
        dest.writeInt(kalimaArbi);
        dest.writeInt(kalimaSpell);
        dest.writeInt(kalimaMean);
        dest.writeInt(serialNumber);
    }
}
