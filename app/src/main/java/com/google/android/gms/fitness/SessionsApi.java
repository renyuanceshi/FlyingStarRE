package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface SessionsApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private String zzavW;
        private Session zzavX;
        private boolean zzavY = false;

        public ViewIntentBuilder(Context context) {
            this.mContext = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
            r0 = new android.content.Intent(r5).setPackage(r4.zzavW);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.content.Intent zzl(android.content.Intent r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.zzavW
                if (r0 != 0) goto L_0x0005
            L_0x0004:
                return r5
            L_0x0005:
                android.content.Intent r0 = new android.content.Intent
                r0.<init>(r5)
                java.lang.String r1 = r4.zzavW
                android.content.Intent r0 = r0.setPackage(r1)
                android.content.Context r1 = r4.mContext
                android.content.pm.PackageManager r1 = r1.getPackageManager()
                r2 = 0
                android.content.pm.ResolveInfo r1 = r1.resolveActivity(r0, r2)
                if (r1 == 0) goto L_0x0004
                android.content.pm.ActivityInfo r1 = r1.activityInfo
                java.lang.String r1 = r1.name
                android.content.ComponentName r2 = new android.content.ComponentName
                java.lang.String r3 = r4.zzavW
                r2.<init>(r3, r1)
                r0.setComponent(r2)
                r5 = r0
                goto L_0x0004
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.SessionsApi.ViewIntentBuilder.zzl(android.content.Intent):android.content.Intent");
        }

        public Intent build() {
            zzx.zza(this.zzavX != null, (Object) "Session must be set");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(Session.getMimeType(this.zzavX.getActivity()));
            zzc.zza(this.zzavX, intent, Session.EXTRA_SESSION);
            if (!this.zzavY) {
                this.zzavW = this.zzavX.getAppPackageName();
            }
            return zzl(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.zzavW = str;
            this.zzavY = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.zzavX = session;
            return this;
        }
    }

    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);
}
