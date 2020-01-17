package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.zzd;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class zze extends zzj<zzd> {
    private Person zzbei;
    private final PlusSession zzbej;

    static final class zza implements Moments.LoadMomentsResult {
        private final Status zzUX;
        private final String zzbek;
        private final String zzbel;
        private final MomentBuffer zzbem;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzUX = status;
            this.zzbek = str;
            this.zzbel = str2;
            this.zzbem = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        public MomentBuffer getMomentBuffer() {
            return this.zzbem;
        }

        public String getNextPageToken() {
            return this.zzbek;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public String getUpdated() {
            return this.zzbel;
        }

        public void release() {
            if (this.zzbem != null) {
                this.zzbem.release();
            }
        }
    }

    static final class zzb implements People.LoadPeopleResult {
        private final Status zzUX;
        private final String zzbek;
        private final PersonBuffer zzben;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzUX = status;
            this.zzbek = str;
            this.zzben = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzbek;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzben;
        }

        public Status getStatus() {
            return this.zzUX;
        }

        public void release() {
            if (this.zzben != null) {
                this.zzben.release();
            }
        }
    }

    static final class zzc extends zza {
        private final zza.zzb<Status> zzaON;

        public zzc(zza.zzb<Status> zzb) {
            this.zzaON = zzb;
        }

        public void zzbe(Status status) {
            this.zzaON.zzs(status);
        }
    }

    static final class zzd extends zza {
        private final zza.zzb<Moments.LoadMomentsResult> zzaON;

        public zzd(zza.zzb<Moments.LoadMomentsResult> zzb) {
            this.zzaON = zzb;
        }

        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), (String) null, dataHolder.zzpZ() != null ? (PendingIntent) dataHolder.zzpZ().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaON.zzs(new zza(status, dataHolder, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.zze$zze  reason: collision with other inner class name */
    static final class C0237zze extends zza {
        private final zza.zzb<People.LoadPeopleResult> zzaON;

        public C0237zze(zza.zzb<People.LoadPeopleResult> zzb) {
            this.zzaON = zzb;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), (String) null, dataHolder.zzpZ() != null ? (PendingIntent) dataHolder.zzpZ().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaON.zzs(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends zza {
        private final zza.zzb<Status> zzaON;

        public zzf(zza.zzb<Status> zzb) {
            this.zzaON = zzb;
        }

        public void zzi(int i, Bundle bundle) {
            this.zzaON.zzs(new Status(i, (String) null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, PlusSession plusSession, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, zzf2, connectionCallbacks, onConnectionFailedListener);
        this.zzbej = plusSession;
    }

    public static boolean zzd(Set<Scope> set) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        return set.size() != 1 || !set.contains(new Scope("plus_one_placeholder_scope"));
    }

    public String getAccountName() {
        zzqI();
        try {
            return ((zzd) zzqJ()).getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzEY() {
        zzqI();
        try {
            this.zzbei = null;
            ((zzd) zzqJ()).zzEY();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzFa() {
        zzqI();
        return this.zzbei;
    }

    public zzq zza(zza.zzb<People.LoadPeopleResult> zzb2, int i, String str) {
        zzqI();
        C0237zze zze = new C0237zze(zzb2);
        try {
            return ((zzd) zzqJ()).zza(zze, 1, i, -1, str);
        } catch (RemoteException e) {
            zze.zza(DataHolder.zzbI(8), (String) null);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzbei = PersonEntity.zzv(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(zza.zzb<Moments.LoadMomentsResult> zzb2, int i, String str, Uri uri, String str2, String str3) {
        zzqI();
        zzd zzd2 = zzb2 != null ? new zzd(zzb2) : null;
        try {
            ((zzd) zzqJ()).zza(zzd2, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            zzd2.zza(DataHolder.zzbI(8), (String) null, (String) null);
        }
    }

    public void zza(zza.zzb<Status> zzb2, Moment moment) {
        zzqI();
        zzc zzc2 = zzb2 != null ? new zzc(zzb2) : null;
        try {
            ((zzd) zzqJ()).zza((zzb) zzc2, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (RemoteException e) {
            if (zzc2 == null) {
                throw new IllegalStateException(e);
            }
            zzc2.zzbe(new Status(8, (String) null, (PendingIntent) null));
        }
    }

    public void zza(zza.zzb<People.LoadPeopleResult> zzb2, Collection<String> collection) {
        zzqI();
        C0237zze zze = new C0237zze(zzb2);
        try {
            ((zzd) zzqJ()).zza((zzb) zze, (List<String>) new ArrayList(collection));
        } catch (RemoteException e) {
            zze.zza(DataHolder.zzbI(8), (String) null);
        }
    }

    public void zzd(zza.zzb<People.LoadPeopleResult> zzb2, String[] strArr) {
        zza(zzb2, (Collection<String>) Arrays.asList(strArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdS */
    public zzd zzW(IBinder iBinder) {
        return zzd.zza.zzdR(iBinder);
    }

    public void zzfG(String str) {
        zzqI();
        try {
            ((zzd) zzqJ()).zzfG(str);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public String zzgu() {
        return "com.google.android.gms.plus.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzgv() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public boolean zzmE() {
        return zzd(zzqH().zzb(Plus.API));
    }

    /* access modifiers changed from: protected */
    public Bundle zzml() {
        Bundle zzFk = this.zzbej.zzFk();
        zzFk.putStringArray("request_visible_actions", this.zzbej.zzFe());
        zzFk.putString("auth_package", this.zzbej.zzFg());
        return zzFk;
    }

    public void zzo(zza.zzb<Moments.LoadMomentsResult> zzb2) {
        zza(zzb2, 20, (String) null, (Uri) null, (String) null, "me");
    }

    public void zzp(zza.zzb<People.LoadPeopleResult> zzb2) {
        zzqI();
        C0237zze zze = new C0237zze(zzb2);
        try {
            ((zzd) zzqJ()).zza(zze, 2, 1, -1, (String) null);
        } catch (RemoteException e) {
            zze.zza(DataHolder.zzbI(8), (String) null);
        }
    }

    public zzq zzq(zza.zzb<People.LoadPeopleResult> zzb2, String str) {
        return zza(zzb2, 0, str);
    }

    public void zzq(zza.zzb<Status> zzb2) {
        zzqI();
        zzEY();
        zzf zzf2 = new zzf(zzb2);
        try {
            ((zzd) zzqJ()).zzb(zzf2);
        } catch (RemoteException e) {
            zzf2.zzi(8, (Bundle) null);
        }
    }
}
