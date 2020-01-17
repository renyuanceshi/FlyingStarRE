package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class zzli extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE = zzf.zzci("com.google.cast.games");
    /* access modifiers changed from: private */
    public static final zzl zzaaf = new zzl("GameManagerChannel");
    private final List<zzp> zzacA;
    private final String zzacB;
    /* access modifiers changed from: private */
    public final Cast.CastApi zzacC;
    /* access modifiers changed from: private */
    public final GoogleApiClient zzacD;
    /* access modifiers changed from: private */
    public zzlj zzacE;
    private boolean zzacF = false;
    private GameManagerState zzacG;
    private GameManagerState zzacH;
    private String zzacI;
    private JSONObject zzacJ;
    private long zzacK = 0;
    private GameManagerClient.Listener zzacL;
    /* access modifiers changed from: private */
    public String zzacM;
    private final Map<String, String> zzacz = new ConcurrentHashMap();
    private final SharedPreferences zzvx;

    public abstract class zza extends zzb<GameManagerClient.GameManagerResult> {
        public zza() {
            super();
            this.zzacm = new zzo(zzli.this) {
                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            zza.this.zza(new zze(new Status(i, (String) null, (PendingIntent) null), (String) null, j, (JSONObject) null));
                        } catch (ClassCastException e) {
                            zza.this.zza(zza.this.zzc(new Status(13)));
                        }
                    } else {
                        zzlk zzlk = (zzlk) obj;
                        String playerId = zzlk.getPlayerId();
                        if (i == 0 && playerId != null) {
                            String unused = zzli.this.zzacM = playerId;
                        }
                        zza.this.zza(new zze(new Status(i, zzlk.zznZ(), (PendingIntent) null), playerId, zzlk.getRequestId(), zzlk.getExtraMessageData()));
                    }
                }

                public void zzy(long j) {
                    zza.this.zza(zza.this.zzc(new Status(2103)));
                }
            };
        }

        /* renamed from: zzr */
        public GameManagerClient.GameManagerResult zzc(Status status) {
            return new zze(status, (String) null, -1, (JSONObject) null);
        }
    }

    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        protected zzo zzacm;

        public zzb() {
            super(zzli.this.zzacD);
        }

        public abstract void execute();

        /* access modifiers changed from: protected */
        public void zza(com.google.android.gms.cast.internal.zze zze) {
            execute();
        }

        public zzo zznW() {
            return this.zzacm;
        }
    }

    public abstract class zzc extends zzb<GameManagerClient.GameManagerInstanceResult> {
        /* access modifiers changed from: private */
        public GameManagerClient zzacV;

        public zzc(GameManagerClient gameManagerClient) {
            super();
            this.zzacV = gameManagerClient;
            this.zzacm = new zzo(zzli.this) {
                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            zzc.this.zza(new zzd(new Status(i, (String) null, (PendingIntent) null), zzc.this.zzacV));
                        } catch (ClassCastException e) {
                            zzc.this.zza(zzc.this.zzc(new Status(13)));
                        }
                    } else {
                        zzlk zzlk = (zzlk) obj;
                        zzlj zzod = zzlk.zzod();
                        if (zzod == null || zzf.zza("1.0.0", zzod.getVersion())) {
                            zzc.this.zza(new zzd(new Status(i, zzlk.zznZ(), (PendingIntent) null), zzc.this.zzacV));
                            return;
                        }
                        zzc.this.zza(zzc.this.zzc(new Status(GameManagerClient.STATUS_INCORRECT_VERSION, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[]{zzod.getVersion(), "1.0.0"}))));
                        zzlj unused = zzli.this.zzacE = null;
                    }
                }

                public void zzy(long j) {
                    zzc.this.zza(zzc.this.zzc(new Status(2103)));
                }
            };
        }

        /* renamed from: zzs */
        public GameManagerClient.GameManagerInstanceResult zzc(Status status) {
            return new zzd(status, (GameManagerClient) null);
        }
    }

    private static final class zzd implements GameManagerClient.GameManagerInstanceResult {
        private final Status zzUX;
        private final GameManagerClient zzacV;

        zzd(Status status, GameManagerClient gameManagerClient) {
            this.zzUX = status;
            this.zzacV = gameManagerClient;
        }

        public GameManagerClient getGameManagerClient() {
            return this.zzacV;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zze implements GameManagerClient.GameManagerResult {
        private final Status zzUX;
        private final String zzacX;
        private final long zzacY;
        private final JSONObject zzacZ;

        zze(Status status, String str, long j, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzacX = str;
            this.zzacY = j;
            this.zzacZ = jSONObject;
        }

        public JSONObject getExtraMessageData() {
            return this.zzacZ;
        }

        public String getPlayerId() {
            return this.zzacX;
        }

        public long getRequestId() {
            return this.zzacY;
        }

        public Status getStatus() {
            return this.zzUX;
        }
    }

    public zzli(GoogleApiClient googleApiClient, String str, Cast.CastApi castApi) throws IllegalArgumentException, IllegalStateException {
        super(NAMESPACE, "CastGameManagerChannel", (String) null);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        } else if (googleApiClient == null || !googleApiClient.isConnected() || !googleApiClient.hasConnectedApi(Cast.API)) {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        } else {
            this.zzacA = new ArrayList();
            this.zzacB = str;
            this.zzacC = castApi;
            this.zzacD = googleApiClient;
            Context applicationContext = googleApiClient.getContext().getApplicationContext();
            this.zzvx = applicationContext.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", new Object[]{applicationContext.getPackageName(), "game_manager_channel_data"}), 0);
            this.zzacH = null;
            this.zzacG = new zzlm(0, 0, "", (JSONObject) null, new ArrayList(), "", -1);
        }
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put("type", i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzce(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzaaf.zzf("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private void zza(zzlk zzlk) {
        boolean z = true;
        synchronized (this) {
            if (zzlk.zznY() != 1) {
                z = false;
            }
            this.zzacH = this.zzacG;
            if (z && zzlk.zzod() != null) {
                this.zzacE = zzlk.zzod();
            }
            if (isInitialized()) {
                ArrayList arrayList = new ArrayList();
                for (zzlo next : zzlk.zzoa()) {
                    String playerId = next.getPlayerId();
                    arrayList.add(new zzln(playerId, next.getPlayerState(), next.getPlayerData(), this.zzacz.containsKey(playerId)));
                }
                this.zzacG = new zzlm(zzlk.getLobbyState(), zzlk.getGameplayState(), zzlk.zzob(), zzlk.getGameData(), arrayList, this.zzacE.zznX(), this.zzacE.getMaxPlayers());
                PlayerInfo player = this.zzacG.getPlayer(zzlk.getPlayerId());
                if (player != null && player.isControllable() && zzlk.zznY() == 2) {
                    this.zzacI = zzlk.getPlayerId();
                    this.zzacJ = zzlk.getExtraMessageData();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void zza(String str, int i, JSONObject jSONObject, zzo zzo) {
        final long j = this.zzacK + 1;
        this.zzacK = j;
        JSONObject zza2 = zza(j, str, i, jSONObject);
        if (zza2 == null) {
            zzo.zza(-1, 2001, (Object) null);
            zzaaf.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        zzp zzp = new zzp(30000);
        zzp.zza(j, zzo);
        this.zzacA.add(zzp);
        zzW(true);
        this.zzacC.sendMessage(this.zzacD, getNamespace(), zza2.toString()).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzp */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    zzli.this.zzb(j, status.getStatusCode());
                }
            }
        });
    }

    private void zzb(long j, int i, Object obj) {
        Iterator<zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            if (it.next().zzc(j, i, obj)) {
                it.remove();
            }
        }
    }

    private int zzbg(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 2001;
            case 2:
                return CastStatusCodes.NOT_ALLOWED;
            case 3:
                return GameManagerClient.STATUS_INCORRECT_VERSION;
            case 4:
                return GameManagerClient.STATUS_TOO_MANY_PLAYERS;
            default:
                zzaaf.zzf("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private void zznR() throws IllegalStateException {
        synchronized (this) {
            if (!isInitialized()) {
                throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
            } else if (isDisposed()) {
                throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
            }
        }
    }

    private void zznS() {
        if (this.zzacL != null) {
            if (this.zzacH != null && !this.zzacG.equals(this.zzacH)) {
                this.zzacL.onStateChanged(this.zzacG, this.zzacH);
            }
            if (!(this.zzacJ == null || this.zzacI == null)) {
                this.zzacL.onGameMessageReceived(this.zzacI, this.zzacJ);
            }
        }
        this.zzacH = null;
        this.zzacI = null;
        this.zzacJ = null;
    }

    /* access modifiers changed from: private */
    public void zznT() {
        synchronized (this) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("castSessionId", this.zzacB);
                jSONObject.put("playerTokenMap", new JSONObject(this.zzacz));
                this.zzvx.edit().putString("save_data", jSONObject.toString()).commit();
            } catch (JSONException e) {
                zzaaf.zzf("Error while saving data: %s", e.getMessage());
            }
        }
        return;
    }

    /* access modifiers changed from: private */
    public void zznU() {
        synchronized (this) {
            String string = this.zzvx.getString("save_data", (String) null);
            if (string != null) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (this.zzacB.equals(jSONObject.getString("castSessionId"))) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("playerTokenMap");
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.zzacz.put(next, jSONObject2.getString(next));
                        }
                        this.zzacK = 0;
                    }
                } catch (JSONException e) {
                    zzaaf.zzf("Error while loading data: %s", e.getMessage());
                }
            }
        }
        return;
    }

    public void dispose() throws IllegalStateException {
        synchronized (this) {
            if (!this.zzacF) {
                this.zzacG = null;
                this.zzacH = null;
                this.zzacI = null;
                this.zzacJ = null;
                this.zzacF = true;
                try {
                    this.zzacC.removeMessageReceivedCallbacks(this.zzacD, getNamespace());
                } catch (IOException e) {
                    zzaaf.zzf("Exception while detaching game manager channel.", e);
                }
            }
        }
        return;
    }

    public GameManagerState getCurrentState() throws IllegalStateException {
        GameManagerState gameManagerState;
        synchronized (this) {
            zznR();
            gameManagerState = this.zzacG;
        }
        return gameManagerState;
    }

    public String getLastUsedPlayerId() throws IllegalStateException {
        String str;
        synchronized (this) {
            zznR();
            str = this.zzacM;
        }
        return str;
    }

    public boolean isDisposed() {
        boolean z;
        synchronized (this) {
            z = this.zzacF;
        }
        return z;
    }

    public boolean isInitialized() {
        boolean z;
        synchronized (this) {
            z = this.zzacE != null;
        }
        return z;
    }

    public void sendGameMessage(String str, JSONObject jSONObject) throws IllegalStateException {
        synchronized (this) {
            zznR();
            long j = this.zzacK + 1;
            this.zzacK = j;
            JSONObject zza2 = zza(j, str, 7, jSONObject);
            if (zza2 != null) {
                this.zzacC.sendMessage(this.zzacD, getNamespace(), zza2.toString());
            }
        }
    }

    public PendingResult<GameManagerClient.GameManagerResult> sendGameRequest(final String str, final JSONObject jSONObject) throws IllegalStateException {
        zza.C0030zza zzb2;
        synchronized (this) {
            zznR();
            zzb2 = this.zzacD.zzb(new zza() {
                public void execute() {
                    zzli.this.zza(str, 6, jSONObject, zznW());
                }
            });
        }
        return zzb2;
    }

    public void setListener(GameManagerClient.Listener listener) {
        synchronized (this) {
            this.zzacL = listener;
        }
    }

    public PendingResult<GameManagerClient.GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        zza.C0030zza zzb2;
        synchronized (this) {
            if (gameManagerClient == null) {
                throw new IllegalArgumentException("gameManagerClient can't be null.");
            }
            zzb2 = this.zzacD.zzb(new zzc(gameManagerClient) {
                public void execute() {
                    try {
                        zzli.this.zzacC.setMessageReceivedCallbacks(zzli.this.zzacD, zzli.this.getNamespace(), new Cast.MessageReceivedCallback() {
                            public void onMessageReceived(CastDevice castDevice, String str, String str2) {
                                zzli.this.zzcf(str2);
                            }
                        });
                        zzli.this.zznU();
                        zzli.this.zznT();
                        zzli.this.zza((String) null, 1100, (JSONObject) null, zznW());
                    } catch (IOException | IllegalStateException e) {
                        zznW().zza(-1, 8, (Object) null);
                    }
                }
            });
        }
        return zzb2;
    }

    public PendingResult<GameManagerClient.GameManagerResult> zza(final String str, final int i, final JSONObject jSONObject) throws IllegalStateException {
        zza.C0030zza zzb2;
        synchronized (this) {
            zznR();
            zzb2 = this.zzacD.zzb(new zza() {
                public void execute() {
                    int zzbh = zzll.zzbh(i);
                    if (zzbh == 0) {
                        zznW().zza(-1, 2001, (Object) null);
                        zzli.zzaaf.zzf("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(i));
                        return;
                    }
                    zzli.this.zza(str, zzbh, jSONObject, zznW());
                }
            });
        }
        return zzb2;
    }

    public void zzb(long j, int i) {
        zzb(j, i, (Object) null);
    }

    public String zzce(String str) throws IllegalStateException {
        String str2;
        synchronized (this) {
            str2 = str == null ? null : this.zzacz.get(str);
        }
        return str2;
    }

    public final void zzcf(String str) {
        zzaaf.zzb("message received: %s", str);
        try {
            zzlk zzi = zzlk.zzi(new JSONObject(str));
            if (zzi == null) {
                zzaaf.zzf("Could not parse game manager message from string: %s", str);
            } else if ((isInitialized() || zzi.zzod() != null) && !isDisposed()) {
                boolean z = zzi.zznY() == 1;
                if (z && !TextUtils.isEmpty(zzi.zzoc())) {
                    this.zzacz.put(zzi.getPlayerId(), zzi.zzoc());
                    zznT();
                }
                if (zzi.getStatusCode() == 0) {
                    zza(zzi);
                } else {
                    zzaaf.zzf("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzi.getStatusCode()));
                }
                int zzbg = zzbg(zzi.getStatusCode());
                if (z) {
                    zzb(zzi.getRequestId(), zzbg, zzi);
                }
                if (isInitialized() && zzbg == 0) {
                    zznS();
                }
            }
        } catch (JSONException e) {
            zzaaf.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzz(long j) {
        boolean z;
        Iterator<zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            if (it.next().zzd(j, 15)) {
                it.remove();
            }
        }
        synchronized (zzp.zzaeB) {
            Iterator<zzp> it2 = this.zzacA.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().zzoA()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }
}
