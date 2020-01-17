package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator<RealTimeMessage>() {
        /* renamed from: zzeu */
        public RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        /* renamed from: zzgK */
        public RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzaJR;
    private final byte[] zzaJS;
    private final int zzaJT;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String str, byte[] bArr, int i) {
        this.zzaJR = (String) zzx.zzz(str);
        this.zzaJS = (byte[]) ((byte[]) zzx.zzz(bArr)).clone();
        this.zzaJT = i;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzaJS;
    }

    public String getSenderParticipantId() {
        return this.zzaJR;
    }

    public boolean isReliable() {
        return this.zzaJT == 1;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzaJR);
        parcel.writeByteArray(this.zzaJS);
        parcel.writeInt(this.zzaJT);
    }
}
